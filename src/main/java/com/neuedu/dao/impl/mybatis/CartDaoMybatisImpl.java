package com.neuedu.dao.impl.mybatis;

import com.neuedu.dao.CartDao;
import com.neuedu.entity.Cart;
import com.neuedu.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class CartDaoMybatisImpl implements CartDao{
    @Override
    public boolean addCart(Cart cart) {

        SqlSessionFactory sqlSessionFactory= MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        CartDao cartDao=sqlSession.getMapper(CartDao.class);
        cartDao.addCart(cart);
        sqlSession.commit();
        sqlSession.close();


        return false;
    }

    @Override
    public boolean deleteCart(int id) {
        return false;
    }

    @Override
    public boolean updataeCart(Cart cart) {
        return false;
    }

    @Override
    public List<Cart> findAllCart() {
        SqlSessionFactory sqlSessionFactory= MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        CartDao cartDao=sqlSession.getMapper(CartDao.class);
        List<Cart> list=cartDao.findAllCart();
        sqlSession.commit();
        sqlSession.close();

        return list;
    }

    @Override
    public int getCartNum() {
        return 0;
    }

    @Override
    public boolean updateCart(int id, int num) {
        return false;
    }

    @Override
    public void clearCart() {
        SqlSessionFactory sqlSessionFactory= MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        CartDao cartDao=sqlSession.getMapper(CartDao.class);
        cartDao.clearCart();
        sqlSession.commit();
        sqlSession.close();
    }
}
