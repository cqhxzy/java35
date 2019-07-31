package com.hxzy.biz.impl;

import com.hxzy.biz.DepartmentBiz;
import com.hxzy.dao.DepartmentDao;
import com.hxzy.dao.impl.DepartmentDaoImpl;
import com.hxzy.entity.Department;

import java.util.List;

public class DepartmentBizImpl implements DepartmentBiz {

    //业务逻辑层调用数据访问层
    private DepartmentDao departmentDao = new DepartmentDaoImpl();

    @Override
    public int save(Department department) {
        return departmentDao.save(department);
    }

    @Override
    public int deleteById(int deptId) {
        return departmentDao.deleteById(deptId);
    }

    @Override
    public int update(Department department) {
        return departmentDao.update(department);
    }

    @Override
    public Department findOne(int deptId) {
        return departmentDao.findOne(deptId);
    }

    @Override
    public List<Department> queryAll() {
        return departmentDao.queryAll();
    }
}
