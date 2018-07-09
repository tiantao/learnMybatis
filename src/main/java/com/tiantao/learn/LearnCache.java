package com.tiantao.learn;

import com.tiantao.learn.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Hello world!
 *
 */
public class LearnCache
{
    public static void main( String[] args )
    {
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            User user = sqlSession.selectOne("selectUser",1L);
            sqlSession.commit(); //这里从网上看到的，的确是不加commit不行，还以为存到别的地方了呢。
            SqlSession sqlSession1 = sqlSessionFactory.openSession();
            sqlSession1.selectOne("selectUser",1L);
            user.setName("autotester1");
            sqlSession.update("updateUserName",user);
            user = sqlSession.selectOne("selectUser",1L);
            System.out.println(user.getName());
            //UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //System.out.println(userMapper);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
