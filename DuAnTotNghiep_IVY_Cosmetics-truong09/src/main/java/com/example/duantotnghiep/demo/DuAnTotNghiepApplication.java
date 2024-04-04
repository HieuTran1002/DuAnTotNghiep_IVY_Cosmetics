package com.example.duantotnghiep.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableJpaRepositories(basePackages = "com.example.duantotnghiep.demo.repository")
@SpringBootApplication
@EnableCaching
@EnableScheduling
public class DuAnTotNghiepApplication {
    public static void main(String[] args) {
        SpringApplication.run(DuAnTotNghiepApplication.class, args);
    }
}
