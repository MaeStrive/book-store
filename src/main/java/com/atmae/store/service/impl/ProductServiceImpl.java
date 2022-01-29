package com.atmae.store.service.impl;

import com.atmae.store.entity.Product;
import com.atmae.store.mapper.ProductMapper;
import com.atmae.store.service.IProductService;
import com.atmae.store.service.ex.ProductNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Mae
 */
@Service
public class ProductServiceImpl implements IProductService {
    @Resource
    private ProductMapper productMapper;

    @Override
    public List<Product> findHotList() {
        List<Product> products = productMapper.findHotList();
        for (Product product : products) {
            product.setPriority(null);
            product.setCreatedUser(null);
            product.setCreatedTime(null);
            product.setModifiedTime(null);
            product.setModifiedUser(null);
        }
        return products;
    }

    @Override
    public List<Product> findNewList() {
        List<Product> products = productMapper.findNewList();
        for (Product product : products) {
            product.setPriority(null);
            product.setCreatedUser(null);
            product.setCreatedTime(null);
            product.setModifiedTime(null);
            product.setModifiedUser(null);
        }
        return products;
    }

    @Override
    public Product findProductById(Integer id) {
        Product product = productMapper.findProductById(id);
        if (product == null) {
            throw new ProductNotFoundException("商品不存在");
        }
        /** 无用的信息设置为null*/
        product.setPriority(null);
        product.setCreatedTime(null);
        product.setCreatedUser(null);
        product.setModifiedUser(null);
        product.setModifiedTime(null);

        return product;
    }

    @Override
    public List<Product> findListByPage(Integer pageNum, Integer pageSize) {
        List<Product> products = productMapper.findListByPage(pageNum, pageSize);
        for (Product product : products) {
            product.setPriority(null);
            product.setCreatedUser(null);
            product.setCreatedTime(null);
            product.setModifiedTime(null);
            product.setModifiedUser(null);
        }
        return products;
    }

    @Override
    public List<Product> findList() {
        List<Product> products = productMapper.findList();
        for (Product product : products) {
            product.setPriority(null);
            product.setCreatedUser(null);
            product.setCreatedTime(null);
            product.setModifiedTime(null);
            product.setModifiedUser(null);
        }
        return products;
    }

    @Override
    public Integer findCount() {
        return productMapper.findCount();
    }
}
