package com.wr.mypracticespringboot.dao;

import com.wr.mypracticespringboot.pojo.Product;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author wangru
 * @create 2019-08-29 10:04
 */

public interface ProductDao extends JpaRepository<Product,String>,JpaSpecificationExecutor<Product> {
    List<Product> findAll(Specification<Product> specification);
}
