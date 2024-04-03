package com.example.duantotnghiep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/account")
public class LoginController {

    @GetMapping("/admin/dangnhap")
    public ModelAndView showLoginForm() {
        return new ModelAndView("dangnhap");
    }

    @PostMapping("/admin/dangnhap")
    public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password) {
        // Thực hiện xác thực tài khoản ở đây, ví dụ sử dụng Spring Security
        if (authenticationSuccess(0)) {
            return new ModelAndView("redirect:/index");
        } else {
            ModelAndView modelAndView = new ModelAndView("dangnhap");
            modelAndView.addObject("loginFail", true);
            return modelAndView;
        }
    }

    private boolean authenticationSuccess(int roles) {
        // Thực hiện xác thực tài khoản ở đây, ví dụ sử dụng Spring Security
        // Trong ví dụ này, giả sử username và password đều phải là "admin" để đăng nhập thành công
        return roles == 1;
    }

    @GetMapping("/index")
    public ModelAndView showIndex() {
        return new ModelAndView("index");
    }

//    @Autowired
////    private AuthenticationService authenticationService;
//
//    @GetMapping("/dangnhap")
//    public String showLoginForm() {
//        return "pages/account/dangnhap";
//    }
//
//    @PostMapping("/dangnhap")
//    public String processLoginForm(@RequestParam("username") String username, @RequestParam("password") String password) {
////        boolean isAuthenticated = authenticationService.authenticate(username, password);
////        if (isAuthenticated) {
////            return "redirect:/home";
////        } else {
//            return "redirect:/account/dangnhap?error";
////        }
//
//    }
}
