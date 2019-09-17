package com.wr.mypracticespringboot.Service;

import com.wr.mypracticespringboot.pojo.Category;

import java.util.List;

/**
 * @author wangru
 * @create 2019-09-06 16:21
 */
public interface CategoryService {
    Category save(Category productCategory);
    List<Category> findAll();

}
