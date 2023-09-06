package com.example.yonetimSistemi.business.concreted;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.yonetimSistemi.business.abstracts.YoneticiService;
import com.example.yonetimSistemi.dataAccess.abstracts.CalisanRepository;
import com.example.yonetimSistemi.dataAccess.abstracts.YoneticiRepository;
import com.example.yonetimSistemi.dtos.yoneticiDTOs.GetYCalisanlariDTO;
import com.example.yonetimSistemi.entities.Calisan;
import com.example.yonetimSistemi.entities.Yonetici;
@Service
public class YoneticiServiceImpl implements YoneticiService{
	private CalisanRepository calisanRepository;
	private YoneticiRepository yoneticiRepository;
	
	
	public YoneticiServiceImpl(CalisanRepository calisanRepository, YoneticiRepository yoneticiRepository) {
		super();
		this.calisanRepository = calisanRepository;
		this.yoneticiRepository = yoneticiRepository;
	}

	public GetYCalisanlariDTO getAllCalisanByYoneticiId(int id) {
		Yonetici yonetici = yoneticiRepository.findById(id).orElse(null);
		List<Calisan> altindakiCalisanlar = yonetici.getYoneticisiOlduguCalisanlar();
		Collections.sort(altindakiCalisanlar, (o1, o2) -> (o1.getUnvan().compareTo(o2.getUnvan())));
		GetYCalisanlariDTO yoneticininCalisanlari = new GetYCalisanlariDTO(yonetici.getAd(), altindakiCalisanlar);
		return yoneticininCalisanlari;
	}
}
