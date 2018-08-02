package com.neuedu.test;


import com.neuedu.service.OrderService;
import com.neuedu.service.impl.OrderServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrderTest {
    OrderService orderService=null;
    @Before
    public void before(){
        orderService=new OrderServiceImpl();

    }

    @Test
    public void CreateOrder(){
        orderService.createOrder();

    }
    @After
    public void destory(){
        orderService=null;
    }
}
