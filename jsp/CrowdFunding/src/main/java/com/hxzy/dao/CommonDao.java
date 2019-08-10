package com.hxzy.dao;

import java.util.List;
import java.util.Map;

public interface CommonDao<T> {
    /**
     * 通用的新增的方法
     * @param t
     * @return
     */
    int save(T t);

    /**
     * 通用的修改的方法
     * @param t
     * @return
     */
    int update(T t);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 根据id查询一条数据
     */
    T findById(Integer id);


}
