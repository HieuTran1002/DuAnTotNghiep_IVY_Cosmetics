package com.example.duantotnghiep.controller;

import com.example.duantotnghiep.entity.NhanVien;
import com.example.duantotnghiep.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/nhanvien")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    @PostMapping
    public ResponseEntity<NhanVien> createNhanVien(@RequestBody NhanVien nhanVien) {
        NhanVien createdNhanVien = nhanVienService.createNhanVien(nhanVien);
        return new ResponseEntity<>(createdNhanVien, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<NhanVien>> getAllNhanViens() {
        List<NhanVien> nhanViens = nhanVienService.getAllNhanViens();
        return new ResponseEntity<>(nhanViens, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NhanVien> getNhanVienById(@PathVariable UUID id) {
        Optional<NhanVien> nhanVien = nhanVienService.getNhanVienById(id);
        return nhanVien.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NhanVien> updateNhanVien(@PathVariable UUID id, @RequestBody NhanVien nhanVien) {
        NhanVien updatedNhanVien = nhanVienService.updateNhanVien(id, nhanVien);
        if (updatedNhanVien != null) {
            return new ResponseEntity<>(updatedNhanVien, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNhanVien(@PathVariable UUID id) {
        nhanVienService.deleteNhanVien(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
