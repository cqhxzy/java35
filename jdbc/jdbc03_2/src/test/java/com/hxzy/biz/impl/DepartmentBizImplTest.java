package com.hxzy.biz.impl;

import com.hxzy.biz.DepartmentBiz;
import com.hxzy.entity.Department;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
public class DepartmentBizImplTest {
    //现在这个测试类模拟的是UI层
    private DepartmentBiz biz = new DepartmentBizImpl();

    @Test
    public void save() {
        //表示层组件实体对象
        Department department = new Department(50,"全真教","桃花岛");
        int save = biz.save(department);//将实体传递给业务逻辑层
        assertThat(save,greaterThan(0));
    }

    @Test
    public void update() {
        Department department = new Department(50,"电竞部","桃花岛");
        int update = biz.update(department);
        assertThat(update,greaterThan(0));
    }

    @Test
    public void deleteById() {
        int deptId = 50; //要删除的部门编号
        int i = biz.deleteById(deptId);
        assertThat(i,greaterThan(0));
    }



    @Test
    public void findOne() {
        Department one = biz.findOne(10);//根据部门编号查询部门信息
        System.out.println(one);
        assertThat(one,notNullValue()); //期望不为null
    }

    @Test
    public void queryAll() {
        List<Department> departments = biz.queryAll();
        departments.stream().forEach(System.out::println);
        assertThat(departments.size(),greaterThan(0));
    }
}