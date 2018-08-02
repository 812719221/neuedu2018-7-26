package com.neuedu.dao.impl.mybatis;

import com.neuedu.dao.ProductDao;
import com.neuedu.entity.PageMo;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductMybatisImpl implements ProductDao{

    @Override
    public boolean addProduct(Product product) {
        SqlSessionFactory sqlSessionFactory=MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        int result=sqlSession.insert("com.neuedu.entity.Product.addProduct",product);
        sqlSession.commit();
        System.out.println(result);
        return true;
    }

    @Override
    public List<Product> findAll() {

        SqlSessionFactory sqlSessionFactory=MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        List<Product> list=sqlSession.selectList("com.neuedu.entity.Product.findAllProduct");
        return list;
    }

    @Override
    public boolean updateProduct(Product product) {

        SqlSessionFactory sqlSessionFactory=MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        int a =sqlSession.update("com.neuedu.entity.Product.updateProduct",product);
        System.out.println(a);
        sqlSession.commit();
        sqlSession.close();
        return true;
    }

    @Override
    public boolean deleteProduct(int id) {
        SqlSessionFactory sqlSessionFactory=MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        int a=sqlSession.delete("com.neuedu.entity.Product.deleteProduct",id);
        System.out.println(a);
        sqlSession.commit();
        sqlSession.close();
        return false;
    }

    @Override
    public Product findById(int id) {
        SqlSessionFactory sqlSessionFactory=MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        Product product=sqlSession.selectOne("com.neuedu.entity.Product.findById",id);
        sqlSession.close();
        return product;
    }

    @Override
    public PageModel<Product> findEmpByPage(int pageNo, int pageSize) {

        SqlSessionFactory sqlSessionFactory=MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //查询总页数
        int totalcount=sqlSession.selectOne("com.neuedu.entity.Product.findTotalPage");
        //查询某页的数据
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("offSet",(pageNo-1)*pageSize);
        map.put("pageSize",pageSize);
        List<Product> list=sqlSession.selectList("com.neuedu.entity.Product.findProductByPage",map);

        PageModel<Product> pageModel=new PageModel<Product>();
        pageModel.setTotalPage((totalcount%pageSize)==0?totalcount/pageSize:(totalcount/pageSize)+1);
        pageModel.setData(list);

        return pageModel;
    }

    @Override
    public PageMo<Product> findProductByPage(int pageNo, int pageSize) {
        return null;
    }


}
