package com.example.demo_thithu2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "khuyen_mai")
@Getter
@Setter
public class KhuyenMai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ten_khuyen_mai")
    private String tenKhuyenMai;
}
