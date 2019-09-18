package com.wr.mypracticespringboot.controller;

import com.wr.mypracticespringboot.Service.ProductService;
import com.wr.mypracticespringboot.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author wangru
 * @create 2019-09-18 16:43
 */
@Controller
@RequestMapping("/")
public class ShowProductController {
    @Autowired
    ProductService service;
    @GetMapping(value = "show")
    public String findAll(Model model){
        List<Product> all = service.findAll();
        model.addAttribute("showproduct",all);
        System.out.println(model);
        return "shop";
    }
}
