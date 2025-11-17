package com.example.demo.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DichVuSuDungResponse {
    private Integer id;
    private String maDichVuSuDung;
    private String maDichVu;
    private Integer soLuong;
    private LocalDate ngayTao;
    private Integer trangThai;
}
