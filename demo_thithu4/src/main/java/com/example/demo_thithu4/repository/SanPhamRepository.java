package com.example.demo_thithu4.repository;

import com.example.demo_thithu4.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Long> {
    boolean existsByMaSp(String maSp);
    boolean existsByMaSpAndIdNot(String maSp, Long id);
}
