package com.atmae.store.entity;

import lombok.*;

/**
 * 收货地址实体类
 *
 * @author Mae
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class Address extends BaseEntity {
    private Integer addressId;
    private Integer userId;
    private String name;
    private String provinceCode;
    private String provinceName;
    private String cityName;
    private String cityCode;
    private String areaName;
    private String areaCode;
    private String zip;
    private String address;
    private String phone;
    private String tel;
    private String tag;
    private Integer isDefault;
}
