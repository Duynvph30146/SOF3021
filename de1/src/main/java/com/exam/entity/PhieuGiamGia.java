package com.exam.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "phieugiamgia")
public class PhieuGiamGia {
    @Id
    String maphieu;

    @NotBlank(message = "Ten phieu khong duoc trong")
    String tenphieu;

    @NotNull(message = "Ngay bat dau khong duoc trong")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date ngaybatdau;

    @NotNull(message = "Ngay ket thuc khong duoc trong")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date ngayketthuc;

    @NotNull(message = "Giá trị giảm khong duoc trong")
    Double giatrigiam;

    Boolean trangthai;

    @Valid @NotNull(message = "Khach hang khong duoc trong")
    @ManyToOne
    @JoinColumn(name = "nguoisohuu")
    KhachHang nguoisohuu;
}
