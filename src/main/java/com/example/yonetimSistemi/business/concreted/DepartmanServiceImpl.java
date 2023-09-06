package com.example.yonetimSistemi.business.concreted;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.yonetimSistemi.business.abstracts.DepartmanService;
import com.example.yonetimSistemi.dataAccess.abstracts.CalisanRepository;
import com.example.yonetimSistemi.dataAccess.abstracts.DepartmanRepository;
import com.example.yonetimSistemi.dtos.departmanDTOs.DepartmanOrtalamaMaasDTO;
import com.example.yonetimSistemi.entities.Calisan;
import com.example.yonetimSistemi.entities.Departman;
import com.example.yonetimSistemi.entities.Lokasyon;
import com.example.yonetimSistemi.entities.Yonetici;
@Service
public class DepartmanServiceImpl implements DepartmanService {
	private DepartmanRepository departmanRepository;
	private CalisanRepository calisanRepository;
	
	@Autowired
	public DepartmanServiceImpl(DepartmanRepository departmanRepository, CalisanRepository calisanRepository) {
		this.departmanRepository = departmanRepository;
		this.calisanRepository = calisanRepository;
	}


	@Override
	public Departman findByName(String departmanAdi) {
	
	return departmanRepository.findByDepartmanAdi(departmanAdi);
	}
	
	@Override
	public List<DepartmanOrtalamaMaasDTO> getDepartmanOrtalamaMaas() {
		List<Departman> departmanlar = departmanRepository.findAll();
		float sum;
		List<DepartmanOrtalamaMaasDTO> dtoList = new ArrayList<DepartmanOrtalamaMaasDTO>();
		for (Departman departman : departmanlar) {
			sum = 0;
			for (Calisan calisan : departman.getCalisanlar()) {
				sum += calisan.getMaas();
			}
			dtoList.add(new DepartmanOrtalamaMaasDTO(departman.getDepartmanAdi(), sum / departman.getCalisanlar().size()));
		}
		return dtoList;
	}
	
	@Override
	public void saveDepartmanWithYonetici(Departman departman) {
		Yonetici yonetici = departman.getDepartmanYoneticisi();
		yonetici.setYonettigiDepartman(departman);
		yonetici.setDepartmani(departman);
		Lokasyon lokasyon = departman.getLokasyon();
		lokasyon.setDepartman(departman);
		
		departmanRepository.save(departman);		
	}
}
