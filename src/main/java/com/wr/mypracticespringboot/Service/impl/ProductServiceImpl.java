package com.wr.mypracticespringboot.Service.impl;

import com.wr.mypracticespringboot.AO.AddProductAO;
import com.wr.mypracticespringboot.Service.ProductService;
import com.wr.mypracticespringboot.dao.ProductDao;
import com.wr.mypracticespringboot.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wangru
 * @create 2019-08-29 10:16
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;


    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Product save(AddProductAO addProductAO) {

        Product product=new Product();
        product.setProductName(addProductAO.getProductName());
        product.setProductPrice(addProductAO.getProductPrice());
        product.setProductIcon("http://"+addProductAO.getProductIcon());
        product.setProductStatus(0);
        product.setCategoryCode(addProductAO.getCategoryCode());
        product.setCreateId(addProductAO.getCreateId());
        product.setCreateName(addProductAO.getCreateName());
        product.setAmendId(0);
        product.setAmendName("");
        return productDao.save(product);
    }


    @Override
    public List<Product> findByDynamicCases(String productName ,Integer productId,String categoryCode,Integer productStatus) {
        List<Product> list = productDao.findAll(new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                //混合条件查询
               List<Predicate> predicates=new ArrayList<>();
               if(productName!=null){
                   predicates.add(cb.like(root.get("productName").as(String.class),"%"+productName+"%"));
               }
               if(productId!=null){
                   predicates.add(cb.equal(root.get("productId").as(Integer.class),productId));
               }
                if(categoryCode!=null){
                    predicates.add(cb.equal(root.get("categoryCode").as(String.class),categoryCode));
                }
                if(productStatus!=null){
                    predicates.add(cb.equal(root.get("productStatus").as(Integer.class),productStatus));
                }

                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
        return list;
    }


//    private static  final  List<String> CONTENT_TYPE=Arrays.asList("image/jpeg","image/png");
    @Override
    public String UploadImage(MultipartFile file) throws IOException {

        //校验文件内容
        BufferedImage read = ImageIO.read(file.getInputStream());
        if(read==null){
            return "文件内容不合法";
        }

        //保存到文件服务器
        //返回url进行回显
        String storepath="D:\\work\\test\\image";
        File dir=new File(storepath);
        if(!dir.exists()){
            dir.mkdirs();
        }
        try {
            SimpleDateFormat df=new SimpleDateFormat("yyMMddHHmmSS");
            String filename= df.format(new Date())+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")).toLowerCase();
            File fileServer =new File(dir,filename);

            System.out.println(file.getOriginalFilename());
            System.out.println(fileServer.getAbsolutePath());
            file.transferTo(fileServer);
            return "localhost:90/"+filename;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "上传失败";
    }

}
