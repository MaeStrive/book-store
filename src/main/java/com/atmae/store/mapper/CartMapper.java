package com.atmae.store.mapper;

import com.atmae.store.entity.Cart;
import com.atmae.store.vo.CartVO;

import java.util.Date;
import java.util.List;

/**
 * @author Mae
 */
public interface CartMapper {
    /**
     * 插入购物车数据
     *
     * @param cart 购物车数据
     * @return 受影响的行数
     */
    Integer insert(Cart cart);

    /**
     * 修改购物车数据中商品的数量
     *
     * @param cartId       购物车数据的id
     * @param num          新的数量
     * @param modifiedUser 修改执行人
     * @param modifiedTime 修改时间
     * @return 受影响的行数
     */
    Integer updateNumByCid(Integer cartId, Integer num, String modifiedUser, Date modifiedTime);

    /**
     * 根据用户id和商品id查询购物车中的数据
     *
     * @param userId    用户id
     * @param productId 商品id
     * @return 匹配的购物车数据，如果该用户的购物车中并没有该商品，则返回null
     */
    Cart findByUidAndPid(Integer userId, Integer productId);

    /**
     * 根据用户id查询购物车列表信息
     * @param userId 用户id
     * @return vo多表查询对象
     */
    List<CartVO> findInfoByUserId(Integer userId);

    /**
     * 根据购物车id查询购物车
     * @param cartId 购物车id
     * @return 购物车信息
     */
    Cart findCartByCartId(Integer cartId);

    /**
     * 根据购物车id查询购物车VO信息
     * @param cartIds 购物车id集合
     * @return VO对象
     */
    List<CartVO> findInfoByCartId(Integer[] cartIds);

    /**
     * 根据购物车id删除购物车信息
     * @param cartId 购物车id
     * @return 受影响的行数
     */
    Integer delCartByCartId(Integer cartId);

    /**
     * 根据购物车id门删除购物车门
     * @param cartIds 购物车id们
     * @return 受影响的行数
     */
    Integer delAllCartsByCartIds(Integer[] cartIds);
}
