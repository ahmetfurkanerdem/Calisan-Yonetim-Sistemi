package com.example.yonetimSistemi.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.yonetimSistemi.entities.Calisan;
import com.example.yonetimSistemi.entities.Yonetici;

public interface YoneticiRepository extends JpaRepository<Yonetici, Integer>{
	//List<Calisan> findYoneticisiOlduguCalisanlarByIdOrderByUnvan(int id);
}
