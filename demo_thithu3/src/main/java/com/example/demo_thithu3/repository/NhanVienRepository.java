package com.example.demo_thithu3.repository;

import com.example.demo_thithu3.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Long> {
    boolean existsByMaNv(String maNv);

    boolean existsByMaNvAndIdNot(String maNv, Long id);

}
