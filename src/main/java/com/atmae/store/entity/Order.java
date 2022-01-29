package com.atmae.store.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单数据的实体类
 * @author Mae
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order extends BaseEntity implements Serializable {
    private Integer orderId;
    private Integer userId;
    private String recvName;
    private String recvPhone;
    private String recvProvince;
    private String recvCity;
    private String recvArea;
    private String recvAddress;
    private Long totalPrice;
    private Integer status;
    private Date orderTime;
    private Date payTime;
}
