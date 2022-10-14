package com.yujianyou.service;


import com.yujianyou.base.UploadEntity;
import com.yujianyou.entity.User;
import com.yujianyou.query.UserQuery;
import com.yujianyou.vo.UserPassVo;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * 系统用户业务层
 *
 * @author yujianyou
 * @since 2021-11-25 15:20:56
 */
public interface UserService {

    /**
     * 新增
     *
     * @param user /
     */
    void add(User user);

    /**
     * 修改
     *
     * @param user /
     */
    void update(User user);

    /**
     * 删除
     *
     * @param ids /
     */
    void deleteAll(Set<Long> ids);

    /**
     * 查询列表
     *
     * @param userQuery /
     * @return /
     */
    Map<String, Object> queryList(UserQuery userQuery);

    /**
     * 查询当前登录用户信息
     *
     * @param username /
     * @return /
     */
    User findCurrentUser(String username);

    /**
     * 根据用户名查询
     *
     * @param userName /
     * @return /
     */
    User findByUserName(String userName);

    /**
     * 用户自助修改资料
     *
     * @param resources /
     */
    void updateCenter(User resources);

    /**
     * 密码修改
     *
     * @param userPassVo /
     */
    void updatePass(UserPassVo userPassVo) throws Exception;

    /**
     * 密码重置
     *
     * @param userId /
     */
    void resetPass(Long userId) throws Exception;

    /**
     * 修改头像
     *
     * @param uploadEntity 文件
     * @return /
     */
    Map<String, String> updateAvatar(UploadEntity uploadEntity) throws IOException;


}

