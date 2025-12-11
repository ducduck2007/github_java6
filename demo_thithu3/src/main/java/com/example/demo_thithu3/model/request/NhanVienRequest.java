package com.example.demo_thithu3.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NhanVienRequest {

    private String maNv;
    private String tenNv;
    private Integer luong;
    private Boolean trangThai;
    private Long idPhongBan;
}
