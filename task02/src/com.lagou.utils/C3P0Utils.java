package com.lagou.utils;



import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.*;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2021年06月30日 9:30 下午
 */
public class C3P0Utils {
   // public  static ComboPooledDataSource dataSource = new ComboPooledDataSource();
    //使用指定的配置
    public  static ComboPooledDataSource dataSource = new ComboPooledDataSource("mysql");

    //获取连接的方法
    public static Connection getConnection() throws SQLException {
        return  dataSource.getConnection();


    }
    public static void close(Connection con , PreparedStatement preparedStatement, ResultSet resultSet) {
        if (con != null && preparedStatement != null && resultSet != null) {

            try {
                resultSet.close();
                preparedStatement.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
