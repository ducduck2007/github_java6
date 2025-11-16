package com.example.demo.model.response;

import com.example.demo.entity.NhanVien;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class NhanVienResponse {
    private String maNhanVien;
    private String tenNhanVien;
    private String gioiTinh;
    private Date ngaySinh;

    private String tenChucVu;

    public NhanVienResponse(NhanVien nhanVien) {
        this.maNhanVien = nhanVien.getMaNhanVien();
        this.tenNhanVien = nhanVien.getTenNhanVien();
        this.gioiTinh = nhanVien.getGioiTinh();
        this.ngaySinh = nhanVien.getNgaySinh();

        this.tenChucVu = nhanVien.getChucVu() != null ? nhanVien.getChucVu().getTenChucVu() : null;
    }
}
