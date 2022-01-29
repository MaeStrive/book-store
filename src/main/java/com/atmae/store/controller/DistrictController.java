package com.atmae.store.controller;

import com.atmae.store.entity.District;
import com.atmae.store.service.IDistrictService;
import com.atmae.store.util.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Mae
 */
@RestController
@RequestMapping("/district")
public class DistrictController extends BaseController {

    @Resource
    private IDistrictService districtService;

    @RequestMapping(value = {"/",""})
    public JsonResult<List<District>> getByParent(String parent){
        List<District> districts = districtService.getDistrictByParent(parent);
        return new JsonResult<>(OK,districts);
    }
}
