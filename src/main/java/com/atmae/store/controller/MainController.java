package com.atmae.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;

/**
 * @author Mae
 */
@Controller
public class MainController {
    @GetMapping(value = {"/login", "/"})
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @GetMapping("/index")
    public String indexPage() {
        return "index";
    }

    @GetMapping("/changePassword")
    public String changePasswordPage() {
        return "change-psd";
    }

    @GetMapping("/info")
    public String infoPage() {
        return "info";
    }

    @GetMapping("/avatar")
    public String avatarPage() {
        return "avatar";
    }

    @GetMapping("/address")
    public String addressPage() {
        return "address";
    }

    @GetMapping("/addAddress")
    public String addAddressPage() {
        return "addAddress";
    }

    @GetMapping("/product")
    public String productPage() {
        return "product";
    }


    @GetMapping("/cart")
    public String cartPage() {
        return "cart";
    }

    @GetMapping("/buySell")
    public String buySellPage() {
        return "buy-sell";
    }

    @GetMapping("/orderConfirm")
    public String orderConfirmPage() {
        return "orderConfirm";
    }

    @GetMapping("/payment")
    public String paymentPage() {
        return "payment";
    }

    @GetMapping("/signOut")
    public String signOut(HttpSession session) {
        /** 销毁session*/
        session.invalidate();
        return "/login";
    }
}


