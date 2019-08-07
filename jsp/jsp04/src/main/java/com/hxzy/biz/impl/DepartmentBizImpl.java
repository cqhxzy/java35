package com.hxzy.biz.impl;

import com.hxzy.biz.DepartmentBiz;
import com.hxzy.dao.DepartmentDao;
import com.hxzy.dao.impl.DepartmentDaoImpl;
import com.hxzy.entity.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DepartmentBizImpl implements DepartmentBiz {

    //业务逻辑层调用数据访问层
    private DepartmentDao departmentDao = new DepartmentDaoImpl();
    private Logger logger = LoggerFactory.getLogger(DepartmentBizImpl.class);

    @Override
    public boolean save(Department department) {
        return departmentDao.save(department) > 0;
    }

    @Override
    public boolean deleteById(int deptId) {
        return departmentDao.deleteById(deptId) > 0;
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

    @Override
    public boolean batchRemoveDept(String[] deptIds) {
        logger.debug("执行批量删除：" + Arrays.toString(deptIds));
        List<Integer> collect = Arrays.stream(deptIds).map(Integer::parseInt).collect(Collectors.toList());
        Integer[] objects = collect.toArray(new Integer[0]);


        int i = departmentDao.batchRemoveDept(objects);
        return i == deptIds.length;
    }
}
