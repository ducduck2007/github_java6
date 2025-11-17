package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "dich_vu")
public class DichVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "loai_dich_vu_id")
    private Integer loaiDichVuId;

    @Size(max = 20)
    @Column(name = "ma", length = 20)
    private String ma;

    @Size(max = 30)
    @Nationalized
    @Column(name = "ten", length = 30)
    private String ten;

    @Size(max = 30)
    @Nationalized
    @Column(name = "don_vi_tinh", length = 30)
    private String donViTinh;

    @Column(name = "don_gia", precision = 20)
    private BigDecimal donGia;

    @Size(max = 50)
    @Nationalized
    @Column(name = "mo_ta", length = 50)
    private String moTa;

    @Column(name = "trang_thai")
    private Integer trangThai;

    @Column(name = "ngay_tao")
    private LocalDate ngayTao;

    @Column(name = "ngay_chinh_sua")
    private LocalDate ngayChinhSua;

}