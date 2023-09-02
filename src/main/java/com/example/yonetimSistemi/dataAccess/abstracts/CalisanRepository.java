package com.example.yonetimSistemi.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.yonetimSistemi.entities.Calisan;

public interface CalisanRepository extends JpaRepository<Calisan, Long>{
	Calisan findByAd(String name);
	List<Calisan> findByYoneticiIdOrderByUnvan(Long yoneticiId);
	
	@Query(value = "select maas from calisanlar group by departman_id order by departman_id desc",
			nativeQuery = true)
	List<Object[]> getAverageDepartmanMaas();
}
