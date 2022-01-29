package com.atmae.store.service.impl;

import com.atmae.store.entity.Cart;
import com.atmae.store.entity.Product;
import com.atmae.store.mapper.CartMapper;
import com.atmae.store.mapper.ProductMapper;
import com.atmae.store.service.ICartService;
import com.atmae.store.service.IProductService;
import com.atmae.store.service.ex.AccessDeniedException;
import com.atmae.store.service.ex.CartNotFoundException;
import com.atmae.store.service.ex.InsertException;
import com.atmae.store.service.ex.UpdateException;
import com.atmae.store.vo.CartVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author Mae
 */
@Service
public class CartServiceImpl implements ICartService {

    @Resource
    private CartMapper cartMapper;
    @Resource
    private ProductMapper productMapper;

    @Override
    public void addToCart(Integer userId, Integer productId, Integer amount, String username) {
        /** 根据参数pid和uid查询购物车中的数据
         * 判断查询结果是否为null
         * 是：表示该用户并未将该商品添加到购物车
         * -- 创建Cart对象
         * -- 封装数据：userId,productId,amount
         * -- 调用productService.findById(productId)查询商品数据，得到商品价格
         * -- 封装数据：price
         * -- 封装数据：4个日志
         * -- 调用insert(cart)执行将数据插入到数据表中
         * 否：表示该用户的购物车中已有该商品
         * -- 从查询结果中获取购物车数据的id
         * -- 从查询结果中取出原数量，与参数amount相加，得到新的数量
         * -- 执行更新数量**/
        // 根据参数pid和uid查询购物车中的数据
        Cart result = cartMapper.findByUidAndPid(userId, productId);
        Date now = new Date();
        // 判断查询结果是否为null
        if (result == null) {
            // 是：表示该用户并未将该商品添加到购物车
            // 创建Cart对象
            Cart cart = new Cart();
            // 封装数据：uid,pid,amount
            cart.setUserId(userId);
            cart.setProductId(productId);
            cart.setNum(amount);
            // 调用productMapper.findById(productId)查询商品数据，得到商品价格
            Product product = productMapper.findProductById(productId);
            // 封装数据：price
            cart.setPrice(product.getPrice());
            // 封装数据：4个日志
            cart.setCreatedUser(username);
            cart.setCreatedTime(now);
            cart.setModifiedUser(username);
            cart.setModifiedTime(now);
            // 调用insert(cart)执行将数据插入到数据表中
            Integer rows = cartMapper.insert(cart);
            if (rows != 1) {
                throw new InsertException("插入商品数据时出现未知错误，请联系系统管理员");
            }
        } else {
            /** 否：表示该用户的购物车中已有该商品 从查询结果中获取购物车数据的id
             *  Integer cartId = result.getCartId();从查询结果中取出原数量，与参数amount相加，得到新的数量*/
            Integer cartId = result.getCartId();
            Integer num = result.getNum() + amount;
            // 执行更新数量
            Integer rows = cartMapper.updateNumByCid(cartId, num, username, now);
            if (rows != 1) {
                throw new InsertException("修改商品数量时出现未知错误，请联系系统管理员");
            }
        }
    }

    @Override
    public List<CartVO> getVOByUserId(Integer userId) {
        return cartMapper.findInfoByUserId(userId);
    }

    @Override
    public Integer addNum(Integer cartId, Integer userId, String username) {
        Cart result = cartMapper.findCartByCartId(cartId);
        if (result == null) {
            throw new CartNotFoundException("数据不存在异常");
        }
        if (!result.getUserId().equals(userId)) {
            throw new AccessDeniedException("非法数据访问");
        }
        Integer num = result.getNum() + 1;
        Integer rows = cartMapper.updateNumByCid(cartId, num, username, new Date());
        if (rows != 1) {
            throw new UpdateException("更新数据失败");
        }
        return num;
    }

    @Override
    public Integer subtractNum(Integer cartId, Integer userId, String username) {
        Cart result = cartMapper.findCartByCartId(cartId);
        if (result == null) {
            throw new CartNotFoundException("数据不存在异常");
        }
        if (!result.getUserId().equals(userId)) {
            throw new AccessDeniedException("非法数据访问");
        }
        if (result.getNum() == 0) {
            return 0;
        }
        Integer num = result.getNum() - 1;
        Integer rows = cartMapper.updateNumByCid(cartId, num, username, new Date());
        if (rows != 1) {
            throw new UpdateException("更新数据失败");
        }
        return num;
    }

    @Override
    public List<CartVO> getVoByCartId(Integer[] cartIds, Integer userId) {
        List<CartVO> cartVos = cartMapper.findInfoByCartId(cartIds);
        Iterator<CartVO> it = cartVos.iterator();
        while (it.hasNext()) {
            CartVO cartVO = it.next();
            if (!cartVO.getUserId().equals(userId)) {
                /** 当前数据不属于当前用户*/
                /** 从集合中剔除这个元素*/
                cartVos.remove(cartVO);
            }
        }
        return cartVos;
    }

    @Override
    public Integer delCartByCartId(Integer cartId) {
        Integer rows = cartMapper.delCartByCartId(cartId);
        if (rows != 1) {
            throw new CartNotFoundException("未找到购物车信息!");
        }
        return rows;
    }

    @Override
    public Integer delAllCartsByCartId(Integer[] cartId) {
        Integer rows = cartMapper.delAllCartsByCartIds(cartId);
        if (rows != 1) {
            throw new CartNotFoundException("未找到购物车信息！");
        }
        return rows;
    }
}
