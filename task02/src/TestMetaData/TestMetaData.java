package TestMetaData;

import com.lagou.utils.DruidUtils;
import org.junit.Test;

import java.sql.*;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2021年07月06日 8:53 下午
 */
public class TestMetaData {
    //1.获取数据库相关的元数据信息 使用DatabaseMetaData
    @Test
    public void testDataBaseMeta() throws SQLException {
        //1.获取数据库连接对象 connection】
        Connection con = DruidUtils.getConnection();
        //获取代表数据库的 元数据对象 DatabaseMetaData

        DatabaseMetaData metaData = con.getMetaData();
        //3.获取数据库相关的元数据信息
        String url = metaData.getURL();
        System.out.println("数据库url："+url);

        String userName = metaData.getUserName();
        System.out.println("当前用户"+userName);

        String databaseProductVersion = metaData.getDatabaseProductVersion();
        System.out.println("数据库版本"+databaseProductVersion);


        String databaseProductName = metaData.getDatabaseProductName();
        System.out.println("s数据库产品名"+databaseProductName);

        String driverName = metaData.getDriverName();
        System.out.println("驱动名称"+driverName);

    //判断当前数据库是否只允许只读

        boolean b = metaData.isReadOnly();
        if (b){
            System.out.println("只读");
        }else {
            System.out.println("不是只读");
        }





        con.close();
    }
    //2.
        //获取结果集中的元数据信息
    @Test
    public void testResultSetMetaData() throws SQLException {
        Connection con =DruidUtils.getConnection();
        PreparedStatement ps = con.prepareStatement("select *from employee");

        ResultSet resultSet = ps.executeQuery();
        ResultSetMetaData metaData = ps.getMetaData();
        int count= metaData.getColumnCount();
        System.out.println("当前结果集中共有："+count+"列");


        for (int i=1;i<=count;i++){
            String columnName = metaData.getColumnName(i);
            System.out.println("列名是："+columnName);

            String columnTypeName = metaData.getColumnTypeName(i);
            System.out.println(columnTypeName);
        }
        //释放资源
        DruidUtils.close(con,ps,resultSet);
    }
}
