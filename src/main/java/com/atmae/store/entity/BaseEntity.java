package com.atmae.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author Mae
 * <p>
 * 实体类的基类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BaseEntity {
    private String createdUser;
    private Date createdTime;
    private String modifiedUser;
    private Date modifiedTime;
}
