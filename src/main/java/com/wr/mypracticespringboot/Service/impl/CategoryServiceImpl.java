package com.wr.mypracticespringboot.Service.impl;

import com.wr.mypracticespringboot.AO.AddCategoryAO;
import com.wr.mypracticespringboot.AO.AmendCategoryAO;
import com.wr.mypracticespringboot.Service.CategoryService;
import com.wr.mypracticespringboot.dao.CategoryDao;
import com.wr.mypracticespringboot.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wangru
 * @create 2019-09-06 16:21
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    @Transactional
    public Category save(AddCategoryAO categoryAO){
        Category category=new Category();
        category.setCategoryCode(categoryAO.getCategoryCode());
        category.setCategoryName(categoryAO.getCategoryName());
        category.setCreateId(categoryAO.getCreateId());
        category.setCreateName(categoryAO.getCreateName());
        category.setAmendId(0);
        category.setAmendName("");
        try {
            Category save = categoryDao.save(category);
            return save;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
    @Override
    @Transactional
    public Category amend(AmendCategoryAO amendCategoryAO) {
        Category category=categoryDao.findBycategoryId(amendCategoryAO.getCategoryId());
        if(!category.getCategoryName().equals(amendCategoryAO.getCategoryName())){
            category.setCategoryName(amendCategoryAO.getCategoryName());
        }
        if(!category.getCategoryCode().equals(amendCategoryAO.getCategoryCode())){
            category.setCategoryCode(amendCategoryAO.getCategoryCode());
        }
        category.setAmendName(amendCategoryAO.getAmendName());
        category.setAmendId(amendCategoryAO.getAmendId());

        try {
            Category amend = categoryDao.save(category);
            return amend;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }


    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public Category findBycategoryCode(String categoryCode) {
        try {
            Category byCategoryCode = categoryDao.findByCategoryCode(categoryCode);
            return byCategoryCode;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    @Transactional
    public Integer delect(Integer categoryId) {
        try {
            Integer integer = categoryDao.deleteByCategoryId(categoryId);
            return integer;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }



}
