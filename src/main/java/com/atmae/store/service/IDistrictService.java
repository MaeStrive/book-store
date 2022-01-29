package com.atmae.store.service;

import com.atmae.store.entity.District;

import java.util.List;

/**
 * @author Mae
 */
public interface IDistrictService {
    /**
     * 根据父区域的代号查询区域的信息(省/市/区)
     * @param parent 父代号
     */
    public List<District> getDistrictByParent(String parent);
}
