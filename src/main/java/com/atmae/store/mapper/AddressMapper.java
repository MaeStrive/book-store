package com.atmae.store.mapper;

import com.atmae.store.entity.Address;

import java.util.Date;
import java.util.List;

/**
 * 收货地址持久层的接口
 * @author Mae
 */
public interface AddressMapper {
    /**
     * 插入用户收货地址的数据
     * @param address 收货地址数据
     * @return  受影响的行数
     */
    Integer insertAddress(Address address);

    /**
     * 根据用户id统计收货地址数量
     * @param userId 用户id
     * @return  用户收货地址总数
     */
    Integer countByUserId(Integer userId);

    /**
     * 根据用户id查询用户的所有收货地址
     * @param userId 用户id
     * @return 用户收货地址数据
     */
    List<Address> findAddressByUserId(Integer userId);

    /**
     * 根据aid查询收货地址数据
     * @param addressId 收货id
     * @return 收货地址数据 没有找到返回null
     */
    Address findAddressByAddressId(Integer addressId);

    /**
     * 根据用户的uid修改用户的收货地址设置为非默认
     * @param userId 用户的id
     * @return 受影响的行数
     */
    Integer updateNonDefault(Integer userId);

    /**
     * 更新用户的默认收货地址
     * @param addressId 收货地址id
     * @param modifiedUser 修改用户
     * @param modifiedTime 修改时间
     * @return 受影响的行数
     */
    Integer updateDefaultByAddressId(Integer addressId, String modifiedUser, Date modifiedTime);

    /**
     * 根据收货地址Id删除收货地址数据
     * @param addressId 收货地址id
     * @return 受影响行数
     */
    Integer deleteAddressByAddressId(Integer addressId);

    /**
     * 根据用户id查找当前用户最后一次被修改的收货地址数据
     * @param userId 用户id
     * @return 收货地址
     */
    Address findLastModifiedByUserId(Integer userId);
}
