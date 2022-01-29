package com.atmae.store.controller;

import com.atmae.store.entity.Order;
import com.atmae.store.service.IOrderService;
import com.atmae.store.util.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author Mae
 */
@RestController
@RequestMapping("/orders")
public class OrderController extends BaseController {
    @Resource
    private IOrderService orderService;

    @RequestMapping("/create")
    public JsonResult<Order> createOrder(Integer addressId, Integer[] cartIds, HttpSession session) {
        Integer userId = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        Order order = orderService.createOrder(addressId, userId, username, cartIds);
        return new JsonResult<>(OK, order);
    }

    @RequestMapping("/order")
    public JsonResult<Order> showOrder(HttpSession session) {
        Order order = orderService.findOrder(getUidFromSession(session));
        return new JsonResult<>(OK, order);
    }
}
