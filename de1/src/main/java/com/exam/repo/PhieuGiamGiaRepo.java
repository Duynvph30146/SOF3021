package com.exam.repo;

import com.exam.entity.PhieuGiamGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PhieuGiamGiaRepo extends JpaRepository<PhieuGiamGia, String> {
//    @Query("SELECT p FROM PhieuGiamGia p WHERE p.category.id=?1")
//    List<PhieuGiamGia> findByCategory(String cid);
}
