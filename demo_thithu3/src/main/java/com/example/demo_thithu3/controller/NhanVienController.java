package com.example.demo_thithu3.controller;

import com.example.demo_thithu3.model.request.NhanVienRequest;
import com.example.demo_thithu3.model.response.NhanVienResponse;
import com.example.demo_thithu3.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nhan-vien")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping
    public List<NhanVienResponse> findAll() {
        return nhanVienService.findAll();
    }

    @PostMapping
    public void add(@RequestBody NhanVienRequest request) {
        nhanVienService.add(request);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody NhanVienRequest request) {
        nhanVienService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        nhanVienService.delete(id);
    }
}
