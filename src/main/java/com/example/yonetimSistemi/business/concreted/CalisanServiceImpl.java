package com.example.yonetimSistemi.business.concreted;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.yonetimSistemi.business.abstracts.CalisanService;
import com.example.yonetimSistemi.dataAccess.abstracts.CalisanRepository;
import com.example.yonetimSistemi.entities.Calisan;

public class CalisanServiceImpl implements CalisanService{
	
	private final CalisanRepository calisanRepository;
	
	@Autowired
	public CalisanServiceImpl(CalisanRepository calisanRepository) {
		super();
		this.calisanRepository = calisanRepository;
	}

	@Override
	public void addCalisan(Calisan calisan) {
		calisanRepository.save(calisan);
	}

	@Override
	public List<Calisan> getAllCalisan() {
		return calisanRepository.findAll();
	}

	@Override
	public Calisan getById(Long id) {
		//return calisanRepository.getById(id);
		if(calisanRepository.existsById(id)) {
		return calisanRepository.findById(id).get();
		}
		return null;
	}

	@Override
	public void updateCalisan(Calisan calisan) {
			//calisanRepository.delete(calisan);
			//calisanRepository.save(calisan);
			Calisan currentCalisan = getById(calisan.getId());
			currentCalisan.setAd(calisan.getAd());
			currentCalisan.setDepartmani(calisan.getDepartmani());
			currentCalisan.setEposta(calisan.getEposta());
			currentCalisan.setIseGirisTarihi(calisan.getIseGirisTarihi());
			currentCalisan.setMaas(calisan.getMaas());
			currentCalisan.setSoyAd(calisan.getSoyAd());
			currentCalisan.setTelefon(calisan.getTelefon());
			currentCalisan.setUnvan(calisan.getUnvan());
			currentCalisan.setYoneticisi(calisan.getYoneticisi());
			calisanRepository.save(calisan);
	}
	
	@Override
	public List<Calisan> getAllCalisanByYoneticiId(Long id) {
		return calisanRepository.findByYoneticiIdOrderByUnvan(id);
	}
	@Override
	public List<Long> getAllAverageDepartmanMaas() {
		List<Object[]> maasArray = calisanRepository.getAverageDepartmanMaas();
		List<Long> averageMaasList = new ArrayList<Long>();
		Long sum = 0L;
		for (Object[] objectArray : maasArray) {
			sum = 0L;
			for (int i = 0; i < objectArray.length; i++) {
	            sum += (Long)objectArray[i];
	        }
			averageMaasList.add(sum / Long.valueOf(objectArray.length));
		}
		return averageMaasList;
	}
}
