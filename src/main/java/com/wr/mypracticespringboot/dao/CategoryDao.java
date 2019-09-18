package com.wr.mypracticespringboot.dao;

import com.wr.mypracticespringboot.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wangru
 * @create 2019-08-29 10:04
 */

@Repository
public interface CategoryDao extends JpaRepository<Category,String> {
    Category findByCategoryCode(String CategoryCode );
    Category findBycategoryId(Integer categoryId);
    Integer deleteByCategoryId(Integer categoryId);
}
