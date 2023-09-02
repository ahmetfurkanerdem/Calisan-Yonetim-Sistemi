package com.example.yonetimSistemi.business.abstracts;

import java.util.List;

import com.example.yonetimSistemi.entities.Calisan;

public interface CalisanService{
	
	void addCalisan(Calisan calisan);
	List<Calisan> getAllCalisan();
	Calisan getById(Long id);
	void updateCalisan(Calisan calisan);
	List<Calisan> getAllCalisanByYoneticiId(Long id);
	List<Long> getAllAverageDepartmanMaas();
	
}
