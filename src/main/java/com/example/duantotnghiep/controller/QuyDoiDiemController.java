package com.example.duantotnghiep.controller;

import com.example.duantotnghiep.entity.QuyDoiDiem;
import com.example.duantotnghiep.service.QuyDoiDiemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RestController
public class QuyDoiDiemController {

    @Autowired
    private QuyDoiDiemService quyDoiDiemService;


    @GetMapping("/quydoidiem")
    public ModelAndView getAllQuyDoiDiem(Model model) {
        List<QuyDoiDiem> quyDoiDiemList = quyDoiDiemService.getAllQuyDoiDiems();
        model.addAttribute("quyDoiDiemList", quyDoiDiemList);
        return new ModelAndView("testpages/quydoidiem");
    }

    @GetMapping("/quydoidiem/{id}")
    public ModelAndView getQuyDoiDiemByIdWithModelAndView(@PathVariable UUID id, Model model) {
        Optional<QuyDoiDiem> quyDoiDiem = quyDoiDiemService.getQuyDoiDiemById(id);
        quyDoiDiem.ifPresent(value -> model.addAttribute("quyDoiDiem", value));
        return new ModelAndView("quydoidiem-detail");
    }

//    @GetMapping("/quydoidiem/{id}")
//    public String getQuyDoiDiemByIdWithString(@PathVariable UUID id, Model model) {
//        Optional<QuyDoiDiem> quyDoiDiem = quyDoiDiemService.getQuyDoiDiemById(id);
//        quyDoiDiem.ifPresent(value -> model.addAttribute("quyDoiDiem", value));
//        return "quydoidiem-detail";
//    }




    @PostMapping("/quydoidiem")
    public String createQuyDoiDiem(@ModelAttribute QuyDoiDiem quyDoiDiem) {
        quyDoiDiemService.createQuyDoiDiem(quyDoiDiem);
        return "redirect:/quydoidiem";
    }

    @PutMapping("/quydoidiem/{id}")
    public String updateQuyDoiDiem(@PathVariable UUID id, @ModelAttribute QuyDoiDiem quyDoiDiem) {
        quyDoiDiemService.updateQuyDoiDiem(id, quyDoiDiem);
        return "redirect:/quydoidiem";
    }

    @DeleteMapping("/quydoidiem/{id}")
    public String deleteQuyDoiDiem(@PathVariable UUID id) {
        quyDoiDiemService.deleteQuyDoiDiem(id);
        return "redirect:/quydoidiem";
    }
}
