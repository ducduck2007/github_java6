package com.example.demo_thithu2.controller;

import com.example.demo_thithu2.model.request.SanPhamRequest;
import com.example.demo_thithu2.model.response.SanPhamResponse;
import com.example.demo_thithu2.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/san-pham")
public class SanPhamController {

    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping
    public List<SanPhamResponse> findAll() {
        return sanPhamService.findAll();
    }

    @PostMapping
    public SanPhamResponse add(@RequestBody SanPhamRequest sanPhamRequest) {
        return sanPhamService.add(sanPhamRequest);
    }

    @PutMapping("/{id}")
    public SanPhamResponse update(@PathVariable Long id, @RequestBody SanPhamRequest sanPhamRequest) {
        return sanPhamService.update(id, sanPhamRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        sanPhamService.delete(id);
    }
}
