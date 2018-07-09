package com.tiantao.learn;

import com.tiantao.learn.mappers.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by tiantao on 2018/7/5.
 */
public class LearnMapper {

    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);

            SqlSession  sqlSession = sqlSessionFactory.openSession();


            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);


        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
