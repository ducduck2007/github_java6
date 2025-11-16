package com.example.demo.service;

import com.example.demo.entity.ChucVu;
import com.example.demo.entity.NhanVien;
import com.example.demo.model.request.NhanVienRequest;
import com.example.demo.model.response.NhanVienResponse;
import com.example.demo.repository.NhanVienRepository;
import com.example.demo.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    public List<NhanVienResponse> findAll() {
        return nhanVienRepository.findAll()
                .stream()
                .map(NhanVienResponse::new)
                .toList();
    }

    public void add(NhanVienRequest req) {
        NhanVien nv = MapperUtil.map(req, NhanVien.class);

        if (req.getIdChucVu() != null) {
            ChucVu cv = new ChucVu();
            cv.setId(req.getIdChucVu());
            nv.setChucVu(cv);
        }

        nhanVienRepository.save(nv);
    }

    public void update(NhanVienRequest req, Long id) {

        NhanVien nv = nhanVienRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy nhân viên"));

        MapperUtil.mapToExisting(req, nv);

        if (req.getIdChucVu() != null) {
            ChucVu cv = new ChucVu();
            cv.setId(req.getIdChucVu());
            nv.setChucVu(cv);
        }

        nv.setId(id);

        nhanVienRepository.save(nv);
    }

    public void delete(Long id) {
        if (!nhanVienRepository.existsById(id)) {
            throw new RuntimeException("ID không tồn tại");
        }
        nhanVienRepository.deleteById(id);
    }
}
