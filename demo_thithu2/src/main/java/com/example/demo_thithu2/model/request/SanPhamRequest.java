package com.example.demo_thithu2.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SanPhamRequest {

    private String maSP;
    private String tenSP;
    private Integer giaBan;
    private Integer soLuongTon;
    private Long idKhuyenMai;
}
