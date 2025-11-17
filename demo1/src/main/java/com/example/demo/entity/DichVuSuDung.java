package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "dich_vu_su_dung")
public class DichVuSuDung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "dich_vu_id")
    private Integer dichVuId;

    @Column(name = "chi_tiet_hoa_don_id")
    private Integer chiTietHoaDonId;

    @Size(max = 20)
    @Column(name = "ma", length = 20)
    private String ma;

    @Size(max = 50)
    @Column(name = "ten", length = 50)
    private String ten;

    @Column(name = "so_luong")
    private Integer soLuong;

    @Size(max = 50)
    @Nationalized
    @Column(name = "ghi_chu", length = 50)
    private String ghiChu;

    @Column(name = "trang_thai")
    private Integer trangThai;

    @Column(name = "ngay_tao")
    private LocalDate ngayTao;

    @Column(name = "ngay_chinh_sua")
    private LocalDate ngayChinhSua;

}