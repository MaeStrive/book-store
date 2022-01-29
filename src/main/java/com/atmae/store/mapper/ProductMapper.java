package com.atmae.store.mapper;

import com.atmae.store.entity.Product;

import java.util.List;

/**
 * 商品的持久层接口
 * @author Mae
 */
public interface ProductMapper {
    /**
     * 查找热门商品
     * @return 热门商品集合
     */
    List<Product> findHotList();

    /**
     * 查找最新商品
     * @return 最新商品集合
     */
    List<Product> findNewList();
    /**
     * 根据id查找商品
     * @param id id
     * @return 商品
     */
    Product findProductById(Integer id);

    /**
     * 分页查询所有书
     * @param pageNum 当前
     * @param pageSize 显示总
     * @return 商品集合
     */
    List<Product> findListByPage(Integer pageNum,Integer pageSize);

    /**
     * 查找所有书
     * @return 商品集合
     */
    List<Product> findList();

    /**
     * 计算数量
     * @return 总数量
     */
    Integer findCount();
}
