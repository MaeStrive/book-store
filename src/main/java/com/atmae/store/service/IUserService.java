package com.atmae.store.service;

import com.atmae.store.entity.User;

import java.util.Date;


/**
 * @author Mae
 */
public interface IUserService {
    /**
     * 用户注册方法
     * @param user 用户的数据对象
     */
    void register(User user);

    /**
     * 用户登陆方法
     * @param username 用户名
     * @param password  密码
     * @return  当前匹配的用户数据 没有则返回null
     */
    User login(String username,String password);

    /**
     * 用户修改密码
     * @param userId 用户id
     * @param username 用户名
     * @param oldPassword 老密码
     * @param newPassword 新密码
     */
    void changePassword(Integer userId,String username,String oldPassword,String newPassword);

    /**
     * 根据用户id查询用户信息
     * @param userId 用户id
     * @return  用户信息
     */
    User getInfoByUserId(Integer userId);

    /**
     * 根据用户id改变用户信息
     * @param userId 用户id
     * @param username 用户名
     * @param user 用户对象
     */
    void changeInfo(Integer userId,String username,User user);

    /**
     * 根据用户id改变用户头像
     * @param userId 用户id
     * @param avatar 用户头像路径
     * @param username 用户名
     */
    void changeAvatar(Integer userId, String avatar, String username);
}
