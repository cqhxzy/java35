package com.hxzy.biz;

public interface CommonBiz<T> {
    /**
     * 通用的新增的方法
     * @param t
     * @return
     */
    boolean save(T t);

    /**
     * 通用的修改的方法
     * @param t
     * @return
     */
    boolean update(T t);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    boolean deleteById(Integer id);

    /**
     * 根据id查询一条数据
     */
    T findById(Integer id);
}
