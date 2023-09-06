package com.example.yonetimSistemi.business.abstracts;

import java.util.List;

import com.example.yonetimSistemi.dtos.departmanDTOs.DepartmanOrtalamaMaasDTO;
import com.example.yonetimSistemi.entities.Departman;

public interface DepartmanService {
	
	Departman findByName(String departmanAdi); //49.13 olmazsa findbyDepartmanAdi dene
	List<DepartmanOrtalamaMaasDTO> getDepartmanOrtalamaMaas();
	void saveDepartmanWithYonetici(Departman departman);
	
}
