package com.example.demo.service;

import com.example.demo.entity.DichVuSuDung;
import com.example.demo.model.request.DichVuSuDungRequest;
import com.example.demo.model.response.DichVuSuDungResponse;
import com.example.demo.repository.DichVuSuDungRepository;
import com.example.demo.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DichVuSuDungService {

    @Autowired
    private DichVuSuDungRepository dichVuSuDungRepository;

    public List<DichVuSuDungResponse> getAll() {
        return dichVuSuDungRepository.getAllDichVuSuDung();
    }

    public void add(DichVuSuDungRequest dichVuSuDungRequest) {
        DichVuSuDung entity = MapperUtil.map(dichVuSuDungRequest, DichVuSuDung.class);
        entity.setNgayTao(LocalDate.now());
        dichVuSuDungRepository.save(entity);
    }
}
