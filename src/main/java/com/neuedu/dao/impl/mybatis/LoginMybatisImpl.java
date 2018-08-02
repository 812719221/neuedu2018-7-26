package com.neuedu.dao.impl.mybatis;

import com.neuedu.dao.ILoginDao;
import com.neuedu.entity.Account;
import com.neuedu.utils.MyBatisUtils;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class LoginMybatisImpl implements ILoginDao {

    @Override
    public Account doLogin(String _username, String _password) {

        SqlSessionFactory sqlSessionFactory= MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        Map<String,String> map=new HashMap<String,String>();
        map.put("username",_username);
        map.put("password",_password);
        Account account=sqlSession.selectOne("com.neuedu.entity.Account.findByUsernameAndPassword",map);
        System.out.println(account);
        sqlSession.close();

        return account;
    }

    @Override
    public void addToken(String token, Account acc) {
        SqlSessionFactory sqlSessionFactory=MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("token",token);

        map.put("accountid",acc.getAccountId());

        int result=sqlSession.update("com.neuedu.entity.Account.updateToken",map);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(result);

    }

    @Override
    public String findTokenByAccountid(int accountid) {
        SqlSessionFactory sqlSessionFactory=MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        String result=sqlSession.selectOne("com.neuedu.entity.Account.findTokenByAccountid",accountid);
        sqlSession.close();
        System.out.println(result);
        return null;
    }
}
