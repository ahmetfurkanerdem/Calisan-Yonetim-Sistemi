package com.example.yonetimSistemi.business.concreted;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.yonetimSistemi.business.abstracts.CalisanService;
import com.example.yonetimSistemi.dataAccess.abstracts.CalisanRepository;
import com.example.yonetimSistemi.dataAccess.abstracts.DepartmanRepository;
import com.example.yonetimSistemi.dataAccess.abstracts.UnvanDegisimleriRepository;
import com.example.yonetimSistemi.dataAccess.abstracts.YoneticiRepository;
import com.example.yonetimSistemi.dtos.calisanDTOs.CreateCalisanDTO;
import com.example.yonetimSistemi.dtos.calisanDTOs.GetCalisanDTO;
import com.example.yonetimSistemi.dtos.calisanDTOs.UpdateCalisanDTO;
import com.example.yonetimSistemi.entities.Calisan;
import com.example.yonetimSistemi.entities.UnvanDegisimleri;

@Service
public class CalisanServiceImpl implements CalisanService{
	
	private CalisanRepository calisanRepository;
	private YoneticiRepository yoneticiRepository;
	private DepartmanRepository departmanRepository;
	private UnvanDegisimleriRepository unvanDegisimlerRepository;
	
	@Autowired
	public CalisanServiceImpl(CalisanRepository calisanRepository, YoneticiRepository yoneticiRepository, DepartmanRepository departmanRepository,
			UnvanDegisimleriRepository unvanDegisimlerRepository) {
		super();
		this.calisanRepository = calisanRepository;
		this.yoneticiRepository = yoneticiRepository;
		this.departmanRepository = departmanRepository;
		this.unvanDegisimlerRepository = unvanDegisimlerRepository;
	}

	@Override
	public void addCalisan(CreateCalisanDTO calisanDTO) {
		Calisan calisan = new Calisan();
		calisan.setAd(calisanDTO.getAd());
		calisan.setEposta(calisanDTO.getEposta());
		calisan.setIseGirisTarihi(calisanDTO.getIseGirisTarihi());
		calisan.setMaas(calisanDTO.getMaas());
		calisan.setSoyAd(calisanDTO.getSoyAd());
		calisan.setTelefon(calisanDTO.getTelefon());
		calisan.setUnvan(calisanDTO.getUnvan());
		calisan.setYoneticisi(yoneticiRepository.findById(calisanDTO.getYoneticiId()).orElse(null));
		calisan.setDepartmani(calisan.getYoneticisi().getYonettigiDepartman());
		calisanRepository.save(calisan);
	}

	@Override
	public List<GetCalisanDTO> getAllCalisan() {
		List<Calisan> calisanlar = calisanRepository.findAll();
		List<GetCalisanDTO> calisanDtos = calisanlar.stream().map(calisan -> new GetCalisanDTO(calisan.getId(),
				calisan.getAd(), calisan.getSoyAd(),
				calisan.getEposta(), calisan.getTelefon(), calisan.getIseGirisTarihi(), calisan.getMaas(),
				calisan.getDepartmani().getId(), calisan.getUnvan(), calisan.getYoneticisi().getId(),
				calisan.getUnvanDegisimleri())).collect(Collectors.toList());
		return calisanDtos;
	}

	@Override
	public Calisan getById(int id) {
		//return calisanRepository.getById(id);
		if(calisanRepository.existsById(id)) {
		return calisanRepository.findById(id).orElse(null); //orElse ile ifsiz yapılabilir mi bak
		}
		return null;
	}

	@Override
	public void updateCalisan(UpdateCalisanDTO calisan) {
			Calisan currentCalisan = getById(calisan.getId());
			currentCalisan.setAd(calisan.getAd());
			currentCalisan.setDepartmani(departmanRepository.findById(calisan.getDepartmanId()).orElse(null));
			currentCalisan.setEposta(calisan.getEposta());
			currentCalisan.setIseGirisTarihi(calisan.getIseGirisTarihi());
			currentCalisan.setMaas(calisan.getMaas());
			currentCalisan.setSoyAd(calisan.getSoyAd());
			currentCalisan.setTelefon(calisan.getTelefon());
			currentCalisan.setYoneticisi(yoneticiRepository.findById(calisan.getYoneticiId()).orElse(null));
			
			if(!currentCalisan.getUnvan().equals(calisan.getUnvan())) {
				UnvanDegisimleri sonUnvanDegisimi = unvanDegisimlerRepository.findFirstByCalisanIdOrderByIdDesc(currentCalisan.getId()).orElse(null);
				Date eskiUnvanBaslamaTarihi;
				if(sonUnvanDegisimi == null) {
					eskiUnvanBaslamaTarihi = currentCalisan.getIseGirisTarihi();
				}
				else {
					eskiUnvanBaslamaTarihi = sonUnvanDegisimi.getBitisTarihi();
				}
				Date today = Calendar.getInstance().getTime();
				UnvanDegisimleri yeniUnvanDegisimi = new UnvanDegisimleri();
				yeniUnvanDegisimi.setBaslangicTarihi(eskiUnvanBaslamaTarihi);
				yeniUnvanDegisimi.setBitisTarihi(today);
				yeniUnvanDegisimi.setCalisan(calisanRepository.findById(calisan.getId()).orElse(null));
				yeniUnvanDegisimi.setDepartman(calisan.getDepartmanId());
				yeniUnvanDegisimi.setUnvan(currentCalisan.getUnvan());
				unvanDegisimlerRepository.save(yeniUnvanDegisimi);
			}
			currentCalisan.setUnvan(calisan.getUnvan());
			calisanRepository.save(currentCalisan);
	}
	
}
