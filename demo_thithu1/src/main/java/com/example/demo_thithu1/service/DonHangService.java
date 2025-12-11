package com.example.demo_thithu1.service;

import com.example.demo_thithu1.entity.DonHang;
import com.example.demo_thithu1.entity.KhachHang;
import com.example.demo_thithu1.model.request.DonHangRequest;
import com.example.demo_thithu1.model.response.DonHangResponse;
import com.example.demo_thithu1.repository.DonHangRepository;
import com.example.demo_thithu1.repository.KhachHangRepository;
import com.example.demo_thithu1.util.MapperUtil;
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

        if (donHangRepository.existsByMaDonHang(request.getMaDonHang())) {
            throw new RuntimeException("Mã đơn hàng đã tồn tại");
        }

        DonHang dh = MapperUtil.map(request, DonHang.class);
        mapKhachHang(request, dh);
        dh = donHangRepository.save(dh);

        return new DonHangResponse(dh);
    }

    public DonHangResponse update(Long id, DonHangRequest request) {
        DonHang dh = donHangRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Đơn hàng không tồn tại"));

        if (donHangRepository.existsByMaDonHangAndIdNot(request.getMaDonHang(), id)) {
            throw new RuntimeException("Mã đơn hàng đã tồn tại");
        }

        MapperUtil.mapToExisting(request, dh);
        mapKhachHang(request, dh);

        dh = donHangRepository.save(dh);
        return new DonHangResponse(dh);
    }

    public void delete(Long id) {
        donHangRepository.deleteById(id);
    }

    private void mapKhachHang(DonHangRequest req, DonHang dh) {
        KhachHang kh = khachHangRepository.findById(req.getIdKhachHang())
                .orElseThrow(() -> new RuntimeException("Khách hàng không tồn tại"));
        dh.setKhachHang(kh);
    }
}
