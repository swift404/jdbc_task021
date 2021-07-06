package com.lagou.testpool;

import com.lagou.utils.DruidUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2021年07月03日 12:30 下午
 */
public class TestDruid {
    public static void main(String[] args) throws SQLException {
        Connection con  = DruidUtils.getConnection();
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("select *from employee where salary between 3000 and 5000");

        while (resultSet.next()){
            String ename = resultSet.getString("ename");
            System.out.println(ename);
        }
        DruidUtils.close(con,statement,resultSet);
    }



}
