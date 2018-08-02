package com.neuedu.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatisUtils {

    private static SqlSessionFactory sqlSessionFactory=null;

    static{
        String resource="mybatis-config.xml";
        Reader reader=null;
        try {
            reader= Resources.getResourceAsReader(resource);
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ��ȡsqlSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }

    /**
     * �ر�sqlSessionFactory
     */
    public static void close(SqlSession sqlSession){
        sqlSession.close();
    }
}
