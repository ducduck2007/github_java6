package com.example.demo_thithu2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "san_pham")
@Getter
@Setter
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ma_sp")
    private String maSP;

    @Column(name = "ten_sp")
    private String tenSP;

    @Column(name = "gia_ban")
    private Integer giaBan;

    @Column(name = "so_luong_ton")
    private Integer soLuongTon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "khuyen_mai_id")
    private KhuyenMai khuyenMai;
}
