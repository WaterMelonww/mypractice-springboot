package com.wr.mypracticespringboot.controller;

import com.wr.mypracticespringboot.Service.CategoryService;
import com.wr.mypracticespringboot.VO.ResultVO;
import com.wr.mypracticespringboot.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author wangru
 *
 */
@Controller
@ResponseBody
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService service;
    @GetMapping(value = "/findall")

    public List<Category> findAll(){
        return service.findAll();
    }


    @PostMapping(value = "/save")
    public ResultVO save(Category Category){
        Category save = service.save(Category);
        if (save!=null){
            return new ResultVO(200);
        }else {
            return new ResultVO(400);
        }
    }

}
