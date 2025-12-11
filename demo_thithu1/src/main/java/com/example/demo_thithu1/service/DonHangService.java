package com.example.demo_thithu1.service;

import com.example.demo_thithu1.entity.DonHang;
import com.example.demo_thithu1.entity.KhachHang;
import com.example.demo_thithu1.model.request.DonHangRequest;
import com.example.demo_thithu1.model.response.DonHangResponse;
import com.example.demo_thithu1.repository.DonHangRepository;
import com.example.demo_thithu1.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonHangService {


    @Autowired
    private DonHangRepository donHangRepository;


    @Autowired
    private KhachHangRepository khachHangRepository;


    public List<DonHangResponse> findAll() {
        return donHangRepository.findAll()
                .stream()
                .map(DonHangResponse::new)
                .toList();
    }


    public DonHangResponse add(DonHangRequest request) {
        DonHang dh = new DonHang();
        mapRequestToEntity(request, dh);
        dh = donHangRepository.save(dh);
        return new DonHangResponse(dh);
    }


    public DonHangResponse update(Long id, DonHangRequest request) {
        DonHang dh = donHangRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Đơn hàng không tồn tại"));
        mapRequestToEntity(request, dh);
        dh = donHangRepository.save(dh);
        return new DonHangResponse(dh);
    }


    public void delete(Long id) {
        donHangRepository.deleteById(id);
    }


    private void mapRequestToEntity(DonHangRequest req, DonHang dh) {
        dh.setMaDonHang(req.getMaDonHang());
        dh.setNgayDat(req.getNgayDat());
        dh.setTongTien(req.getTongTien());


        KhachHang kh = khachHangRepository.findById(req.getIdKhachHang())
                .orElseThrow(() -> new RuntimeException("Khách hàng không tồn tại"));


        dh.setKhachHang(kh);
    }
}
