package com.icbc.restfulservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OpenMsraController {
    @RequestMapping("/openmsra")
    public String OpenMsra(){
        return "OpenMsra";
    }
}
