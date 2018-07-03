package com.tiantao.demo;

import com.tiantao.mybatis.datasource.pooled.PooledDataSource;
import com.tiantao.mybatis.datasource.unpooled.UnPooledDataSource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by tiantao on 2018/6/28.
 */
public class DataSourceDemo {


    String dataSourceType = "";

    Properties properties = null;

    private DataSource getDataSource(String type){

        DataSource dataSource =null;

        if ("pooled".equals(type)){
             dataSource = new PooledDataSource();
        }else if ("unpooled".equals(type)){
             dataSource = new UnPooledDataSource();
        }else if ("jndi".equals(type)){

        }

        return dataSource;
    }

}
