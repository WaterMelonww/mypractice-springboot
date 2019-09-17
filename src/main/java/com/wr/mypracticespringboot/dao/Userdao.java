package com.wr.mypracticespringboot.dao;

import com.wr.mypracticespringboot.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wangru
 * @create 2019-08-28 11:04
 */
public interface Userdao extends JpaRepository<User,Integer> {
    User findByUsername(String username);
    User getByUsernameAndPassword(String username,String password);
    }
