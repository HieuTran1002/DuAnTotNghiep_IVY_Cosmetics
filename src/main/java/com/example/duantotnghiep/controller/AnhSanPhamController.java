package com.example.duantotnghiep.controller;


import com.example.duantotnghiep.entity.AnhSanPham;
import com.example.duantotnghiep.service.AnhSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Controller
@RestController
public class AnhSanPhamController {
//    dùng để chứa đường dẫn tới thư mục lưu trữ
    private final Path fileStorageLocation= Paths.get("src/main/resources/static/upload");
    @Autowired
    private AnhSanPhamService anhSanPhamService;
    @GetMapping("/upload-file/view")
    public ModelAndView getAll(Model model){
        List<AnhSanPham> list=anhSanPhamService.getAll();
        model.addAttribute("list",list);
        model.addAttribute("AnhSanPham",new AnhSanPham());
        return new ModelAndView("admin/product/anhsanpham");
    }

    @PostMapping("/upload-file/add")
    public String add(@RequestParam("file")MultipartFile file, @ModelAttribute AnhSanPham AnhSanPham){
        if (file.isEmpty()){
            return "redirect:/upload-file/view";
        }
        try {
            // lưu file và thông tin của nó vào cơ sở dữ liệu
            AnhSanPham.setTenAnhSanPham(file.getOriginalFilename());
            anhSanPhamService.add(AnhSanPham);

            //lưu vào file vào thư mục static/uploads
            byte[] bytes=file.getBytes();
            Path path= fileStorageLocation.resolve(file.getOriginalFilename());
            Files.write(path,bytes);


        }catch (IOException e){
            e.printStackTrace();
        }
        return "redirect:/upload-file/view";

    }

    @GetMapping("/upload-file/detail/{id}")
    public String detail(@PathVariable UUID id,Model model){
        AnhSanPham AnhSanPham= anhSanPhamService.detail(id);
        model.addAttribute("AnhSanPham",AnhSanPham);
        return "admin/product/anhsanpham";
    }
    @PostMapping("/upload-file/update/{id}")
    public String update(@ModelAttribute AnhSanPham AnhSanPham,@PathVariable UUID id){
        anhSanPhamService.update(id,AnhSanPham);
        return "redirect:/upload-file/view";
    }
    @GetMapping("/upload-file/delete/{id}")
    public String delete(@PathVariable UUID id){
        anhSanPhamService.delete(id);
        return "redirect:/upload-file/view";
    }
}
