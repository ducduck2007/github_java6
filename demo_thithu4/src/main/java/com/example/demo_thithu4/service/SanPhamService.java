package com.example.demo_thithu4.service;

import com.example.demo_thithu4.entity.KhuyenMai;
import com.example.demo_thithu4.entity.SanPham;
import com.example.demo_thithu4.model.request.SanPhamRequest;
import com.example.demo_thithu4.model.response.SanPhamResponse;
import com.example.demo_thithu4.repository.KhuyenMaiRepository;
import com.example.demo_thithu4.repository.SanPhamRepository;
import com.example.demo_thithu4.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhamService {

    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Autowired
    private KhuyenMaiRepository khuyenMaiRepository;

    public List<SanPhamResponse> getAll() {
        return sanPhamRepository.findAll()
                .stream()
                .map(SanPhamResponse::new)
                .toList();
    }

    private void mapKhuyenMai(SanPhamRequest request, SanPham sanPham) {
        KhuyenMai khuyenMai = khuyenMaiRepository.findById(request.getIdKhuyenMai())
                .orElseThrow(() -> new RuntimeException("Khuyen mai khong ton tai"));
        sanPham.setKhuyenMai(khuyenMai);
    }

    public void add(SanPhamRequest request) {
        if (sanPhamRepository.existsByMaSp(request.getMaSp())) {
            throw new RuntimeException("Ma san pham da ton tai");
        }

        SanPham sanPham = MapperUtil.map(request, SanPham.class);
        mapKhuyenMai(request, sanPham);
        sanPhamRepository.save(sanPham);
    }

    public void update(Long id, SanPhamRequest request) {
        SanPham sanPham = sanPhamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("San pham khong ton tai"));

        if (sanPhamRepository.existsByMaSpAndIdNot(request.getMaSp(), id)) {
            throw new RuntimeException("Ma san pham da ton tai");
        }

        MapperUtil.mapToExisting(request, sanPham);
        mapKhuyenMai(request, sanPham);
        sanPhamRepository.save(sanPham);
    }

    public void delete(Long id) {
        sanPhamRepository.deleteById(id);
    }
}
