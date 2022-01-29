package com.atmae.store.mapper;


import com.atmae.store.entity.Address;
import com.atmae.store.vo.CartVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
public class CartMapperTest {

    @Resource
    private CartMapper cartMapper;

    @Test
    public void findInfoByUserId() {
        List<CartVO> lists = cartMapper.findInfoByUserId(35);
        System.out.println(lists);
    }

    @Test
    public void findInfoByCartId() {
        Integer[] cids={1,2,3};
        List<CartVO> vos = cartMapper.findInfoByCartId(cids);
        System.out.println(vos);
    }

}

