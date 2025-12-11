package com.example.demo_thithu4.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SanPhamRequest {

    private String maSp;
    private String tenSp;
    private Integer giaBan;
    private Integer soLuongTon;
    private Long idKhuyenMai;
}
