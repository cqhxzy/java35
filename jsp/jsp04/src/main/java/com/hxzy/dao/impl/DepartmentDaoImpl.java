package com.hxzy.dao.impl;

import com.hxzy.dao.DepartmentDao;
import com.hxzy.entity.Department;
import com.hxzy.util.JDBCUtil;

import java.util.List;

public class DepartmentDaoImpl extends JDBCUtil implements DepartmentDao {
    @Override
    public int save(Department department) {
        String sql = "insert into department (deptId,deptName,deptAddress) values(?,?,?)";
        return super.executeUpdate(sql,new Object[]{department.getDeptId(),department.getDeptName(),department.getDeptAddress()});
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
}
