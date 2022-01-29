package com.atmae.store.mapper;


import com.atmae.store.entity.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressMapperTest {

    @Resource
    private AddressMapper addressMapper;

    @Test
    public void insertAddressTest() {
        Address address = new Address();
        address.setUserId(35);
        address.setPhone("10005");
        address.setName("静静");
        addressMapper.insertAddress(address);
    }

    @Test
    public void countByUserIdTest() {
        Integer count = addressMapper.countByUserId(35);
        System.out.println(count);
    }

    @Test
    public void findAddressByUserId() {
        List<Address> addresses = addressMapper.findAddressByUserId(35);
        System.out.println(addresses);
    }

    @Test
    public void findAddressByAddressId() {
        Address address = addressMapper.findAddressByAddressId(7);
        System.out.println(address);
    }

    @Test
    public void updateNonDefault() {
        addressMapper.updateNonDefault(35);
    }

    @Test
    public void updateDefaultByAddressId() {
        addressMapper.updateDefaultByAddressId(7, "Mae", new Date());
    }

    @Test
    public void deleteAddressByAddressId() {
        addressMapper.deleteAddressByAddressId(12);
    }

    @Test
    public void findLastModifiedByUserId() {
        Address address = addressMapper.findLastModifiedByUserId(34);
        System.out.println(address);
    }

    @Test
    public void deleteAddress(){
        addressMapper.deleteAddressByAddressId(15);
    }
}

