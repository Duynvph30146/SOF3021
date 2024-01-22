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

    @NotBlank(message = "Tên phiếu không được để trống")
    String tenphieu;

    @NotNull(message = "Ngày bắt đầu không được để trống")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date ngaybatdau;

    @NotNull(message = "Ngày kết thúc không được để trống")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date ngayketthuc;

    @NotNull(message = "Giá trị giảm không được để trống")
    Double giatrigiam;

    Boolean trangthai;

    @NotNull(message = "Khách hàng không được để trống")
    @ManyToOne
    @JoinColumn(name = "nguoisohuu")
    KhachHang nguoisohuu;
}
