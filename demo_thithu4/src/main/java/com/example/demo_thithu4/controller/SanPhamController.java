package com.example.demo_thithu4.controller;

import com.example.demo_thithu4.model.request.SanPhamRequest;
import com.example.demo_thithu4.model.response.SanPhamResponse;
import com.example.demo_thithu4.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SanPhamController {

    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping
    public List<SanPhamResponse> getAll() {
        return sanPhamService.getAll();
    }

    @PostMapping
    public void add(@RequestBody SanPhamRequest request) {
        sanPhamService.add(request);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody SanPhamRequest request) {
        sanPhamService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        sanPhamService.delete(id);
    }
}
