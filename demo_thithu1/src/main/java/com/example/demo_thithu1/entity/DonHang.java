package com.example.demo_thithu1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "don_hang")
@Getter
@Setter
public class DonHang {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "ma_don_hang")
    private String maDonHang;


    @Column(name = "ngay_dat")
    private Date ngayDat;


    @Column(name = "tong_tien")
    private Double tongTien;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "khach_hang_id")
    private KhachHang khachHang;
}
