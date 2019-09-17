package com.wr.mypracticespringboot.dao;

import com.wr.mypracticespringboot.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wangru
 * @create 2019-08-29 10:04
 */

public interface CategoryDao extends JpaRepository<Category,String> {

}
