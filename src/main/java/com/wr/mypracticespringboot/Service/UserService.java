package com.wr.mypracticespringboot.Service;

import com.wr.mypracticespringboot.dao.Userdao;
import com.wr.mypracticespringboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangru
 * @create 2019-08-28 11:07
 */
@Service
public class UserService {
    @Autowired
    Userdao userdao;


//    public boolean isExit(String username) {
//       User user=getByName(username);
//       return null!=user;
//    }

    public User getByName(String username){
        return userdao.findByUsername(username);
    }

    public User get(String username,String password){
        return userdao.getByUsernameAndPassword(username,password);
    }

    public void add(User user){
        userdao.save(user);
    }
}
