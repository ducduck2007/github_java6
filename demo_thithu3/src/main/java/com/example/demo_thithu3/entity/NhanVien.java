package com.example.demo_thithu3.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "nhan_vien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "ma_nv", length = 50)
    private String maNv;

    @Nationalized
    @Column(name = "ten_nv", length = 100)
    private String tenNv;

    @Column(name = "ngay_sinh")
    private LocalDate ngaySinh;

    @Column(name = "luong")
    private Integer luong;

    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;

    @Column(name = "trang_thai")
    private Boolean trangThai;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phong_ban_id")
    private PhongBan phongBan;
}