package com.nhom1.java6.Controller;

import com.nhom1.java6.Service.SecurityRestURL;
import com.nhom1.java6.Service.SecurityResttemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorizeController {
    String url = "http://localhost:2021/rest/authorities";

    @Autowired
    SecurityResttemplate resttemplate;


    @GetMapping("/rest/template")
    public String demo1(Model model){
        model.addAttribute("db",resttemplate.get(url));
        return "view";
    }

    @GetMapping("/rest/url")
    public String demo2(Model model){
        model.addAttribute("db",SecurityRestURL.get(url));
        return "view";
    }
}
