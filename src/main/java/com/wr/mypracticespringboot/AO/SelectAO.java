package com.wr.mypracticespringboot.AO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author wangru
 * @create 2019-09-11 9:27
 */
@Data
public class SelectAO {
    @JsonProperty("selectname")
    private String productName;  //动态查询条件中的商品名

    @JsonProperty("selectid")
    private Integer productId;   //动态查询条件中的商品ID

    @JsonProperty("selectStatus")
    private Integer productStatus; //动态查询条件中的商品状态 0上架 1下架

    @JsonProperty("selectCode")
    private String categoryCode; //动态查询条件中的商品状态

}
