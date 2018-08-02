package com.neuedu.test;

import com.neuedu.dao.ProductDao;
import com.neuedu.dao.impl.mybatis.ProductMybatisImpl;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import org.junit.Test;

import java.util.List;


public class ProductTest {

    public void TestProduct(){
        ProductDao productDao=new ProductMybatisImpl();
        Product product=productDao.findById(2);
        System.out.println(product);
    }

    public void TestFindAllProduct(){
        ProductDao productDao=new ProductMybatisImpl();
        List<Product> list=productDao.findAll();
        System.out.println(list);
    }

    public void TestFindEmpByPage(){
        ProductDao productDao=new ProductMybatisImpl();
        PageModel pageModel=productDao.findEmpByPage(1,2);
        System.out.println(pageModel);

    }

    @Test
    //name,pdesc,price,rule,image,stock
    public void TestAddProduct(){
        ProductDao productDao=new ProductMybatisImpl();
        Product product=new Product();
        product.setId(16);
        product.setName("阿甘");
        product.setDesc("牛比");
        product.setPrice(10000.0);
        product.setRule("1*1*1*1");
        product.setImage("123");
        product.setStock(1000);
       //productDao.addProduct(product);
       productDao.updateProduct(product);
      //  productDao.deleteProduct(16);
    }


}
