package com.atmae.store.service;

import com.atmae.store.entity.Product;

import java.util.List;

/**
 * @author Mae
 */
public interface IProductService {
    /**
     * 查找所有热门商品
     *
     * @return 热门商品集合
     */
    List<Product> findHotList();

    /**
     * 查找最新商品
     * @return 最新商品集合
     */
    List<Product> findNewList();

    /**
     * 根据Id查找商品
     * @param id 商品id
     * @return 商品
     */
    Product findProductById(Integer id);

    /**
     * 分页查找所有商品
     * @param pageNum 起始
     * @param pageSize 显示多少
     * @return 商品
     */
    List<Product> findListByPage(Integer pageNum,Integer pageSize);

    /**
     * 查找所有商品
     * @return 商品列表
     */
    List<Product> findList();

    /**
     * 计算所有数量
     * @return 数量
     */
    Integer findCount();
}
