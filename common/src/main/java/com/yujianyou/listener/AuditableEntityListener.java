package com.yujianyou.listener;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.yujianyou.entity.BaseEntity;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.enterprise.inject.spi.CDI;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author jan
 */
@Slf4j
public class AuditableEntityListener {

    // 静态方式获取 JsonWebToken
    JsonWebToken jsonWebToken = CDI.current().select(JsonWebToken.class).get();

    public AuditableEntityListener() {
    }

    @PrePersist
    public void prePersist(Object target) {


        if (target instanceof BaseEntity) {
            BaseEntity entity = (BaseEntity) target;
            entity.setCreateTime(new Timestamp(DateTime.now().getTime()));

            try {
                if (ObjectUtil.isNotNull(jsonWebToken)) {
                    entity.setCreateBy(jsonWebToken.getName());
                } else {
                    entity.setCreateBy("System");
                }
            } catch (Exception e) {
                log.error("Audit error, persist {} . {}", entity.getClass().getName(), JSONUtil.toJsonStr(entity));
            }
        }


    }

    @PreUpdate
    public void preUpdate(Object target) {

        if (target instanceof BaseEntity) {
            BaseEntity entity = (BaseEntity) target;
            entity.setUpdateTime(new Timestamp(DateTime.now().getTime()));

            try {
                if (ObjectUtil.isNotNull(jsonWebToken)) {
                    entity.setUpdateBy(jsonWebToken.getName());
                } else {
                    entity.setUpdateBy("System");
                }

            } catch (Exception e) {
                log.error("Audit error, update {} . {}", entity.getClass().getName(), JSONUtil.toJsonStr(entity));
            }
        }


    }

    @PreRemove
    public void preRemove(Object o) {

    }

    @PostLoad
    public void postLoad(Object o) {

    }

    @PostRemove
    public void postRemove(Object o) {

    }

    @PostUpdate
    public void postUpdate(Object o) {

    }

    @PostPersist
    public void postPersist(Object o) {

    }
}
