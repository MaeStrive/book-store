package com.atmae.store.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Mae
 * 用户实体类
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity implements Serializable {
    private Integer userId;
    private String username;
    private String password;
    private String salt;
    private String phone;
    private String email;
    private Integer gender;
    private String avatar;
    private Integer isDelete;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String salt, String phone, String email, Integer gender, String avatar, Integer isDelete,
                String createdUser, Date createdTime, String modifiedUser, Date modifiedTime) {
        super(createdUser, createdTime, modifiedUser, modifiedTime);
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.avatar = avatar;
        this.isDelete = isDelete;
    }
}
