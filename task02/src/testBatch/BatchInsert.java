package testBatch;

import com.lagou.utils.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2021年07月06日 8:16 下午
 */
public class BatchInsert {
    //使用批处理 向表中添加10000条数据
    public static void main(String[] args) throws SQLException {
    Connection connection= DruidUtils.getConnection();
        PreparedStatement ps = connection.prepareStatement("insert into testBatch(uname) values(?)");
        //3.执行批量插入操作
        for (int i =0 ;i<10000;i++){
            ps.setString(1,"小强"+i);
            //将sql添加到批处理列表
            ps.addBatch();
        }
        //添加时间戳 测试执行效率


        long start = System.currentTimeMillis();
        //4.统一执行批量插入
        ps.executeBatch();

        long end = System.currentTimeMillis();
        System.out.println(end-start+"毫秒");
        //关闭连接
        DruidUtils.close(connection,ps);
    }

}
