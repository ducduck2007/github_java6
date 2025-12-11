package com.example.demo_thithu4.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "san_pham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "khuyen_mai_id")
    private KhuyenMai khuyenMai;

    @Column(name = "ma_sp", length = 50)
    private String maSp;

    @Nationalized
    @Column(name = "ten_sp", length = 100)
    private String tenSp;

    @Nationalized
    @Column(name = "mo_ta")
    private String moTa;

    @Column(name = "gia_ban")
    private Integer giaBan;

    @Column(name = "so_luong_ton")
    private Integer soLuongTon;

    @Column(name = "ngay_nhap")
    private LocalDate ngayNhap;


}