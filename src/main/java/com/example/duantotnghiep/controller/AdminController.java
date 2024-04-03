package com.example.duantotnghiep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/home")
    public String home(){
        return "testAdmin";
    }

//    @GetMapping("/dangnhap")
//    public ModelAndView showLoginForm(){
//        return new ModelAndView("pages/account/dangnhap");
//    }
    @PostMapping("/dangnhap")
    public String showLoginForm() {
//        boolean isAuthenticated =
//        if (isAuthenticated) {
            return "redirect:/pages/account/dangnhap";
    }
}
