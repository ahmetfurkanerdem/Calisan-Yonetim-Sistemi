package com.example.yonetimSistemi.WebApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.yonetimSistemi.business.abstracts.DepartmanService;
import com.example.yonetimSistemi.entities.Departman;

@RestController
@RequestMapping("/departmanlar")
public class DepartmanController {
	@Autowired
	private DepartmanService departmanService;
	
	public DepartmanController(DepartmanService departmanService) {
		this.departmanService = departmanService;
	}

	@GetMapping("/findDepartmanByDepartmanAdi")
	public ResponseEntity<Departman> getDepartmanByName (@RequestParam String name) {
		return new ResponseEntity<Departman>(departmanService.findByName(name), HttpStatus.OK);
	}
}
