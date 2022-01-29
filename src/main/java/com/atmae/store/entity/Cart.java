package com.atmae.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Mae
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cart extends BaseEntity implements Serializable {
    private Integer cartId;
    private Integer userId;
    private Integer productId;
    private Long price;
    private Integer num;
}
