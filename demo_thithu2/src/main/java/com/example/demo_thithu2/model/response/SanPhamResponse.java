package com.example.demo_thithu2.model.response;

import com.example.demo_thithu2.entity.SanPham;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SanPhamResponse {

    private Long id;
    private String maSP;
    private String tenSP;
    private Integer giaBan;
    private Integer soLuongTon;
    private String tenKhuyenMai;

    public SanPhamResponse(SanPham sanPham) {
        this.id = sanPham.getId();
        this.maSP = sanPham.getMaSP();
        this.tenSP = sanPham.getTenSP();
        this.giaBan = sanPham.getGiaBan();
        this.soLuongTon = sanPham.getSoLuongTon();
        this.tenKhuyenMai = sanPham.getKhuyenMai().getTenKhuyenMai();
    }
}
