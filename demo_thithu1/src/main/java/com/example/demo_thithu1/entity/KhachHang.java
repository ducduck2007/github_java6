package com.example.demo_thithu1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "khach_hang")
@Getter
@Setter
public class KhachHang {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "ten_khach_hang")
    private String tenKhachHang;


    @Column(name = "dia_chi")
    private String diaChi;
}
