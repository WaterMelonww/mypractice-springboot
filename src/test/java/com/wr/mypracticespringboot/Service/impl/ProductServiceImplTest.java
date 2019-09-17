package com.wr.mypracticespringboot.Service.impl;

import com.wr.mypracticespringboot.AO.AmendProductAO;
import com.wr.mypracticespringboot.Service.ProductService;
import com.wr.mypracticespringboot.pojo.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author wangru
 * @create 2019-08-29 10:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    private ProductService service;

    @Test
    public void findAll() {
        List<Product> all = service.findAll();
        for(Product a:all){
            System.out.println(a);
        }

    }

    @Test
    public void save() {
        Product productInfo=new Product();
        productInfo.setProductName("手工面条");
        productInfo.setProductPrice(new BigDecimal(22.5));
        productInfo.setProductIcon("D:\\work\\images\\3.jpg");
        productInfo.setProductStatus(1);

        productInfo.setCategoryCode("4");
        productInfo.setCreateId(1);
        productInfo.setCreateName("admin");
        if(productInfo.getAmendId()==null){
            productInfo.setAmendId(0);
        }
        if(productInfo.getAmendName()==null)
        {
            productInfo.setAmendName("");
        }


////        Product save = service.save(productInfo);
//        System.out.println(save);
    }

    @Test
    public void findByDynamicCases(){
        List<Product> list = service.findByDynamicCases(null, null, null, 0);
        for(Product a:list){
            System.out.println(a);
        }

    }

    @Test
    public void amend() {
        AmendProductAO amendProductAO=new AmendProductAO();
        amendProductAO.setProductId(1);
        amendProductAO.setProductName("辣子鸡");
        amendProductAO.setProductPrice(new BigDecimal(22.5));
        amendProductAO.setProductIcon("修改啦");
        amendProductAO.setProductStatus(1);
        amendProductAO.setCategoryCode("4");
        amendProductAO.setAmendId(2);
        amendProductAO.setAmendName("zhangsan");
        Product amend = service.amend(amendProductAO);
        System.out.println(amend);
    }

    @Test
    public void delect() {
        Integer delect = service.delect(1);
        System.out.println(delect);
    }
}