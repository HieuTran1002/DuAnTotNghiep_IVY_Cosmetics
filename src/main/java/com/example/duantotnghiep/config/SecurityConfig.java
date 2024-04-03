package com.example.duantotnghiep.config;

import com.example.duantotnghiep.entity.TaiKhoan;
import com.example.duantotnghiep.service.KhachHangService;
import com.example.duantotnghiep.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .cors(Customizer.withDefaults())
//                .csrf(csrf -> csrf.disable())
//                .authorizeRequests()
//                .requestMatchers("/auth/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
////                .exceptionHandling(ex -> ex.authenticationEntryPoint(point))
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
//        return http.build();
//    }

    @Autowired
    private TaiKhoanService taiKhoanService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailService() {
        List<TaiKhoan> taiKhoanList = taiKhoanService.getAllTaiKhoans();
        PasswordEncoder encoder = passwordEncoder();
        List<UserDetails> userDetailsList = new ArrayList<>();
        for (int i = 0; i < taiKhoanList.size(); i++) {
            UserDetails user = User.builder()
                    .username(taiKhoanList.get(i).getUsername())
                    .password(encoder.encode(taiKhoanList.get(i).getMatKhau()))
                    .roles(taiKhoanService.getRoles(taiKhoanList.get(i)))
                    .build();
            userDetailsList.add(user);
//            UserDetails admin = User.builder()
//                    .username(taiKhoanList.get(i).getUsername())
//                    .password(encoder.encode(taiKhoanList.get(i).getMatKhau()))
//                    .roles(taiKhoanService.getRoles(taiKhoanList.get(i)))
//                    .build();
//            userDetailsList.add(admin);
        }
        return new InMemoryUserDetailsManager(userDetailsList);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(
                req -> req.requestMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().permitAll()
                ).formLogin(login ->login.loginProcessingUrl("/admin/dangnhap"));
        return httpSecurity.build();
    }
}
