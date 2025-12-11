package com.example.demo_thithu1.model.response;

import com.example.demo_thithu1.entity.DonHang;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DonHangResponse {


    private Long id;
    private String maDonHang;
    private Date ngayDat;
    private Double tongTien;

    private String tenKhachHang;
    private String diaChi;


    public DonHangResponse(DonHang dh) {
        this.id = dh.getId();
        this.maDonHang = dh.getMaDonHang();
        this.ngayDat = dh.getNgayDat();
        this.tongTien = dh.getTongTien();
        this.tenKhachHang = dh.getKhachHang().getTenKhachHang();
        this.diaChi = dh.getKhachHang().getDiaChi();
    }
}
