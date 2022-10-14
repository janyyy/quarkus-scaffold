package com.yujianyou.service.impl;


import cn.hutool.core.convert.Convert;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.SecureUtil;
import com.yujianyou.base.UploadEntity;
import com.yujianyou.dto.UserDto;
import com.yujianyou.entity.User;
import com.yujianyou.exception.BadRequestException;
import com.yujianyou.mapstruct.UserMapper;
import com.yujianyou.query.UserQuery;
import com.yujianyou.repository.UserRepository;
import com.yujianyou.service.UserService;
import com.yujianyou.utils.FileUtil;
import com.yujianyou.utils.QueryHelper;
import com.yujianyou.utils.RsaUtils;
import com.yujianyou.utils.StringUtil;
import com.yujianyou.vo.UserPassVo;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 系统用户业务实现层
 *
 * @author yujianyou
 * @since 2021-12-06 12:47:15
 */
@Slf4j
@ApplicationScoped
public class UserServiceImpl implements UserService {

    @Inject
    UserRepository userRepository;

    @ConfigProperty(name = "rsa.privateKey")
    String privateKey;

    @Inject
    UserMapper userMapper;

    @Inject
    EntityManager entityManager;


    @ConfigProperty(name = "avatar.url")
    String avatarUrl;


    /**
     * 查询列表
     *
     * @param userQuery /
     * @return /
     */
    @Override
    public Map<String, Object> queryList(UserQuery userQuery) {
        // 获取 TypedQuery
        return QueryHelper.createQuery1(entityManager, User.class, userQuery);
    }

    /**
     * 查询当前登录用户信息
     *
     * @param username /
     * @return /
     */
    @Override
    public User findCurrentUser(String username) {
        return User.find("username=?1", username).firstResult();
    }

    /**
     * 根据用户名查询
     *
     * @param userName /
     * @return /
     */
    @Override
    public User findByUserName(String userName) {
        return User.find("username=?1", userName).firstResult();
    }

    /**
     * 用户自助修改资料
     *
     * @param resources /
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void updateCenter(User resources) {
        User user = User.findById(resources.getId());
        Optional<User> phoneUser = User.find("phone =?1", user.getUsername()).singleResultOptional();
        if (phoneUser.isPresent() && !user.getId().equals(phoneUser.get().getId())) {
            throw new BadRequestException("手机号已存在");
        }
        user.setNickName(resources.getNickName());
        user.setPhone(resources.getPhone());
        user.setGender(resources.getGender());
    }

    /**
     * 密码修改
     *
     * @param userPassVo /
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void updatePass(UserPassVo userPassVo) throws Exception {
        String oldPass = SecureUtil.md5(RsaUtils.decryptByPrivateKey(privateKey, userPassVo.getOldPass()));
        String newPass = SecureUtil.md5(RsaUtils.decryptByPrivateKey(privateKey, userPassVo.getNewPass()));
        UserDto user = userMapper.toDto(findCurrentUser(userPassVo.getUserName()));

        if (!oldPass.equals(user.getPassword())) {
            throw new BadRequestException("修改失败，旧密码错误");
        }

        if (newPass.equals(user.getPassword())) {
            throw new BadRequestException("新密码不能与旧密码相同");
        }
        User.update("password=?1 where username=?2", newPass, user.getUsername());
    }

    /**
     * 密码重置
     *
     * @param userId /
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void resetPass(Long userId) throws Exception {
        User user = User.findById(userId);
        if (ObjectUtil.isNull(user)) {
            throw new BadRequestException("用户不存在");
        }
        String newPass = SecureUtil.md5("123456");
        User.update("password=?1 where username=?2", newPass, user.getUsername());
    }

    /**
     * 修改头像
     *
     * @param uploadEntity 文件
     * @return /
     */
    @Override
    @Transactional
    public Map<String, String> updateAvatar(UploadEntity uploadEntity) throws IOException {

        String image = "gif jpg png jpeg";

        // 文件转为InputStream流
        InputStream i = uploadEntity.getFile().getBody(InputStream.class, null);
        // 文件大小校验
        FileUtil.checkSize(5L, Convert.toLong(i.available()));
        // 文件类型校验
        String fileName = FileUtil.getFileNameFromInputPart(uploadEntity.getFile());
        String fileType = FileUtil.getExtensionName(fileName);
        if (fileType != null && !image.contains(fileType)) {
            throw new BadRequestException("文件格式错误！, 仅支持 " + image + " 格式");
        }
        User user = this.findByUserName(uploadEntity.getCreateBy());
        String oldPath = user.getAvatarPath();
        // 文件上传
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmssS");
        String nowStr = "-" + format.format(date);
        String saveFileName = fileName + nowStr + "." + fileType;
        String path = avatarUrl + saveFileName;
        // 文件复制
        IoUtil.copy(i, FileUtil.getOutputStream(path));
        user.setAvatarPath(path);
        user.setAvatarName(saveFileName);
        if (StringUtil.isNotBlank(oldPath)) {
            FileUtil.del(oldPath);
        }

        return new HashMap<>(1) {{
            put("avatar", saveFileName);
        }};
    }

    /**
     * 新增
     *
     * @param user /
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void add(User user) {
        Optional<User> accountUser = User.find("username =?1", user.getUsername()).singleResultOptional();
        if (accountUser.isPresent()) {
            throw new BadRequestException("用户名已存在");
        }
        Optional<User> emailUser = User.find("email =?1", user.getUsername()).singleResultOptional();
        if (emailUser.isPresent()) {
            throw new BadRequestException("邮箱已存在");
        }
        Optional<User> phoneUser = User.find("phone =?1", user.getUsername()).singleResultOptional();
        if (phoneUser.isPresent()) {
            throw new BadRequestException("手机号已存在");
        }
        userRepository.persist(user);
    }

    /**
     * 修改
     *
     * @param resources /
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void update(User resources) {
        User user = userRepository.findById(resources.getId());
        if (ObjectUtil.isNotNull(user)) {
            Optional<User> accountUser = User.find("username =?1", user.getUsername()).singleResultOptional();
            if (accountUser.isPresent() && !user.getId().equals(accountUser.get().getId())) {
                throw new BadRequestException("用户名已存在");
            }
            Optional<User> emailUser = User.find("email =?1", user.getUsername()).singleResultOptional();
            if (emailUser.isPresent() && !user.getId().equals(emailUser.get().getId())) {
                throw new BadRequestException("邮箱已存在");
            }
            Optional<User> phoneUser = User.find("phone =?1", user.getUsername()).singleResultOptional();
            if (phoneUser.isPresent() && !user.getId().equals(phoneUser.get().getId())) {
                throw new BadRequestException("手机号已存在");
            }
            user.setUsername(resources.getUsername());
            user.setEmail(resources.getEmail());
            user.setEnabled(resources.getEnabled());
            user.setRoles(resources.getRoles());
            user.setDept(resources.getDept());
            user.setJobs(resources.getJobs());
            user.setPhone(resources.getPhone());
            user.setNickName(resources.getNickName());
            user.setGender(resources.getGender());
        } else {
            log.error("查询数据库实体失败！");
        }
    }

    /**
     * 删除
     *
     * @param ids /
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void deleteAll(Set<Long> ids) {
        User.delete("id in ?1", ids);

    }


}

