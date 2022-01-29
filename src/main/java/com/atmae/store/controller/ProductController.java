package com.atmae.store.controller;

import com.atmae.store.entity.Product;
import com.atmae.store.service.IProductService;
import com.atmae.store.util.JsonResult;
import com.fasterxml.jackson.datatype.jsr310.deser.key.OffsetTimeKeyDeserializer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Mae
 */
@RestController
@RequestMapping("/products")
public class ProductController extends BaseController {
    @Resource
    private IProductService productService;

    @RequestMapping("/hotList")
    public JsonResult<List<Product>> getHotList() {
        List<Product> products = productService.findHotList();
        return new JsonResult<>(OK, products);
    }

    @RequestMapping("/newList")
    public JsonResult<List<Product>> getNewList() {
        List<Product> products = productService.findNewList();
        return new JsonResult<>(OK, products);
    }

    @RequestMapping("/{id}/details")
    public JsonResult<Product> details(@PathVariable("id") Integer id) {
        Product product = productService.findProductById(id);
        return new JsonResult<>(OK, product);
    }

    @RequestMapping("/listPage")
    public JsonResult<List<Product>> listByPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        pageNum = (pageNum - 1) * pageSize;
        Integer count = productService.findCount();
        List<Product> list = productService.findListByPage(pageNum, pageSize);
        return new JsonResult<>(OK, list);
    }

    @RequestMapping("/list")
    public JsonResult<List<Product>> list() {
        List<Product> list = productService.findList();
        return new JsonResult<>(OK, list);
    }
}
