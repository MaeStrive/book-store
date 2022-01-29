package com.atmae.store.service;


import com.atmae.store.entity.Address;

import java.util.List;

/**
 * 收货地址业务层接口
 * @author Mae
 */
public interface IAddressService {
    /**
     * 增加新的收货地址
     * @param userId 用户id
     * @param username 用户名
     * @param address 收货地址
     */
    void addNewAddress(Integer userId, String username, Address address);

    /**
     * 根据用户id查询用户的收货地址
     * @param userId 用户id
     * @return 用户所有收货地址列表
     */
    List<Address> getByUserId(Integer userId);

    /**
     * 修改某个用户的某条收货地址数据为默认收货地址
     * @param addressId 地址id
     * @param userId 用户id
     * @param username 执行人
     */
    void setDefault(Integer addressId,Integer userId,String username);

    /**
     * 删除用户的收货地址
     * @param addressId 地址id
     * @param userId 用户id
     * @param username 修改人
     */
    void deleteAddress(Integer addressId,Integer userId,String username);

    /**
     * 根据地址id查询信息
     * @param addressId 地址id
     * @param userId 用户id
     * @return 地址信息
     */
    Address getInfoByAddressId(Integer addressId,Integer userId);
}
