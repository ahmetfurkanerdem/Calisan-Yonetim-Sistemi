package com.example.yonetimSistemi.business.concreted;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.yonetimSistemi.business.abstracts.DepartmanService;
import com.example.yonetimSistemi.dataAccess.abstracts.DepartmanRepository;
import com.example.yonetimSistemi.entities.Departman;

public class DepartmanServiceImpl implements DepartmanService {
	private final DepartmanRepository departmanRepository;
	
	@Autowired
	public DepartmanServiceImpl(DepartmanRepository departmanRepository) {
		this.departmanRepository = departmanRepository;
	}


	@Override
	public Departman findByName(String departmanAdi) {
	
	return departmanRepository.findByDepartmanAdi(departmanAdi);
	}
}
