package com.wr.mypracticespringboot.AO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author wangru
 * @create 2019-09-18 5:05
 */
@Data
public class AddCategoryAO {
    @JsonProperty("categoryName")
    private String categoryName; //添加分类时候的分类名称

    @JsonProperty("categoryCode")
    private String  categoryCode; //添加分类时的分类类型

    @JsonProperty("createId")
    private Integer createId;  //添加类型时的创建人ID

    @JsonProperty("createName")
    private String createName;  //添加类型时的创建人姓名
}
