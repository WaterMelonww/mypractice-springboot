package com.wr.mypracticespringboot.Service.impl;

import com.wr.mypracticespringboot.Service.CategoryService;
import com.wr.mypracticespringboot.dao.CategoryDao;
import com.wr.mypracticespringboot.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangru
 * @create 2019-09-06 16:21
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDao dao;

    @Override
    public Category save(Category productCategory) {
        return dao.save(productCategory);
    }

    @Override
    public List<Category> findAll() {
        return dao.findAll();
    }

}
