package com.example.demo_thithu3.model.response;

import com.example.demo_thithu3.entity.NhanVien;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NhanVienResponse {

    private Long id;
    private String maNv;
    private String tenNv;
    private Integer luong;
    private Boolean trangThai;
    private String tenPhongBan;
    private String diaChi;

    public NhanVienResponse(NhanVien nhanVien) {
        this.id = nhanVien.getId();
        this.maNv = nhanVien.getMaNv();
        this.tenNv = nhanVien.getTenNv();
        this.luong = nhanVien.getLuong();
        this.trangThai = nhanVien.getTrangThai();
        this.tenPhongBan = nhanVien.getPhongBan().getTenPhongBan();
        this.diaChi = nhanVien.getPhongBan().getDiaChi();
    }
}
