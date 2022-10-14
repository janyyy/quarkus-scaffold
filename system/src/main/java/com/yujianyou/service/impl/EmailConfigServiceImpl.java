package com.yujianyou.service.impl;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.extra.mail.Mail;
import cn.hutool.extra.mail.MailAccount;
import com.yujianyou.entity.EmailConfig;
import com.yujianyou.exception.BadRequestException;
import com.yujianyou.query.EmailConfigQuery;
import com.yujianyou.repository.EmailConfigRepository;
import com.yujianyou.service.EmailConfigService;
import com.yujianyou.utils.QueryHelper;
import com.yujianyou.vo.EmailVo;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

/**
 * 邮箱配置业务实现层
 *
 * @author yujianyou
 * @since 2022-04-25 11:09:09
 */
@Slf4j
@ApplicationScoped
public class EmailConfigServiceImpl implements EmailConfigService {

    @Inject
    EmailConfigRepository emailConfigRepository;

    @Inject
    EntityManager entityManager;

    /**
     * 查询列表
     *
     * @param emailConfigQuery /
     * @return /
     */
    @Override
    public Map<String, Object> queryList(EmailConfigQuery emailConfigQuery) {

        return QueryHelper.createQuery(entityManager, EmailConfig.class, emailConfigQuery);
    }

    /**
     * 发送邮件
     *
     * @param emailVo     邮件发送的内容
     * @param emailConfig 邮件配置
     * @throws Exception /
     */
    @Override
    public void send(EmailVo emailVo, EmailConfig emailConfig) {
        if (emailConfig.getId() == null) {
            throw new BadRequestException("请先配置，再操作");
        }
        // 封装
        MailAccount account = new MailAccount();
        // 设置用户
        String user = emailConfig.getFromUser().split("@")[0];
        account.setUser(emailConfig.getUser());
        account.setHost(emailConfig.getHost());
        account.setPort(Integer.parseInt(emailConfig.getPort()));
        account.setAuth(true);
        account.setPass(emailConfig.getPass());
        account.setFrom(user + "<" + emailConfig.getFromUser() + ">");
        // ssl方式发送
        account.setSslEnable(true);

        String content = emailVo.getContent();
        // 发送
        try {
            int size = emailVo.getTos().size();
            Mail.create(account)
                    .setTos(emailVo.getTos().toArray(new String[size]))
                    .setTitle(emailVo.getSubject())
                    .setContent(content)
                    .setHtml(true)
                    //关闭session
                    .setUseGlobalSession(false)
                    .send();
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    /**
     * 新增
     *
     * @param emailConfig /
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void add(EmailConfig emailConfig) {
        emailConfigRepository.persist(emailConfig);
    }

    /**
     * 修改
     *
     * @param emailConfig /
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void update(EmailConfig emailConfig) {
        EmailConfig dataBase = emailConfigRepository.findById(emailConfig.getId());
        if (ObjectUtil.isNotNull(dataBase)) {
            // 值更新
            BeanUtil.copyProperties(emailConfig, dataBase, CopyOptions.create().setIgnoreNullValue(true));
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
    public void deleteAll(List<Long> ids) {
        emailConfigRepository.delete("id in ?1", ids);
    }


}

