package com.example.demo.repository;

import com.example.demo.entity.DichVuSuDung;
import com.example.demo.model.response.DichVuSuDungResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DichVuSuDungRepository extends JpaRepository<DichVuSuDung, Integer> {

    @Query("""
        SELECT new com.example.demo.model.response.DichVuSuDungResponse(
            dvsd.id,
            dvsd.ma,
            dv.ma,
            dvsd.soLuong,
            dvsd.ngayTao,
            dvsd.trangThai
        )
        FROM DichVuSuDung dvsd
        JOIN DichVu dv ON dv.id = dvsd.dichVuId
    """)
    List<DichVuSuDungResponse> getAllDichVuSuDung();
}

