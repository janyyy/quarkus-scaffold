package com.yujianyou.service;


import com.yujianyou.dto.DeptDto;
import com.yujianyou.entity.Dept;
import com.yujianyou.query.DeptQuery;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 部门业务层
 *
 * @author yujianyou
 * @since 2021-11-25 15:20:53
 */
public interface DeptService {

    /**
     * 新增
     *
     * @param dept /
     */
    void add(Dept dept);

    /**
     * 修改
     *
     * @param dept /
     */
    void update(Dept dept);

    /**
     * 删除
     *
     * @param ids /
     */
    void deleteAll(Set<Long> ids);

    /**
     * 查询列表
     *
     * @param deptQuery /
     * @return /
     */
    Map<String, Object> queryList(DeptQuery deptQuery);

    /**
     * 根据ID查询
     *
     * @param id /
     * @return /
     */
    DeptDto findById(Long id);

    /**
     * 根据ID获取同级与上级数据
     *
     * @param deptDto /
     * @param depts   /
     * @return /
     */
    List<DeptDto> getSuperior(DeptDto deptDto, List<Dept> depts);

    /**
     * 构建树形数据
     *
     * @param deptDtos /
     * @return /
     */
    Object buildTree(List<DeptDto> deptDtos);

    /**
     * 查询部门
     *
     * @param deptQuery /
     * @param isQuery   /
     * @param username  /
     * @return /
     */
    Map<String, Object> queryAll(DeptQuery deptQuery, Boolean isQuery, String username) throws IllegalAccessException;

    /**
     * 获取待删除的部门
     *
     * @param deptList /
     * @param deptDtos /
     * @return /
     */
    Set<DeptDto> getDeleteDepts(List<Dept> deptList, Set<DeptDto> deptDtos);

    /**
     * 验证是否被角色或用户关联
     *
     * @param deptDtos /
     */
    void verification(Set<DeptDto> deptDtos);

    Integer countByDepts(Set<Long> deptIds);

    Integer countByDeptsRole(Set<Long> deptIds);

    /**
     * 获取
     *
     * @param deptList /
     * @return /
     */
    List<Long> getDeptChildren(List<Dept> deptList);

}

