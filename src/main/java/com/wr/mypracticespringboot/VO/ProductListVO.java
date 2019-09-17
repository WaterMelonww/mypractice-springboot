package com.wr.mypracticespringboot.VO;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wangru
 * @create 2019-09-16 20:01
 */
@Data
public class ProductListVO {
    private Integer productId; //商品id

    private String productName;//商品名称

    private BigDecimal productPrice;//商品价格

    private String productIcon; //商品图片

    private Integer productStatus; //商品状态 状态0正常  1下架
    //类目编号

    private String  categoryName; //商品类型

    private Date creatTime; //创建时间
    private Date updateTime; //更新时间

    private String createName; //创建人名称
    private String amendName;//修改人名称
}
