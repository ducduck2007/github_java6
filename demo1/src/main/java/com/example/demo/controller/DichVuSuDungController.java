package com.example.demo.controller;

import com.example.demo.model.request.DichVuSuDungRequest;
import com.example.demo.model.response.DichVuSuDungResponse;
import com.example.demo.service.DichVuSuDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dich-vu-su-dung")
public class DichVuSuDungController {

    @Autowired
    private DichVuSuDungService service;

    @GetMapping
    public ResponseEntity<List<DichVuSuDungResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody DichVuSuDungRequest request) {
        service.add(request);
        return ResponseEntity.ok("Thêm dịch vụ sử dụng thành công");
    }
}
