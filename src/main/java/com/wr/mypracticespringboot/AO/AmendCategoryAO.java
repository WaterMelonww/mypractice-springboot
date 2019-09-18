package com.wr.mypracticespringboot.AO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author wangru
 * @create 2019-09-18 5:55
 */
@Data
public class AmendCategoryAO {

    @JsonProperty("categoryId")
    private Integer categoryId; //修改商品时的商品id

    @JsonProperty("categoryName")
    private String categoryName; //修改分类时候的分类名称

    @JsonProperty("categoryCode")
    private String  categoryCode; //修改分类时的分类类型

    @JsonProperty("amendId")
    private Integer amendId;  //修改商品时的修改人ID

    @JsonProperty("amendName")
    private String amendName;  //修改商品时的修改人姓名
}
