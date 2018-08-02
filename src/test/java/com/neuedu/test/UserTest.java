package com.neuedu.test;

import com.neuedu.dao.ILoginDao;
import com.neuedu.dao.impl.mybatis.LoginMybatisImpl;
import com.neuedu.entity.Account;
import org.junit.Test;

public class UserTest {

    public void testDoLogin() {

        ILoginDao loginDao = new LoginMybatisImpl();
        loginDao.doLogin("admin2","admin2");

    }
    @Test
    public void testAddToken(){
        Account acc=new Account();
        acc.setPassword("123456");
        acc.setUsername("zhangsan");
        acc.setAccountId(12);
        ILoginDao iLoginDao=new LoginMybatisImpl();
        iLoginDao.addToken("12345677",acc);

    }
    @Test
    public void testFindTokenByAccountid(){
        ILoginDao iLoginDao=new LoginMybatisImpl();
        iLoginDao.findTokenByAccountid(1);
    }


}
