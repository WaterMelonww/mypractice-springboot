package com.wr.mypracticespringboot.controller;

import com.wr.mypracticespringboot.AO.AddCategoryAO;
import com.wr.mypracticespringboot.AO.AmendCategoryAO;
import com.wr.mypracticespringboot.Service.CategoryService;
import com.wr.mypracticespringboot.VO.ResultVO;
import com.wr.mypracticespringboot.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/byCategoryCode")
    public ResultVO findbyCategoryCode(@RequestBody  AddCategoryAO categoryAO){
        System.out.println(categoryAO.getCategoryCode());
        Category bycategoryCode = service.findBycategoryCode(categoryAO.getCategoryCode());
        if(bycategoryCode!=null){
            return new ResultVO(200,"该类型已存在");
        }else {
            return new ResultVO(400,"可以添加");
        }
    }


    @PostMapping(value = "/delect")
    public ResultVO delect(@RequestBody AmendCategoryAO amendCategoryAO){
        System.out.println(amendCategoryAO.getCategoryId());
        Integer delect = service.delect(amendCategoryAO.getCategoryId());
        if(delect!=null) {
            return new ResultVO(200);
        }else {
            return new ResultVO(400);
        }
    }
    @PostMapping(value = "/save")
    public ResultVO save(@RequestBody AddCategoryAO addCategoryAO){
        Category save = service.save(addCategoryAO);
        if (save!=null){
            return new ResultVO(200,"添加成功");
        }else {
            return new ResultVO(400,"添加失败");
        }
    }

    @PostMapping(value = "/amendCategory")
    public ResultVO amend(@RequestBody AmendCategoryAO amendCategoryAO){
        Category save = service.amend(amendCategoryAO);
        if (save!=null){
            return new ResultVO(200,"修改成功");
        }else {
            return new ResultVO(400,"修改失败");
        }
    }

}
