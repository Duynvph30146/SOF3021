package com.exam.service;

import com.exam.entity.KhachHang;
import com.exam.repo.KhachHangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangService {
    @Autowired
    KhachHangRepo repo;
    public List<KhachHang> findAll() {
        return repo.findAll();
    }
}
