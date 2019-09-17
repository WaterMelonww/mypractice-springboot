package com.wr.mypracticespringboot.controller;

import com.wr.mypracticespringboot.Service.UserService;
import com.wr.mypracticespringboot.VO.ResultVO;
import com.wr.mypracticespringboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

/**
 * @author wangru
 * @create 2019-08-27 19:53
 */
@Controller
public class LoginController {
    @Autowired
    UserService userService;
    @CrossOrigin  //允许跨域访问
    @PostMapping(value = "/login")
    @ResponseBody
    public ResultVO login(@RequestBody User requestUser){
        String username=requestUser.getUsername();
        username=HtmlUtils.htmlEscape(username);
        User user=userService.get(username,requestUser.getPassword());
        if(null==user){
            return new ResultVO(400,user.getId());
        }else {
            return new ResultVO(200,user.getId());
        }
    }
}
