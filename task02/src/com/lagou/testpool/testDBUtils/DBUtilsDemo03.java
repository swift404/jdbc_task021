package com.lagou.testpool.testDBUtils;

import com.lagou.testpool.entity.Employee;
import com.lagou.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2021年07月05日 10:38 下午
 */
public class DBUtilsDemo03 {
    /**
     *  查询id为5 的记录，封装到数组中
     *  ArrayHandler 将结果集的第一条数据封装到数组中
     *  查询所有数据，封装到List集合中
     *  arraylisthandler 可以将每条数据封装到数组中再将数组封装到集合中
     *
     */
    @Test
    public void testFindById() throws SQLException {
        //创建QuarryRunner
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        //sql
        String sql = "select *from employee where eid=?";
        Object [] query = qr.query(sql, new ArrayHandler(), 5);
        System.out.println(Arrays.toString(query));
    }
    @Test
    public void  testFindAll() throws SQLException {
        //创建QuarryRunner对象
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        //编写对象
        String sql = "select *from employee";
        //执行查询
        List<Object[]> query = qr.query(sql, new ArrayListHandler());
        //遍历集合获取数据 iter（快捷）
        for (Object[] objects : query) {
            System.out.println(Arrays.toString(objects));
        }
        }
        //查询id为5 的记录，封装到javabean中
        //BeanHandler  将结果集的第一条数据封装到javabean中
    @Test
    public void testFindByIdJavaBean() throws SQLException {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql="select * from employee where eid = ?  ";
        Employee employee = qr.query(sql, new BeanHandler<Employee>(Employee.class), 3);
        System.out.println(employee);
    }
    /**
     * 查询薪资大雨3000的所有员工信息，封装到JavaBean中再封装到List集合中
     * BeanListHandler 将结果集的每一条数据封装到JavaBean 中再将JavaBean 放到List集合中
     */
    @Test
    public void testFindBySalary() throws SQLException {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select * from employee where salary>?";
        List<Employee> query = qr.query(sql, new BeanListHandler<Employee>(Employee.class), 3000);
        for (Employee employee : query) {
            System.out.println(employee);

        }
        /**
         * 查询姓名是 张百万的员工信息 ，将结果封装到map集合中
         * MapHandler 将结果集的的第一条记录分装到Map<String，object>中  key对应的是 列名 value对应的是列的值
         *
         *
         */
    }
    @Test
        public void testFindByName() throws SQLException {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql ="select *from employee where ename=? ";
            Map<String, Object> map = qr.query(sql, new MapHandler(), "张百万");
            Set<Map.Entry<String, Object>> entries = map.entrySet();
            for (Map.Entry<String, Object> entry : entries) {
                //打印结果
                System.out.println(entry.getKey()+"="+entry.getValue());

            }

        }


    /**
     * 查询所有员工的薪资总额
     * ScalarHandler 用于封装单个的数据
      */
    @Test
    public void testGetSum() throws SQLException {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql ="select sum(salary) from employee";
        Double sum = (Double) qr.query(sql, new ScalarHandler<>());
        System.out.println(sum);
    }

    }


