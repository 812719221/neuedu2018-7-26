package com.neuedu.dao.impl.mybatis;

import com.neuedu.dao.ProductDao;
import com.neuedu.entity.PageMo;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ProductDaoMybatis implements ProductDao{
    @Override
    public boolean addProduct(Product product) {
        return false;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public boolean updateProduct(Product product) {
        SqlSessionFactory sqlSessionFactory= MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        ProductDao productDao=sqlSession.getMapper(ProductDao.class);
        productDao.updateProduct(product);
        sqlSession.commit();
        sqlSession.close();

        return false;
    }

    @Override
    public boolean deleteProduct(int id) {
        return false;
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public PageModel<Product> findEmpByPage(int pageNo, int pageSize) {
        return null;
    }

    @Override
    public PageMo<Product> findProductByPage(int pageNo, int pageSize) {
        return null;
    }
}
