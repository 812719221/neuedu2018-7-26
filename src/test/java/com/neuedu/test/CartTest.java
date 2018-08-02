package com.neuedu.test;

import com.neuedu.dao.CartDao;
import com.neuedu.dao.impl.mybatis.CartDaoMybatisImpl;
import com.neuedu.entity.Cart;
import com.neuedu.entity.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CartTest {

    CartDao cartDao=null;
    @Before
    public void before(){
        cartDao=new CartDaoMybatisImpl();
    }

    @Test
    public void TestAddCart(){

        Cart cart=new Cart();
        Product product=new Product( 13,"1", "1", 1.0, "1");
        cart.setProduct(product);
        cart.setProductNum(20);
        cartDao.addCart(cart);

    }
    @After
    public void destory(){
        cartDao=null;
    }




}
