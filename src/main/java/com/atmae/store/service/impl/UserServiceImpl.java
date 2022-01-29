package com.atmae.store.service.impl;

import com.atmae.store.entity.User;
import com.atmae.store.mapper.UserMapper;
import com.atmae.store.service.IUserService;
import com.atmae.store.service.ex.*;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

/**
 * @author Mae
 * 用户模块业务层的实现类
 */
@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private UserMapper userMapper;

    /**
     * MD5 算法加密处理
     *
     * @param password
     * @param salt
     * @return
     */
    private String getMD5Password(String password, String salt) {
        //md5加密算法的调用（进行三次加密）
        for (int i = 0; i < 3; i++) {
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
        //返回加密之后的密码
        return password;
    }

    @Override
    public void register(User user) {
        String username = user.getUsername();
        //判断用户是否被注册过
        User result = userMapper.findByUsername(username);
        //判断结果集是否不为null则抛出用户名被占用的异常
        if (result != null) {
            //抛出异常
            throw new UsernameDuplicatedException("用户名被占用");
        }
        //密码加密处理的实现：md5算法的形式：
        //盐值 + password + 盐值————连续加密三次
        String oldPassword = user.getPassword();
        //获取盐值(随机生成一个盐值)
        String salt = UUID.randomUUID().toString().toUpperCase();
        user.setSalt(salt);
        //将密码和盐值作为一个整体进行加密处理（忽略原有密码强度提升了数据的安全性）
        String md5Password = getMD5Password(oldPassword, salt);
        //将加密之后的密码重新补全到User对象中
        user.setPassword(md5Password);
        //补全数据：is_delete设置为0 表示未删除
        user.setIsDelete(0);
        //补全数据：4个日志字段信息
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());
        Date date = new Date();
        user.setCreatedTime(date);
        user.setModifiedTime(date);
        //执行注册业务功能的实现（rows==1）
        Integer rows = userMapper.insertUser(user);
        if (rows != 1) {
            throw new InsertException("在用户注册过程中产生了未知的异常");
        }
    }

    @Override
    public void changePassword(Integer userId, String username, String oldPassword, String newPassword) {
        User result = userMapper.findInfoByUserId(userId);
        if (result == null || result.getIsDelete() == 1) {
            throw new UserNotFoundException("用户数据不存在");
        }
        /** 原始密码喝数据中的密码进行比较*/
        String oldMd5Password = getMD5Password(oldPassword, result.getSalt());
        if (!result.getPassword().equals(oldMd5Password)) {
            throw new PasswordNotMatchException("用户密码不正确");
        }
        /** 将新的密码设置到数据库中,将新密码进行加密再去更新*/
        String newMd5Password = getMD5Password(newPassword, result.getSalt());
        Integer rows = userMapper.updatePasswordByUserId(userId, newMd5Password, username, new Date());
        if (rows != 1) {
            throw new UpdateException("更新数据产生未知的异常");
        }
    }

    @Override
    public User login(String username, String password) {
        User result = userMapper.findByUsername(username);
        if (result == null) {
            throw new UserNotFoundException("没有找到用户");
        }
        /** 检测用户密码是否匹配*/
        /** 与md5加密后的算法做比较*/
        String oldPassword = result.getPassword();
        String salt = result.getSalt();
        String newMd5Password = getMD5Password(password, salt);
        /** 比较*/
        if (!newMd5Password.equals(oldPassword)) {
            throw new PasswordNotMatchException("用户密码不正确!");
        }
        /** 判断用户是否被删除 (is_delete是否为1)*/
        if (result.getIsDelete() == 1) {
            throw new UserNotFoundException("没有找到此用户");
        }
        User user = new User();
        user.setUserId(result.getUserId());
        user.setUsername(result.getUsername());
        return user;
    }

    @Override
    public User getInfoByUserId(Integer userId) {
        User result = userMapper.findInfoByUserId(userId);
        if (result == null || result.getIsDelete() == 1) {
            throw new UserNotFoundException("用户没有找到");
        }
        User user = new User();
        user.setUsername(result.getUsername());
        user.setPhone(result.getPhone());
        user.setEmail(result.getEmail());
        user.setGender(result.getGender());
        return user;
    }


    @Override
    public void changeInfo(Integer userId, String username, User user) {
        User result = userMapper.findInfoByUserId(userId);
        if (result == null || result.getIsDelete() == 1) {
            throw new UserNotFoundException("用户没有找到");
        }
        user.setUserId(userId);
        user.setUsername(username);
        user.setModifiedUser(username);
        user.setModifiedTime(new Date());
        Integer rows = userMapper.updateInfoByUserId(user);
        if (rows != 1) {
            throw new UpdateException("更新数据时产生未知的异常");
        }
    }

    @Override
    public void changeAvatar(Integer userId, String avatar, String username) {
        User result = userMapper.findInfoByUserId(userId);
        if (result == null || result.getIsDelete() == 1) {
            throw new UserNotFoundException("用户名没有找到");
        }
        Integer rows = userMapper.updateAvatarByUserId(userId, avatar, username, new Date());
        if (rows != 1) {
            throw new UpdateException("更新用户头像时产生未知异常");
        }
    }
}
