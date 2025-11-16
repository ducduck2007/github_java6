package com.example.demo.controller;

import com.example.demo.model.request.NhanVienRequest;
import com.example.demo.model.response.NhanVienResponse;
import com.example.demo.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nhan-vien")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping
    public List<NhanVienResponse> getNhanVien() {
        return nhanVienService.findAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody NhanVienRequest nhanVienRequest) {
        nhanVienService.add(nhanVienRequest);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody NhanVienRequest nhanVienRequest,
                       @PathVariable Long id) {
        nhanVienService.update(nhanVienRequest, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        nhanVienService.delete(id);
    }
}
