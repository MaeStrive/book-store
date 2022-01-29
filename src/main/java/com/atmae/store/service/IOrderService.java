package com.atmae.store.service;

import com.atmae.store.entity.Address;
import com.atmae.store.entity.Order;


/**
 * 订单的业务层
 *
 * @author Mae
 */
public interface IOrderService {

    /**
     * 创建订单
     * @param addressId 收货地址id
     * @param userId 用户id
     * @param username 用户名
     * @param cartIds 订单id
     * @return 订单
     */
    Order createOrder(Integer addressId, Integer userId, String username, Integer[] cartIds);

    /**
     * 根据订单id查询订单
     * @param userId 用户id
     * @return 订单
     */
    Order findOrder(Integer userId);
}
