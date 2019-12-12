package com.jyu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @RequestMapping(value = "/index.html")
    public String getIndex(){
        return "index";
    }
}
