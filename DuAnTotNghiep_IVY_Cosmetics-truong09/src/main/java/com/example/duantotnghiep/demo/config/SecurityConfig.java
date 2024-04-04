//package com.example.duantotnghiep.demo.config;
//
//import com.example.duantotnghiep.demo.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//
//        return new BCryptPasswordEncoder();
//    }
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeHttpRequests(
//                req ->req
////                        requestMatchers("/admin/**").hasRole("ADMIN")
////                        .requestMatchers("/user/**").hasAnyRole("USER","ADMIN")
//                        .requestMatchers("/**").permitAll()
//                        .anyRequest().authenticated()
//        ).formLogin(login ->login.loginPage("/login").permitAll()
//                .successHandler(((request, response, authentication) -> {
//                    // chuyen huong dua tren vai tro cua nguoi dung
//                    if(authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))){
//                        response.sendRedirect("/admin/");
//                    }else if(authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER"))){
//                        response.sendRedirect("/user/home/view");
//                    }else {
//                        response.sendRedirect("/access-denied");// truong hop khong xac dinh duoc
//                    }
//                }))
//        )
//         .logout(logout ->logout.permitAll());
//        return httpSecurity.build();
//    }
//
//}
