package com.atmae.store.service.impl;

import com.atmae.store.entity.District;
import com.atmae.store.mapper.DistrictMapper;
import com.atmae.store.service.IDistrictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Mae
 */
@Service
public class DistrictServiceImpl implements IDistrictService {
    @Resource
    private DistrictMapper districtMapper;

    @Override
    public List<District> getDistrictByParent(String parent) {
        List<District> districts = districtMapper.findDistrictByParent(parent);
        /**  在进行网络传输时 为了避免无效数据的传输，可以将无关数据设置为null ：节省流量 提高效率*/
        for (District d : districts) {
            d.setId(null);
            d.setParent(null);
        }
        return districts;
    }
}
