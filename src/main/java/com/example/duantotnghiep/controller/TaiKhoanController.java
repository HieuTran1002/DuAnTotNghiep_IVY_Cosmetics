package com.example.duantotnghiep.controller;

import com.example.duantotnghiep.entity.TaiKhoan;
import com.example.duantotnghiep.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RestController
public class TaiKhoanController {

    @Autowired
    private TaiKhoanService taiKhoanService;

    @PostMapping
    public ResponseEntity<TaiKhoan> createTaiKhoan(@RequestBody TaiKhoan taiKhoan) {
        TaiKhoan createdTaiKhoan = taiKhoanService.createTaiKhoan(taiKhoan);
        return new ResponseEntity<>(createdTaiKhoan, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TaiKhoan>> getAllTaiKhoans() {
        List<TaiKhoan> taiKhoans = taiKhoanService.getAllTaiKhoans();
        return new ResponseEntity<>(taiKhoans, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaiKhoan> getTaiKhoanById(@PathVariable UUID id) {
        Optional<TaiKhoan> taiKhoan = taiKhoanService.getTaiKhoanById(id);
        return taiKhoan.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaiKhoan> updateTaiKhoan(@PathVariable UUID id, @RequestBody TaiKhoan taiKhoan) {
        TaiKhoan updatedTaiKhoan = taiKhoanService.updateTaiKhoan(id, taiKhoan);
        if (updatedTaiKhoan != null) {
            return new ResponseEntity<>(updatedTaiKhoan, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaiKhoan(@PathVariable UUID id) {
        taiKhoanService.deleteTaiKhoan(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
