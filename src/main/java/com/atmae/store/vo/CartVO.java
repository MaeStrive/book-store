package com.atmae.store.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * value object 值对象
 * 当进行select查询时 查询的结果数据时多张表中的内容，此时不能使用一个pojo实体类来接受
 * 则重新建一个新的对象存储查询出来的结果对应的映射
 * “ 多表操作 ”
 * @author Mae
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartVO implements Serializable {
    private Integer userId;
    private Integer cartId;
    private Integer productId;
    private Long price;
    private Integer num;
    private String title;
    private String image;
    private Long realPrice;
}
