package com.example.demo_thithu2.service;

import com.example.demo_thithu2.entity.KhuyenMai;
import com.example.demo_thithu2.entity.SanPham;
import com.example.demo_thithu2.model.request.SanPhamRequest;
import com.example.demo_thithu2.model.response.SanPhamResponse;
import com.example.demo_thithu2.repository.KhuyenMaiRepository;
import com.example.demo_thithu2.repository.SanPhamRepository;
import com.example.demo_thithu2.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhamService {

    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Autowired
    private KhuyenMaiRepository khuyenMaiRepository;

    public List<SanPhamResponse> findAll() {
        return sanPhamRepository.findAll()
                .stream()
                .map(SanPhamResponse::new)
                .toList();
    }

    private void mapKhuyenMai(SanPhamRequest sanPhamRequest, SanPham sanPham) {
        KhuyenMai khuyenMai = khuyenMaiRepository.findById(sanPhamRequest.getIdKhuyenMai())
                .orElseThrow(() -> new RuntimeException("Khuyen mai khong ton tai"));
        sanPham.setKhuyenMai(khuyenMai);
    }

    public SanPhamResponse add(SanPhamRequest sanPhamRequest) {
        if (sanPhamRepository.existsByMaSP(sanPhamRequest.getMaSP())) {
            throw new RuntimeException("Ma san pham da ton tai");
        }

        SanPham sanPham = MapperUtil.map(sanPhamRequest, SanPham.class);
        mapKhuyenMai(sanPhamRequest, sanPham);
        sanPham = sanPhamRepository.save(sanPham);
        return new SanPhamResponse(sanPham);
    }

    public SanPhamResponse update(Long id, SanPhamRequest sanPhamRequest) {
        SanPham sanPham = sanPhamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("San pham khong ton tai"));

        if (sanPhamRepository.existsByMaSPAndIdNot(sanPhamRequest.getMaSP(), id)) {
            throw new RuntimeException("Ma san pham da ton tai");
        }

        MapperUtil.mapToExisting(sanPhamRequest, sanPham);
        mapKhuyenMai(sanPhamRequest, sanPham);

        sanPham = sanPhamRepository.save(sanPham);
        return new SanPhamResponse(sanPham);
    }

    public void delete(Long id) {
        sanPhamRepository.deleteById(id);
    }
}
