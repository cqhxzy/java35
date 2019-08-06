package com.hxzy.dao.impl;

import com.hxzy.dao.DepartmentDao;
import com.hxzy.entity.Department;
import com.hxzy.util.JDBCUtil;

import java.util.List;

public class DepartmentDaoImpl extends JDBCUtil implements DepartmentDao {
    @Override
    public int save(Department department) {
        String sql = "insert into department (deptName,deptAddress) values(?,?)";
        return super.executeUpdate(sql,new Object[]{department.getDeptName(),department.getDeptAddress()});
    }

    @Override
    public int deleteById(int deptId) {
        String sql = "delete from department where deptId = ?";
        return super.executeUpdate(sql,deptId);
    }

    @Override
    public int update(Department department) {
        String sql = "update department set deptName=?,deptAddress=? where deptId = ?";
        return super.executeUpdate(sql,new Object[]{department.getDeptName(),department.getDeptAddress(),department.getDeptId()});
    }

    @Override
    public Department findOne(int deptId) {
        String sql = "select deptId,deptName,deptAddress from department where deptId=?";

        List<Department> departments = super.queryAll(Department.class, sql, deptId);

        return departments.size() > 0 ? departments.get(0) : null;
    }

    @Override
    public List<Department> queryAll() {
        String sql = "select deptId,deptName,deptAddress from department";
        return super.queryAll(Department.class,sql);
    }

    @Override
    public int batchRemoveDept(Integer[] deptIds) {
        super.startTransaction(); //开启事务
        int count = 0;
        try {
            for (int i = 0; i < deptIds.length; i++) {
                count += this.deleteById(deptIds[i]);
            }
            super.commit(); //整体提交事务
        } catch (Exception e){
            super.rollback();
        } finally {
            super.endTransaction(); //关闭事务
        }
        return count;
    }
}
