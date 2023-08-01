package com.nhom1.java6.advice;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GeneralAdvice {
    @ModelAttribute
    public void getRequest(Model model, HttpServletRequest req) {
        model.addAttribute("request",req);
    }
}
