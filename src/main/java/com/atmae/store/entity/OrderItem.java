package com.atmae.store.entity;

import com.atmae.store.controller.BaseController;
import lombok.*;

import java.io.Serializable;

/**
 * 订单中的商品数据
 *
 * @author Mae
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem extends BaseEntity implements Serializable {
    private Integer id;
    private Integer orderId;
    private Integer productId;
    private String title;
    private String image;
    private Long price;
    private Integer num;
}
