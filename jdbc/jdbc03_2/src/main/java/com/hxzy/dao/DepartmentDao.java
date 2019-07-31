package com.hxzy.dao;

import com.hxzy.entity.Department;

import java.util.List;

/**
 * 对Department实体进行CRUD操作的接口
 */
public interface DepartmentDao {
    /**
     * 添加部门
     * @param department
     * @return
     */
    int save(Department department);

    /**
     * 根据编号删除部门
     * @param deptId
     * @return
     */
    int deleteById(int deptId);

    /**
     * 根据部门编号修改部门信息
     * @param department
     * @return
     */
    int update(Department department);

    /**
     * 根据部门编号查询部门信息
     * @param deptId
     * @return
     */
    Department findOne(int deptId);

    /**
     * 查询所有的部门信息
     * @return
     */
    List<Department> queryAll();
}
