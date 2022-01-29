package com.atmae.store.mapper;


import com.atmae.store.entity.Address;
import com.atmae.store.entity.District;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
public class DistrictMapperTest {

    @Resource
    private DistrictMapper districtMapper;

    @Test
    public void findDistrictByParent(){
        List<District> districts = districtMapper.findDistrictByParent("370600");
        for (District district:districts){
            System.out.println(district);
        }
    }

    @Test
    public void findNameByCode(){
        String name = districtMapper.findNameByCode("370685");
        System.out.println(name);
    }
}
