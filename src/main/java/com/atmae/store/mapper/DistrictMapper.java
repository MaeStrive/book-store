package com.atmae.store.mapper;

import com.atmae.store.entity.District;

import java.util.List;

/**
 * 省市区地址持久层
 * @author Mae
 */
public interface DistrictMapper {

    /**
     * 根据父代号查询区域信息
     * @param parent 父代号
     * @return 某个区域下的所有区域列表
     */
    List<District> findDistrictByParent(String parent);

    /**
     * 根据代码查询名字
     * @param code 代码
     * @return
     */
    String findNameByCode(String code);
}
