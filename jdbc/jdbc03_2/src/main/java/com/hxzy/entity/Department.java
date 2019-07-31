package com.hxzy.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * 部门的实体类，对应了数据库中的department表
 */
public class Department implements Serializable {

    private static final long serialVersionUID = -3402717281776108335L;
    /*部门编号*/
    private int deptId;
    /*部门名称*/
    private String deptName;
    /*部门地址*/
    private String deptAddress;

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", deptAddress='" + deptAddress + '\'' +
                '}';
    }

    public Department() {
    }

    public Department(int deptId, String deptName, String deptAddress) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.deptAddress = deptAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return deptId == that.deptId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptId);
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptAddress() {
        return deptAddress;
    }

    public void setDeptAddress(String deptAddress) {
        this.deptAddress = deptAddress;
    }
}