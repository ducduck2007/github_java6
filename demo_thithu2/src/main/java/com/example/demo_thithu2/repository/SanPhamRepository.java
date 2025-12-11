package com.example.demo_thithu2.repository;

import com.example.demo_thithu2.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Long> {
    boolean existsByMaSP(String maSP);
    boolean existsByMaSPAndIdNot(String maSP, Long id);
}
