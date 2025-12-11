package com.example.demo_thithu3.service;

import com.example.demo_thithu3.entity.NhanVien;
import com.example.demo_thithu3.entity.PhongBan;
import com.example.demo_thithu3.model.request.NhanVienRequest;
import com.example.demo_thithu3.model.response.NhanVienResponse;
import com.example.demo_thithu3.repository.NhanVienRepository;
import com.example.demo_thithu3.repository.PhongBanRepository;
import com.example.demo_thithu3.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;
    @Autowired
    private PhongBanRepository phongBanRepository;

    public List<NhanVienResponse> findAll() {
        return nhanVienRepository.findAll()
                .stream()
                .map(NhanVienResponse::new)
                .toList();
    }

    private void mapPhongBan(NhanVienRequest request, NhanVien nhanVien) {
        PhongBan phongBan = phongBanRepository.findById(request.getIdPhongBan())
                .orElseThrow(() -> new RuntimeException("Phong ban khong ton tai"));
        nhanVien.setPhongBan(phongBan);
    }

    public void add(NhanVienRequest request) {
        if (nhanVienRepository.existsByMaNv(request.getMaNv())) {
            throw new RuntimeException("Ma nhan vien da ton tai");
        }

        NhanVien nhanVien = MapperUtil.map(request, NhanVien.class);
        mapPhongBan(request, nhanVien);
        nhanVienRepository.save(nhanVien);
    }

    public void update(Long id, NhanVienRequest request) {
        NhanVien nhanVien = nhanVienRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nhan vien khong ton tai"));

        if (nhanVienRepository.existsByMaNvAndIdNot(request.getMaNv(), id)) {
            throw new RuntimeException("Ma nhan vien da ton tai");
        }

        MapperUtil.mapToExisting(request, nhanVien);
        mapPhongBan(request, nhanVien);
        nhanVienRepository.save(nhanVien);
    }

    public void delete(Long id) {
        nhanVienRepository.deleteById(id);
    }
}
