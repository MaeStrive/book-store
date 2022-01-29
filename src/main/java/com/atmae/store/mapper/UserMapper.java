package com.atmae.store.mapper;

import com.atmae.store.entity.User;

import java.util.Date;

/**
 * @author Mae
 * 用户模块的持久层接口
 */
public interface UserMapper {
    /**
     * 插入用户的数据
     *
     * @param user 用户的数据
     * @return 影响的行数作为返回值 根据返回值来判断是否执行成功
     */
    Integer insertUser(User user);

    /**
     * 根据用户名查询用户的数据
     *
     * @param username 用户名
     * @return 如果找到对应的用户 则返回这个用户的数据，如果没有返回null值
     */
    User findByUsername(String username);

    /**
     * 根据用户的id来修改密码
     *
     * @param userId       用户id
     * @param password     用户输入的新密码
     * @param modifiedUser 修改密码的执行者
     * @param modifiedTime 修改密码的时间
     * @return 返回值影响的行数
     */
    Integer updatePasswordByUserId(Integer userId, String password, String modifiedUser, Date modifiedTime);

    /**
     * 根据用户的id来查询用户信息
     *
     * @param userId 用户id
     * @return 返回对象 否则null
     */
    User findInfoByUserId(Integer userId);

    /**
     * 根据用户id来更新用户基本信息
     *
     * @param user 用户对象
     * @return 返回值影响的行数
     */
    Integer updateInfoByUserId(User user);

    /**
     * 根据用户id更新用户头像
     * @param userId 用户id
     * @param avatar 用户头像
     * @param modifiedUser 修改人
     * @param modifiedTime 修改时间
     * @return 返回值影响的行数
     */
    Integer updateAvatarByUserId(Integer userId,String avatar,String modifiedUser,Date modifiedTime);



}
