package com.yujianyou.service.impl;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ObjectUtil;
import com.yujianyou.entity.Job;
import com.yujianyou.exception.BadRequestException;
import com.yujianyou.query.JobQuery;
import com.yujianyou.repository.JobRepository;
import com.yujianyou.service.JobService;
import com.yujianyou.utils.QueryHelper;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * 岗位业务实现层
 *
 * @author yujianyou
 * @since 2021-12-06 12:47:36
 */
@Slf4j
@ApplicationScoped
public class JobServiceImpl implements JobService {

    @Inject
    JobRepository jobRepository;

    @Inject
    EntityManager entityManager;

    /**
     * 查询列表
     *
     * @param jobQuery /
     * @return /
     */
    @Override
    public Map<String, Object> queryList(JobQuery jobQuery) {
        // 获取 TypedQuery
        return QueryHelper.createQuery(entityManager, Job.class, jobQuery);
    }

    /**
     * 验证是否被用户关联
     *
     * @param ids /
     */
    @Override
    public void verification(Set<Long> ids) {

        String sql = "SELECT count(1) FROM system.sys_user u, system.sys_users_jobs j WHERE u.user_id = j.user_id AND j.job_id IN ?1";
        Integer countByJobsNumber = Convert.toInt(entityManager.createNativeQuery(sql).setParameter(1, ids).getSingleResult());

        if (countByJobsNumber > 0) {
            throw new BadRequestException("所选的岗位中存在用户关联，请解除关联再试！");
        }
    }

    /**
     * 新增
     *
     * @param job /
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void add(Job job) {
        Optional<Job> dataBase = Job.find("name =?1", job.getName()).singleResultOptional();
        if (dataBase.isPresent()) {
            throw new BadRequestException("岗位名称已存在！");
        }
        jobRepository.persist(job);
    }

    /**
     * 修改
     *
     * @param job /
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void update(Job job) {
        Job dataBase = jobRepository.findById(job.getId());
        Optional<Job> old = Job.find("name =?1", job.getName()).singleResultOptional();
        if (old.isPresent() && !old.get().getId().equals(job.getId())) {
            throw new BadRequestException("岗位名称已存在");
        }
        if (ObjectUtil.isNotNull(dataBase)) {
            // 值更新
            BeanUtil.copyProperties(job, dataBase, CopyOptions.create().setIgnoreNullValue(true));
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
        Job.delete("id in ?1", ids);
    }


}

