package com.icbc.restfulservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TemplatesController {
    @RequestMapping("/openmsra")
    public String OpenMsra(){
        return "OpenMsra.html";
    }
    @RequestMapping("/FileListIndex")
    public  String IdFileList(){
        return  "IdFileList.html";
    }
}
