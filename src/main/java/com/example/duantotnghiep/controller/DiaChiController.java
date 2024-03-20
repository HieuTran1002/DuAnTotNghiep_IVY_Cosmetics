package com.example.duantotnghiep.controller;

import com.example.duantotnghiep.service.DiaChiService;
import com.example.duantotnghiep.entity.DiaChi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/diachi")
public class DiaChiController {

    @Autowired
    private DiaChiService diaChiService;

    @PostMapping
    public ResponseEntity<DiaChi> createDiaChi(@RequestBody DiaChi diaChi) {
        DiaChi createdDiaChi = diaChiService.createDiaChi(diaChi);
        return new ResponseEntity<>(createdDiaChi, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DiaChi>> getAllDiaChis() {
        List<DiaChi> diaChis = diaChiService.getAllDiaChis();
        return new ResponseEntity<>(diaChis, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiaChi> getDiaChiById(@PathVariable UUID id) {
        Optional<DiaChi> diaChi = diaChiService.getDiaChiById(id);
        return diaChi.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiaChi> updateDiaChi(@PathVariable UUID id, @RequestBody DiaChi diaChi) {
        DiaChi updatedDiaChi = diaChiService.updateDiaChi(id, diaChi);
        if (updatedDiaChi != null) {
            return new ResponseEntity<>(updatedDiaChi, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiaChi(@PathVariable UUID id) {
        diaChiService.deleteDiaChi(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
