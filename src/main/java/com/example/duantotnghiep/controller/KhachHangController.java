package com.example.duantotnghiep.controller;

import com.example.duantotnghiep.entity.KhachHang;
import com.example.duantotnghiep.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/khachhang")
public class KhachHangController {

    @Autowired
    private KhachHangService khachHangService;

    @PostMapping
    public ResponseEntity<KhachHang> createKhachHang(@RequestBody KhachHang khachHang) {
        KhachHang createdKhachHang = khachHangService.createKhachHang(khachHang);
        return new ResponseEntity<>(createdKhachHang, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<KhachHang>> getAllKhachHangs() {
        List<KhachHang> khachHangs = khachHangService.getAllKhachHangs();
        return new ResponseEntity<>(khachHangs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<KhachHang> getKhachHangById(@PathVariable UUID id) {
        Optional<KhachHang> khachHang = khachHangService.getKhachHangById(id);
        return khachHang.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<KhachHang> updateKhachHang(@PathVariable UUID id, @RequestBody KhachHang khachHang) {
        KhachHang updatedKhachHang = khachHangService.updateKhachHang(id, khachHang);
        if (updatedKhachHang != null) {
            return new ResponseEntity<>(updatedKhachHang, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKhachHang(@PathVariable UUID id) {
        khachHangService.deleteKhachHang(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
