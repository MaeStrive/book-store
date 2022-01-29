package com.atmae.store.service;

import com.atmae.store.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class IOrderServiceTest {
    @Resource
    private IOrderService orderService;

    @Test
    public void createOrderTest() {
        Integer[] cartIds = {1, 2, 3};
        Order order = orderService.createOrder(21, 35, "admin", cartIds);
        System.out.println(order);
    }
}
