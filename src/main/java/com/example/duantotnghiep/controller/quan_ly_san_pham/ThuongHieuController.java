package com.example.duantotnghiep.controller.quan_ly_san_pham;

import com.example.duantotnghiep.entity.ThuongHieu;
import com.example.duantotnghiep.service.thuong_hieu_service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/thuong-hieu")
public class ThuongHieuController {

//    public ResponseEntity<List<ThuongHieu>> getAllThuongHieu(
//            @RequestParam(name = "tenThuongHieu", required = false) String tenThuongHieu,
//            @RequestParam(name = "trangThai", required = false) Integer trangThai
//    ){
//        return new ResponseEntity<>(t)
//    }

    @Autowired
    private ThuongHieuService thuongHieuService;

    @GetMapping("/thuonghieu")
    public String getAllThuongHieu(Model model) {
        model.addAttribute("thuongHieuList", thuongHieuService.getAll());
        return "thuonghieu";
    }
}
