package com.example.demo_thithu4.model.response;

import com.example.demo_thithu4.entity.SanPham;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SanPhamResponse {

    private Long id;
    private String maSp;
    private String tenSp;
    private Integer giaBan;
    private Integer soLuongTon;
    private String tenKhuyenMai;

    public SanPhamResponse(SanPham sanPham) {
        this.id = sanPham.getId();
        this.maSp = sanPham.getMaSp();
        this.tenSp = sanPham.getTenSp();
        this.giaBan = sanPham.getGiaBan();
        this.soLuongTon = sanPham.getSoLuongTon();
        this.tenKhuyenMai = sanPham.getKhuyenMai().getTenKhuyenMai();
    }
}
