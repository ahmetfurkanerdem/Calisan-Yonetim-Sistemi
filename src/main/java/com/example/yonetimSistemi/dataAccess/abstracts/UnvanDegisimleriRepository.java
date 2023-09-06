package com.example.yonetimSistemi.dataAccess.abstracts;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.yonetimSistemi.entities.UnvanDegisimleri;

public interface UnvanDegisimleriRepository extends JpaRepository<UnvanDegisimleri, Integer>{
	Optional<UnvanDegisimleri> findFirstByCalisanIdOrderByIdDesc(int CalisanId);
}
