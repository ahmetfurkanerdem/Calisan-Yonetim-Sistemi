package com.example.yonetimSistemi.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.yonetimSistemi.entities.Calisan;

public interface CalisanRepository extends JpaRepository<Calisan, Integer>{
	Calisan findByAd(String name);
}
