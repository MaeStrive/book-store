package com.atmae.store.service;

import com.atmae.store.entity.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ICartServiceTest {
    @Resource
    private ICartService cartService;

    @Test
    public void addToCart(){
        cartService.addToCart(35,10000011,10,"Mae");
    }

}
