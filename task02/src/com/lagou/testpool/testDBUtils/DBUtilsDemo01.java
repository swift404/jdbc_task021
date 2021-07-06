package com.lagou.testpool.testDBUtils;

import com.lagou.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;

import javax.management.Query;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2021年07月03日 2:35 下午
 */
public class DBUtilsDemo01 {
    //QueryRunner
    public static void main(String[] args) {
        //方式1
        QueryRunner qr = new QueryRunner();

        //方式2 自动模式
        QueryRunner qr2 =new QueryRunner(DruidUtils.getDataSource());


    }


}
