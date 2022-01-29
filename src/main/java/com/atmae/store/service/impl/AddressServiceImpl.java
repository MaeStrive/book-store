package com.atmae.store.service.impl;

import com.atmae.store.entity.Address;
import com.atmae.store.mapper.AddressMapper;
import com.atmae.store.mapper.DistrictMapper;
import com.atmae.store.service.ex.DeleteException;
import com.atmae.store.service.IAddressService;
import com.atmae.store.service.ex.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Mae
 */
@Service
public class AddressServiceImpl implements IAddressService {
    @Resource
    private AddressMapper addressMapper;
    @Resource
    private DistrictMapper districtMapper;

    @Value("${user.address.max-count}")
    private Integer maxCount;

    @Override
    public void addNewAddress(Integer userId, String username, Address address) {
        Integer count = addressMapper.countByUserId(userId);
        if (count >= maxCount) {
            throw new AddressCountLimitException("收货地址超出上限！");
        }

        /** 对address对象中的数据进行补全：省市区*/
        String provinceName = districtMapper.findNameByCode(address.getProvinceCode());
        String cityName = districtMapper.findNameByCode(address.getCityCode());
        String areaName = districtMapper.findNameByCode(address.getAreaCode());
        address.setProvinceName(provinceName);
        address.setAddress(address.getAddress());
        address.setCityName(cityName);
        address.setAreaName(areaName);
        address.setUserId(userId);
        /** 当返回的数据量为0时，将此时的地址设置为默认*/
        address.setIsDefault(count == 0 ? 1 : 0);
        address.setCreatedUser(username);
        address.setModifiedUser(username);
        address.setCreatedTime(new Date());
        address.setModifiedTime(new Date());

        Integer rows = addressMapper.insertAddress(address);
        if (rows != 1) {
            throw new InsertException("插入用户收货地址时产生未知的异常");
        }
    }

    @Override
    public List<Address> getByUserId(Integer userId) {
        List<Address> list = addressMapper.findAddressByUserId(userId);
        for (Address address : list) {
            address.setProvinceCode(null);
            address.setCityCode(null);
            address.setAreaCode(null);
            address.setTel(null);
            address.setIsDefault(null);
            address.setCreatedUser(null);
            address.setCreatedTime(null);
            address.setModifiedTime(null);
            address.setModifiedUser(null);
        }
        return list;
    }

    @Override
    public void setDefault(Integer addressId, Integer userId, String username) {
        Address result = addressMapper.findAddressByAddressId(addressId);
        if (result == null) {
            throw new AddressNotFoundException("收货地址不存在");
        }
        if (!result.getUserId().equals(userId)) {
            throw new AccessDeniedException("非法数据访问");
        }
        /** 先将所有数据设置为非默认*/
        Integer rows = addressMapper.updateNonDefault(userId);
        if (rows < 1) {
            throw new UpdateException("更新数据产生未知的异常");
        }
        /** 某用户选择的某条地址设置为默认收货地址*/
        Integer row = addressMapper.updateDefaultByAddressId(addressId, username, new Date());
        if (row != 1) {
            throw new UpdateException("更新数据时产生未知的异常");
        }
    }

    @Override
    public void deleteAddress(Integer addressId, Integer userId, String username) {
        Address result = addressMapper.findAddressByAddressId(addressId);
        if (result == null) {
            throw new AddressNotFoundException("地址未找到异常");
        }
        if (!result.getUserId().equals(userId)) {
            throw new AccessDeniedException("非法数据访问");
        }
        Integer rows = addressMapper.deleteAddressByAddressId(addressId);
        if (rows != 1) {
            throw new DeleteException("删除数据产生未知的异常");
        }
        /** 不是默认地址直接删 是默认地址需要另做判断*/
        if (result.getIsDefault() == 1) {
            Integer count = addressMapper.countByUserId(userId);
            if (count == 0) {
                /**终止 没有地址可以选用*/
                return;
            }
            /** 将这条数据的 is_default 的值设置为默认为1*/
            Address address = addressMapper.findLastModifiedByUserId(userId);
            Integer row = addressMapper.updateDefaultByAddressId(address.getAddressId(), username, new Date());
            if (row != 1) {
                throw new UpdateException("更新数据时产生未知的异常");
            }
        }
    }

    @Override
    public Address getInfoByAddressId(Integer addressId, Integer userId) {
        Address address = addressMapper.findAddressByAddressId(addressId);
        if (address == null) {
            throw new AddressNotFoundException("收货地址没有找到");
        }
        if (!address.getUserId().equals(userId)) {
            throw new AccessDeniedException("非法访问");
        }
        address.setProvinceCode(null);
        address.setCityCode(null);
        address.setAreaCode(null);
        address.setModifiedUser(null);
        address.setModifiedTime(null);
        address.setCreatedTime(null);
        address.setCreatedUser(null);
        return address;
    }
}
