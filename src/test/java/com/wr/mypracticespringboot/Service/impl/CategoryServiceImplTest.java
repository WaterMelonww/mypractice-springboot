package com.wr.mypracticespringboot.Service.impl;

import com.wr.mypracticespringboot.Service.CategoryService;
import com.wr.mypracticespringboot.pojo.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wangru
 * @create 2019-09-06 16:30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {
    @Autowired
    CategoryService service;

    @Test
    public void save() {
        Category pc=new Category();
        pc.setCategoryName("开胃可口饭菜");
        pc.setCategoryCode("1");
        pc.setCreateId(1);
        pc.setAmendId(1);
        pc.setCreateName("admin");
        pc.setAmendName("admin");
//        service.save();
    }

    @Test
    public void findAll() {
        System.out.println(service.findAll());
    }
}