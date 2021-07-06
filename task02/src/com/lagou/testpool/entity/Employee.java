package com.lagou.testpool.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2021年07月03日 2:27 下午
 */

/**
 * javaBean 类
 *      用来存储数据，成员变量私有 提供 get set 提供空参 是西安序列化接口
 *      eid INT PRIMARY KEY AUTO_INCREMENT ,
 * ename VARCHAR (20), -- 员工姓名
 * age INT , -- 员工年龄
 * sex VARCHAR (6), -- 员工性别
 * salary DOUBLE , -- 薪水
 * empdate DATE -- 入职日期
 * );
 */




public class Employee implements Serializable {
    private int eid;
    private String ename;
    private int age;
    private String sex;
    private Double salary;
    private Date empdate;

    public Employee() {
    }

    public Employee(int eid, String ename, int age, String sex, Double salary, Date empdate) {
        this.eid = eid;
        this.ename = ename;
        this.age = age;
        this.sex = sex;
        this.salary = salary;
        this.empdate = empdate;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getEmpdate() {
        return empdate;
    }

    public void setEmpdate(Date empdate) {
        this.empdate = empdate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", salary=" + salary +
                ", empdate=" + empdate +
                '}';
    }
}
