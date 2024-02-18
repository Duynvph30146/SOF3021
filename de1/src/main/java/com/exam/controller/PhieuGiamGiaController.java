package com.exam.controller;

import com.exam.entity.KhachHang;
import com.exam.entity.PhieuGiamGia;
import com.exam.repo.PhieuGiamGiaRepo;
import com.exam.service.KhachHangService;
import com.exam.service.PhieuGiamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PhieuGiamGiaController {
    @Autowired
    PhieuGiamService phieuGiamService;
    @Autowired
    PhieuGiamGiaRepo phieuGiamGiaRepo;
    int PAGE_SIZE = 5;


    @Autowired
    KhachHangService khachHangService;


//    @GetMapping("/phieu-giam-gia/hien-thi")
//    public String hienThi(Model model) {
//        Sort sortByUsername = Sort.by(Sort.Direction.ASC, "maphieu");
//        model.addAttribute("list", this.phieuGiamService.findAll(sortByUsername));
//        return "phieu-giam-gia/index";
//    }

    @GetMapping("/phieu-giam-gia/hien-thi")
    public String hienThi(@RequestParam(value = "p", defaultValue = "0") int p, Model model) {
        Sort sort = Sort.by(Sort.Direction.ASC, "tenphieu");
        Pageable pageable = PageRequest.of(p, PAGE_SIZE, sort);
        Page<PhieuGiamGia> page = phieuGiamGiaRepo.findAll(pageable);
        model.addAttribute("page", page);
        return "phieu-giam-gia/index";
    }


//    @GetMapping("/list-product")
//    public String listProduct(@RequestParam(value = "p", defaultValue = "0") int p, Model model) {
//        Sort sort = Sort.by(Sort.Direction.ASC, "name");//giảm dần theo name
//        Pageable pageable = PageRequest.of(p, PAGE_SIZE, sort);
//        Page<Product> page = repo.findAll(pageable);
//        model.addAttribute("page", page);
//        return "product/list";


    @GetMapping("abc")
    public ResponseEntity<?> getAll() {
        Sort sortByUsername = Sort.by(Sort.Direction.ASC, "maphieu");
        return ResponseEntity.ok(phieuGiamService.findAll(sortByUsername));//trả ra 1 file json
    }


    @GetMapping("/phieu-giam-gia/delete/{maphieu}")
    public String delete(@PathVariable("maphieu") String maphieu) {
        phieuGiamService.deleteById(maphieu);
        return "redirect:/phieu-giam-gia/hien-thi";
    }

    @GetMapping("/phieu-giam-gia/update/{maphieu}")
    public String update(@PathVariable String maphieu, Model model) {
        model.addAttribute("pgg", phieuGiamService.getById(maphieu));
        return "phieu-giam-gia/update";
    }

    //    @PostMapping("/phieu-giam-gia/update/{maphieu}")
////    public String update(@PathVariable String maphieu, @Valid @ModelAttribute("pgg") PhieuGiamGia pgg, BindingResult rs, Model model) {
////        boolean hasError = false;
////        if (rs.hasErrors()) {
////            model.addAttribute("error", "Một số trường có lỗi");
////            hasError = true;
////        }
////        if (pgg.getNgaybatdau() != null && pgg.getNgayketthuc() != null
////                && pgg.getNgaybatdau().getTime() >
////                pgg.getNgayketthuc().getTime()) {
////            hasError = true;
////            model.addAttribute("errDate", "Ngày bắt đầu phải trước kết thúc");
////        }
////        if (hasError) {
////            return "phieu-giam-gia/update";
////        }
////        pgg.setMaphieu(maphieu);
////        phieuGiamService.save(pgg);
////        return "redirect:/phieu-giam-gia/hien-thi";
////    }
    @PostMapping("/phieu-giam-gia/update/{maphieu}")
    public String update(@PathVariable String maphieu, @Valid @ModelAttribute("pgg") PhieuGiamGia pgg, BindingResult rs, Model model) {
        boolean hasError = false;
        if (rs.hasErrors()) {
            model.addAttribute("error", "Một số trường có lỗi");
            hasError = true;
        }
        if (pgg.getNgaybatdau() != null && pgg.getNgayketthuc() != null) {
            if (pgg.getNgaybatdau().after(pgg.getNgayketthuc())) {
                hasError = true;
                model.addAttribute("errDate", "Ngày bắt đầu phải trước kết thúc");
            }
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
        boolean hasError = false;
        if (rs.hasErrors()) {
            model.addAttribute("error", "Một số trường có lỗi");
            return "phieu-giam-gia/add";
        }
        if (phieuGiamGia.getNgaybatdau() != null && phieuGiamGia.getNgayketthuc() != null) {
            if (phieuGiamGia.getNgaybatdau().after(phieuGiamGia.getNgayketthuc())) {
                hasError = true;
                model.addAttribute("errDate", "Ngày bắt đầu phải trước kết thúc");
            }
        }
        if (hasError) {
            return "phieu-giam-gia/add";
        }
        phieuGiamService.save(phieuGiamGia);
        return "redirect:/phieu-giam-gia/hien-thi";
    }
}
