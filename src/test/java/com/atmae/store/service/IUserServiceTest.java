package com.atmae.store.service;

import com.atmae.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class IUserServiceTest {
    @Resource
    private IUserService userService;

    @Test
    public void register(){
        User user=new User("wowo","123456");
        userService.register(user);
        System.out.println("插入成功");
    }

    @Test
    public  void login(){
        User user = userService.login("wowo", "123456");
        System.out.println(user);
    }

    @Test
    public void changePassword(){
        userService.changePassword(35,"Admin","123456","666666");
    }

    @Test
    public void getInfoByUserId(){
        User user = userService.getInfoByUserId(35);
        System.out.println(user);
    }

    @Test
    public void changeInfo(){
        User user=new User();
        user.setPhone("111558");
        user.setEmail("mae@163.com");
        user.setGender(1);
        userService.changeInfo(35,"Mae",user);
    }

    @Test
    public void changeAvatar(){
        userService.changeAvatar(35,"/assets/img/avatar/inbox-avatar-2.png","Mae");
    }
}
