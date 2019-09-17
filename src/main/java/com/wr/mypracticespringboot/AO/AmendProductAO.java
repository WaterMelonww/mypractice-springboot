package com.wr.mypracticespringboot.AO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author wangru
 * @create 2019-09-17 13:50
 */

@Data
public class AmendProductAO {

    @JsonProperty("productId")
    private Integer productId; //修改商品时的商品id

    @JsonProperty("productName")
    private String  productName; //修改商品时的商品名称

    @JsonProperty("productPrice")
    private BigDecimal productPrice; //修改商品时的商品价格

    @JsonProperty("productIcon")
    private String productIcon; //修改商品时的商品图片地址

    @JsonProperty("productStatus")
    private Integer productStatus; //修改商品时的商品状态

    @JsonProperty("categoryCode")
    private String categoryCode; //修改商品时的商品类型

    @JsonProperty("amendId")
    private Integer amendId;  //修改商品时的修改人ID

    @JsonProperty("amendName")
    private String amendName;  //修改商品时的修改人姓名
}
