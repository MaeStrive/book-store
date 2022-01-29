package com.atmae.store.mapper;

import com.atmae.store.entity.Order;
import com.atmae.store.entity.OrderItem;

/**
 * 订单表的持久层
 * @author Mae
 */
public interface OrderMapper {

    /**
     * 插入订单数据
     * @param order 订单数据
     * @return 受影响的行数
     */
    Integer insertOrder(Order order);

    /**
     * 插入订单项的数据
     * @param orderItem 订单项数据
     * @return 受影响的行数
     */
    Integer insertOrderItem(OrderItem orderItem);

    /**
     * 查询订单数据
     * @param userId
     * @return
     */
    Order findOrderByUserId(Integer userId);
}
