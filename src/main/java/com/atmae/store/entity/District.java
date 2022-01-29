package com.atmae.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 省市区的数据实体类
 * @author Mae
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class District{
    private Integer id;
    private String parent;
    private String code;
    private String name;
}
