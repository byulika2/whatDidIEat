package pongdew.portal.whatdidieat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WhatDidIEatController {

    @GetMapping({"/", "/dashboard"})
    public String dashboard(){
        return  "contents/dashboard";
    }


    @GetMapping("/payments")
    public String payments() {
        return "contents/payments";
    }
}
