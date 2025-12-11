package com.example.demo_thithu1.controller;

import com.example.demo_thithu1.model.request.DonHangRequest;
import com.example.demo_thithu1.model.response.DonHangResponse;
import com.example.demo_thithu1.service.DonHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/don-hang")
public class DonHangController {

    @Autowired
    private DonHangService donHangService;


    @GetMapping
    public List<DonHangResponse> findAll() {
        return donHangService.findAll();
    }


    @PostMapping
    public DonHangResponse add(@RequestBody DonHangRequest request) {
        return donHangService.add(request);
    }


    @PutMapping("/{id}")
    public DonHangResponse update(@PathVariable Long id, @RequestBody DonHangRequest request) {
        return donHangService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        donHangService.delete(id);
    }
}
