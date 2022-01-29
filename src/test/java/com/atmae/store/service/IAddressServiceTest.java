package com.atmae.store.service;

import com.atmae.store.entity.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class IAddressServiceTest {
    @Resource
    private IAddressService addressService;

    @Test
    public void addNewAddressTest(){
        Address address=new Address();
        address.setPhone("58787848");
        address.setName("静静");
        addressService.addNewAddress(35,"Mae",address);
    }

    @Test
    public void setDefault(){
        addressService.setDefault(8,35,"admin");
    }
}
