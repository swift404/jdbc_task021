package com.lagou.testpool.testDBUtils;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2021年07月03日 8:39 下午
 */

import com.lagou.utils.DruidUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 使用QueryRunner对象完成增删改
 * update
 */
public class DBUtils02 {

   @Test
    public void testInsert() throws SQLException {
        //1.创建QueryRunner 手动模式创建
        QueryRunner qr = new QueryRunner();
        //2.编写占位符的参数
        String sql = "insert into employee values(?,?,?,?,?,?)";
        //3。设置占位符的参数
        Object[] param = {null,"张百万",20,"女",10000,"1990-12-16"};
        //4.执行update方法
        Connection con= DruidUtils.getConnection();

        int i = qr.update(con, sql, param);
       System.out.println();
        //5.释放资源
       DbUtils.closeQuietly(con);
    }
    @Test
    public void testUpdate() throws SQLException {
       //1.创建 核心类  自动模式 需要传递数据库连接池对象
       QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
       //编写2.sql
        String sql = "update employee set salary =? where ename=?";
        Object[] param = {15000,"张百万"};
        qr.update(sql,param);
    }

    @Test
    public void testDelete() throws SQLException {
       QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
       String sql="delete from employee where eid=? ";
       qr.update(sql,1);
    }

}
