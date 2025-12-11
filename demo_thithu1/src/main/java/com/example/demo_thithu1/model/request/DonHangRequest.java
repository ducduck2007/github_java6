package com.example.demo_thithu1.model.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DonHangRequest {
    private String maDonHang;
    private Date ngayDat;
    private Double tongTien;


    private Long idKhachHang;
}
