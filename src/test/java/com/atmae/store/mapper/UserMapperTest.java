package com.atmae.store.mapper;

import com.atmae.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest{

    @Resource
    private  UserMapper userMapper;

    @Test
    public void insert(){
        Integer rows=userMapper.insertUser(new User("ijjihu","22222","daww34338","155998775","597412@qq.com",1,"dddddd",0,"bsesedrtr",new Date(),"dw222",new Date()));
        System.out.println(rows);
    }

    @Test
    public void findByUsername(){
        User username = userMapper.findByUsername("ijjihu");
        System.out.println(username);
    }

    @Test
    public void testFindByUserId() {
        User userId = userMapper.findInfoByUserId(24);
        System.out.println(userId);
    }

    @Test
    public void updatePasswordByUserId() {
        Integer integer = userMapper.updatePasswordByUserId(24, "123456", "Admin", new Date());
        System.out.println(integer);
    }

    @Test
    public void updateInfoByUserId(){
        User user=new User();
        user.setUserId(35);
        user.setPhone("10001");
        user.setEmail("220@163.com");
        user.setGender(1);
        userMapper.updateInfoByUserId(user);
    }

    @Test
    public void updateAvatarByUserId(){
        userMapper.updateAvatarByUserId(35,"/assets/img/avatar/jing1.png","Mae",new Date());
    }

}
