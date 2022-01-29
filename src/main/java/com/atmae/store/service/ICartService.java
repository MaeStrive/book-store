package com.atmae.store.service;

import com.atmae.store.vo.CartVO;

import java.util.List;

/**
 * 购物车业务层
 *
 * @author Mae
 */
public interface ICartService {

    /**
     * 向购物车添加数据
     *
     * @param userId    用户id
     * @param productId 商品id
     * @param amount    数量
     * @param username  用户
     */
    void addToCart(Integer userId, Integer productId, Integer amount, String username);

    /**
     * 根据用户id得到VO对象
     *
     * @param userId 用户id
     * @return VO对象
     */
    List<CartVO> getVOByUserId(Integer userId);

    /**
     * 增加商品数量
     *
     * @param cartId   购物商品id
     * @param userId   用户id
     * @param username 用户
     * @return 增加成功后新的数量
     */
    Integer addNum(Integer cartId, Integer userId, String username);

    /**
     * 减少商品数量
     *
     * @param cartId   购物商品id
     * @param userId   用户id
     * @param username 用户名
     * @return 减少成功后商品数量
     */
    Integer subtractNum(Integer cartId, Integer userId, String username);

    /**
     * 查询选中购物车的信息
     * @param cartIds 购物车id数组
     * @param userId 用户id
     * @return vo对象
     */
    List<CartVO> getVoByCartId(Integer[] cartIds,Integer userId);

    /**
     * 删除购物车信息
     * @param cartId 购物车id
     * @return 受影响的行数
     */
    Integer delCartByCartId(Integer cartId);

    /**
     * 删除订单所有购物车信息
     * @param cartId 购物车id
     * @return 受影响行数
     */
    Integer delAllCartsByCartId(Integer[] cartId);
}
