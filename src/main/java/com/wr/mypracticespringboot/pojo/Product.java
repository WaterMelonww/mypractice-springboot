package com.wr.mypracticespringboot.pojo;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wangru
 *
 */
@Entity
@DynamicUpdate //时间自动更新
@Data
@Table(name = "t_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId; //商品id

    private String productName;//商品名称

    private BigDecimal productPrice;//商品价格

    private String productIcon; //商品图片

    private Integer productStatus; //商品状态 状态0正常  1下架
    //类目编号


    private String categoryCode;//商品类型
    // 如 ice cream 为冰淇凌类 用类别英文名称做类别标识

    private Date creatTime; //创建时间
    private Date updateTime; //更新时间

    private Integer createId; //创建人 id
    private String createName; //创建人名称
    private Integer amendId; //修改人id
    private String amendName;//修改人名称
}
