package com.wr.mypracticespringboot.pojo;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wangru
 * @create 2019-09-06 16:15
 */
@Entity
@DynamicUpdate //时间自动更新
@Data
@Table(name = "t_category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId; //类型id
    private String  categoryName; //类型名称
    private String categoryCode; //类型编号 以类型名称的英文名做标识
    private Date creatTime; //创建时间
    private Date updateTime; //更新时间

    private Integer createId; //创建人 id
    private String createName; //创建人名称
    private Integer amendId; //修改人id
    private String amendName;//修改人名称
}
