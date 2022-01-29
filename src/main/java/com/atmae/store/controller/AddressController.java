package com.atmae.store.controller;


import com.atmae.store.entity.Address;
import com.atmae.store.service.IAddressService;
import com.atmae.store.util.JsonResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Mae
 */
@RestController
@RequestMapping("/address")
public class AddressController extends BaseController {
    @Resource
    private IAddressService addressService;

    @RequestMapping("/addNewAddress")
    public JsonResult<Void> addNewAddress(Address address, HttpSession session) {
        Integer userId = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        addressService.addNewAddress(userId, username, address);
        return new JsonResult<>(OK);
    }

    @RequestMapping("/addressList")
    public JsonResult<List<Address>> getAddressByUserId(HttpSession session) {
        Integer userId = getUidFromSession(session);
        List<Address> addresses = addressService.getByUserId(userId);
        return new JsonResult<>(OK, addresses);
    }

    @RequestMapping("/{id}/setDefault")
    public JsonResult<Void> setDefault(@PathVariable("id") Integer addressId, HttpSession session) {
        addressService.setDefault(addressId, getUidFromSession(session), getUsernameFromSession(session));
        return new JsonResult<>(OK);
    }

    @RequestMapping("/{id}/delete")
    public JsonResult<Void> delete(@PathVariable("id") Integer addressId, HttpSession session) {
        addressService.deleteAddress(addressId, getUidFromSession(session), getUsernameFromSession(session));
        return new JsonResult<>(OK);
    }
}
