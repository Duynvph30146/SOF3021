package com.exam.controller;

import com.exam.entity.KhachHang;
import com.exam.entity.PhieuGiamGia;
import com.exam.service.KhachHangService;
import com.exam.service.PhieuGiamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PhieuGiamGiaController {
    @Autowired
    PhieuGiamService phieuGiamService;
    @Autowired
    KhachHangService khachHangService;

    @GetMapping("/phieu-giam-gia/hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("list", phieuGiamService.findAll());
        return "phieu-giam-gia/index";
    }

    @GetMapping("abc")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(phieuGiamService.findAll());//trả ra 1 file json
    }


    @GetMapping("/phieu-giam-gia/delete/{maphieu}")
    public String delete(@PathVariable String maphieu) {
        phieuGiamService.deleteById(maphieu);
        return "redirect:/phieu-giam-gia/hien-thi";
    }

    @GetMapping("/phieu-giam-gia/update/{maphieu}")
    public String update(@PathVariable String maphieu, Model model) {
        model.addAttribute("pgg", phieuGiamService.getById(maphieu));
        return "phieu-giam-gia/update";
    }

    @PostMapping("/phieu-giam-gia/update/{maphieu}")
    public String update(@PathVariable String maphieu, @Valid @ModelAttribute("pgg") PhieuGiamGia pgg, BindingResult rs, Model model) {
        boolean hasError = false;
        if (rs.hasErrors()) {
            model.addAttribute("error", "Một số trường có lỗi");
            hasError = true;
        }
        if (pgg.getNgaybatdau() != null && pgg.getNgayketthuc() != null
                && pgg.getNgaybatdau().getTime() >
                pgg.getNgayketthuc().getTime()) {
            hasError = true;
            model.addAttribute("errDate", "Ngày bắt đầu phải trước kết thúc");
        }
        if (hasError) {
            return "phieu-giam-gia/update";
        }
        pgg.setMaphieu(maphieu);
        phieuGiamService.save(pgg);
        return "redirect:/phieu-giam-gia/hien-thi";
    }

    @ModelAttribute("dsKhachHang")
    public List<KhachHang> getDSKhachHang() {
        return khachHangService.findAll();
    }

    @GetMapping("/phieu-giam-gia/viewAdd")
    public String viewAdd(@ModelAttribute("pgg") PhieuGiamGia phieuGiamGia) {
        return "phieu-giam-gia/add";
    }

    @PostMapping("/phieu-giam-gia/viewAdd")
    public String add(@Valid @ModelAttribute("pgg") PhieuGiamGia phieuGiamGia, BindingResult rs, Model model) {
        if (rs.hasErrors()) {
            model.addAttribute("error", "Một số trường có lỗi");
            return "phieu-giam-gia/add";
        }
        phieuGiamService.save(phieuGiamGia);
        return "redirect:/phieu-giam-gia/hien-thi";
    }
}
