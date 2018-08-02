package com.neuedu.dao.impl.mybatis;

import com.neuedu.dao.CategoryDao;
import com.neuedu.entity.Category;
import com.neuedu.entity.PageMo;
import com.neuedu.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class CategoryMybatis implements CategoryDao{
    @Override
    public boolean addCategory(Category category) {
        SqlSessionFactory sqlSessionFactory= MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        sqlSession.insert("com.neuedu.entity.Category.addCategory",category);
        sqlSession.commit();
        sqlSession.close();
        return false;
    }

    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public boolean updateCategory(Category category) {
        return false;
    }

    @Override
    public boolean deleteCategory(int id) {
        return false;
    }

    @Override
    public Category findById(int id) {
        return null;
    }

    @Override
    public PageMo<Category> findCategoryByPage(int pageNo, int pageSize) {
        return null;
    }
}
