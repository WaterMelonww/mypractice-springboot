package com.wr.mypracticespringboot.Service;

import com.wr.mypracticespringboot.AO.AddCategoryAO;
import com.wr.mypracticespringboot.AO.AmendCategoryAO;
import com.wr.mypracticespringboot.pojo.Category;

import java.util.List;

/**
 * @author wangru
 * @create 2019-09-06 16:21
 */
public interface CategoryService {
    Category save(AddCategoryAO addCategoryAO);
    List<Category> findAll();
    Category findBycategoryCode(String categoryCode);

    Category amend(AmendCategoryAO amendCategoryAO);

    Integer delect(Integer categoryId);
}
