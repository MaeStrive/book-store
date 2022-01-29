package com.atmae.store.service.impl;

import com.atmae.store.entity.Address;
import com.atmae.store.entity.Order;
import com.atmae.store.entity.OrderItem;
import com.atmae.store.mapper.OrderMapper;
import com.atmae.store.service.IAddressService;
import com.atmae.store.service.ICartService;
import com.atmae.store.service.IOrderService;
import com.atmae.store.service.ex.InsertException;
import com.atmae.store.vo.CartVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Mae
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private IAddressService addressService;
    @Resource
    private ICartService cartService;

    @Override
    public Order createOrder(Integer addressId, Integer userId, String username, Integer[] cartIds) {
        List<CartVO> list = cartService.getVoByCartId(cartIds, userId);
        /** 计算总价*/
        Long totalPrice = 0L;
        for (CartVO c : list) {
            totalPrice += c.getRealPrice() * c.getNum();
        }
        Address address = addressService.getInfoByAddressId(addressId, userId);
        Order order = new Order();
        order.setUserId(userId);
        order.setRecvAddress(address.getAddress());
        order.setRecvArea(address.getAreaName());
        order.setRecvCity(address.getCityName());
        order.setRecvName(address.getName());
        order.setRecvPhone(address.getPhone());
        order.setRecvProvince(address.getProvinceName());

        /** 支付 总价 时间*/
        order.setStatus(0);
        order.setTotalPrice(totalPrice);
        order.setOrderTime(new Date());
        /** 日志*/
        order.setCreatedUser(username);
        order.setCreatedTime(new Date());
        order.setModifiedTime(new Date());
        order.setModifiedUser(username);
        /** 查询数据*/
        Integer rows = orderMapper.insertOrder(order);
        if (rows != 1) {
            throw new InsertException("插入数据时产生异常");
        }
        /** 创建订单详细项数据*/
        for (CartVO cartVO : list) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(order.getOrderId());
            orderItem.setProductId(cartVO.getProductId());
            orderItem.setImage(cartVO.getImage());
            orderItem.setTitle(cartVO.getTitle());
            orderItem.setPrice(cartVO.getRealPrice());
            orderItem.setNum(cartVO.getNum());
            orderItem.setCreatedUser(username);
            orderItem.setCreatedTime(new Date());
            orderItem.setModifiedTime(new Date());
            orderItem.setModifiedUser(username);
            Integer row = orderMapper.insertOrderItem(orderItem);
            if (row != 1) {
                throw new InsertException("插入数据时产生异常");
            }
        }
        return order;
    }

    @Override
    public Order findOrder(Integer userId) {
        Order order = orderMapper.findOrderByUserId(userId);
        order.setOrderTime(null);
        order.setModifiedUser(null);
        order.setModifiedTime(null);
        order.setCreatedUser(null);
        order.setCreatedTime(null);
        order.setRecvProvince(null);
        order.setRecvCity(null);
        order.setRecvPhone(null);
        order.setRecvArea(null);
        order.setRecvAddress(null);
        return order;
    }
}
