package com.example.demo.model.request;

import com.example.demo.entity.ChucVu;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class NhanVienRequest {

    private Long id;

    private String maNhanVien;
    private String tenNhanVien;
    private String gioiTinh;
    private Date ngaySinh;

    private Long idChucVu;
}
