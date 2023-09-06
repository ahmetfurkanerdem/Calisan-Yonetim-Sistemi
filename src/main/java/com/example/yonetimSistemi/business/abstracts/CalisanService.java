package com.example.yonetimSistemi.business.abstracts;

import java.util.List;

import com.example.yonetimSistemi.dtos.calisanDTOs.CreateCalisanDTO;
import com.example.yonetimSistemi.dtos.calisanDTOs.GetCalisanDTO;
import com.example.yonetimSistemi.dtos.calisanDTOs.UpdateCalisanDTO;
import com.example.yonetimSistemi.entities.Calisan;

public interface CalisanService{
	
	void addCalisan(CreateCalisanDTO calisan);
	List<GetCalisanDTO> getAllCalisan();
	Calisan getById(int id);
	void updateCalisan(UpdateCalisanDTO calisan);
}
