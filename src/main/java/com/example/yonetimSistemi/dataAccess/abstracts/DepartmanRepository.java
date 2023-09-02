package com.example.yonetimSistemi.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.yonetimSistemi.entities.Departman;

public interface DepartmanRepository extends JpaRepository<Departman, Long>{
	
	Departman findByDepartmanAdi(String departmanAdi);

}
