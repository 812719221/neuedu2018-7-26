package com.neuedu.dao.impl.mybatis;

import com.neuedu.dao.OrderDao;
import com.neuedu.entity.UserOrder;
import com.neuedu.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class OrderMybatisImpl implements OrderDao{
    @Override
    public boolean createOrder(UserOrder userOrder) {
        SqlSessionFactory sqlSessionFactory= MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        OrderDao orderDao=sqlSession.getMapper(OrderDao.class);
        orderDao.createOrder(userOrder);
        sqlSession.commit();
        sqlSession.close();
        return false;
    }

    @Override
    public int generateOrderId() {
        return 0;
    }
}
