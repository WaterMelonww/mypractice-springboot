package com.wr.mypracticespringboot.controller;

import com.wr.mypracticespringboot.AO.AddProductAO;
import com.wr.mypracticespringboot.AO.SelectAO;
import com.wr.mypracticespringboot.Service.CategoryService;
import com.wr.mypracticespringboot.Service.ProductService;
import com.wr.mypracticespringboot.VO.ProductListVO;
import com.wr.mypracticespringboot.VO.ResultVO;
import com.wr.mypracticespringboot.pojo.Category;
import com.wr.mypracticespringboot.pojo.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangru
 *
 */
@Controller
@ResponseBody
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService service;

    @Autowired
    CategoryService categoryService;
    @GetMapping(value = "/findall")

    public List<Product> findAll(){
        return service.findAll();

    }


    @PostMapping(value = "/findbydinamic")
    public List<ProductListVO> findByDynamicCases(@RequestBody SelectAO selectAO){

        if(selectAO.getProductName().equals("")){
            selectAO.setProductName(null);
        }
        if(selectAO.getCategoryCode().equals("")||selectAO.getCategoryCode().equals("undefined")){
            selectAO.setCategoryCode(null);
        }

        List<Product> byDynamicCases = service.findByDynamicCases(selectAO.getProductName(),selectAO.getProductId(),selectAO.getCategoryCode(),selectAO.getProductStatus());

        List<ProductListVO> productListVOS=new ArrayList<>();
        List<Category> all = categoryService.findAll();
        for(Product p:byDynamicCases){
            ProductListVO productListVO=new ProductListVO();
            BeanUtils.copyProperties(p,productListVO);
            for(Category c:all){
                if(p.getCategoryCode().equals(c.getCategoryCode())){
                    productListVO.setCategoryName(c.getCategoryName());
                }
            }
            productListVOS.add(productListVO);
        }
        return productListVOS;
    }


    @PostMapping(value = "/save")
    public ResultVO save(@RequestBody AddProductAO addProductAO){
        Product save = service.save(addProductAO);
        if (save!=null){
            return new ResultVO(200,"添加成功");
        }else {
            return new ResultVO(400,"添加失败");
        }
    }

    @PostMapping(value = "/upload")
    @ResponseBody
    public  ResultVO FileUpload(@RequestParam("picture")MultipartFile file) throws IOException {
        String url = service.UploadImage(file);
        if (url==null){
            return new ResultVO(400,"上传失败"); //上传失败
        }
        return new ResultVO(200,url);
    }
}
