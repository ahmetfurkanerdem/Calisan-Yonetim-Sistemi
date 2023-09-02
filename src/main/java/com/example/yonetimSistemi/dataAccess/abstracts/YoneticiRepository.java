package com.example.yonetimSistemi.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.yonetimSistemi.entities.Yonetici;

public interface YoneticiRepository extends JpaRepository<Yonetici, Long>{
	
}
