package com.wr.mypracticespringboot.AO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author wangru
 * @create 2019-09-12 14:32
 */
@Data
public class AddProductAO {
    @JsonProperty("productname")
    private String  productName; //添加商品时的商品名称

    @JsonProperty("productprice")
    private BigDecimal productPrice; //添加商品时的商品价格

    @JsonProperty("producticon")
    private String productIcon; //添加商品时的商品图片地址

    @JsonProperty("productcategory")
    private String categoryCode; //添加商品时的商品类型

    @JsonProperty("createId")
    private Integer createId;  //添加商品时的创建人ID

    @JsonProperty("createName")
    private String createName;  //添加商品时的创建人姓名

}
