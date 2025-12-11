package com.example.demo_thithu1.repository;

import com.example.demo_thithu1.entity.DonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonHangRepository extends JpaRepository<DonHang, Long> {

    boolean existsByMaDonHang(String maDonHang);

    boolean existsByMaDonHangAndIdNot(String maDonHang, Long id);
}
