package com.wr.mypracticespringboot.Service;

import com.wr.mypracticespringboot.AO.AddProductAO;
import com.wr.mypracticespringboot.pojo.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author wangru
 * @create 2019-08-29 10:12
 */
public interface ProductService {
    List<Product> findAll();
    Product save(AddProductAO addProductAO);
    List<Product> findByDynamicCases(String productName ,Integer productId,String categoryCode,Integer productStatus);
    String UploadImage(MultipartFile  file) throws IOException;
}
