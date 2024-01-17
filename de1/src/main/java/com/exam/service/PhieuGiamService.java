package com.exam.service;

import com.exam.entity.PhieuGiamGia;
import com.exam.repo.PhieuGiamGiaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhieuGiamService {
    @Autowired
    PhieuGiamGiaRepo repo;

    public List<PhieuGiamGia> findAll(Sort sortByUsername){
        return repo.findAll();
    }

    public PhieuGiamGia getById(String id){
        return repo.findById(id).orElse(null);
    }

    public PhieuGiamGia save(PhieuGiamGia pgg) {
        return repo.save(pgg);
    }

    public void deleteById(String id) {
        repo.deleteById(id);
    }
}
