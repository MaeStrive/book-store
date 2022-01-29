package com.atmae.store.controller;

import com.atmae.store.entity.Cart;
import com.atmae.store.entity.Product;
import com.atmae.store.service.ICartService;
import com.atmae.store.util.JsonResult;
import com.atmae.store.vo.CartVO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 购物车的控制层
 *
 * @author Mae
 */
@RestController
@RequestMapping("/carts")
public class CartController extends BaseController {
    @Resource
    ICartService cartService;

    @RequestMapping("/addToCart")
    public JsonResult<Void> addToCart(Integer productId, Integer amount, HttpSession session) {
        cartService.addToCart(getUidFromSession(session), productId, amount, getUsernameFromSession(session));
        return new JsonResult<>(OK);
    }

    @RequestMapping("/cart")
    public JsonResult<List<CartVO>> getVoByUserId(HttpSession session) {
        List<CartVO> cartVos = cartService.getVOByUserId(getUidFromSession(session));
        return new JsonResult<>(OK, cartVos);
    }

    @RequestMapping("/{cartId}/num/add")
    public JsonResult<Integer> addNum(@PathVariable("cartId") Integer cartId, HttpSession session) {
        Integer num = cartService.addNum(cartId, getUidFromSession(session), getUsernameFromSession(session));
        return new JsonResult<>(OK, num);
    }

    @RequestMapping("/{cartId}/num/subtract")
    public JsonResult<Integer> subtractNum(@PathVariable("cartId") Integer cartId, HttpSession session) {
        Integer num = cartService.subtractNum(cartId, getUidFromSession(session), getUsernameFromSession(session));
        return new JsonResult<>(OK, num);
    }

    @RequestMapping("/list")
    public JsonResult<List<CartVO>> getVoByCartId(Integer[] cartIds, HttpSession session) {
        List<CartVO> cartVos = cartService.getVoByCartId(cartIds, getUidFromSession(session));
        return new JsonResult<>(OK, cartVos);
    }

    @RequestMapping("/{id}/del")
    public JsonResult<Void> delCart(@PathVariable("id") Integer cartId) {
        cartService.delCartByCartId(cartId);
        return new JsonResult<>(OK);
    }

}
