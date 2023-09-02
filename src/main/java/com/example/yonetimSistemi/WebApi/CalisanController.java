package com.example.yonetimSistemi.WebApi;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.yonetimSistemi.business.abstracts.CalisanService;
import com.example.yonetimSistemi.entities.Calisan;

@RestController
@RequestMapping("/calisanlar")
public class CalisanController {
	private CalisanService calisanService;

	public CalisanController(CalisanService calisanService) {
		this.calisanService = calisanService;
	}
	@GetMapping("/getAllCalisanlar")
	public ResponseEntity<List<Calisan>> getAllCalisanlar(){
		return new ResponseEntity<List<Calisan>>(calisanService.getAllCalisan(), HttpStatus.OK);
	}
	@PostMapping("/addCalisan")
	public void addCalisan(@RequestBody Calisan calisan) {
		calisanService.addCalisan(calisan);
	}
	@PutMapping("/updateCalisan")
	public void updateCalisan(@RequestBody Calisan calisan) {
		calisanService.updateCalisan(calisan);
		
	}
	@GetMapping("/getAllCalisanByYoneticiId")
	public ResponseEntity<List<Calisan>> getAllCalisanByYoneticiId(@RequestBody Long id){
		return new ResponseEntity<List<Calisan>>(calisanService.getAllCalisanByYoneticiId(id), HttpStatus.OK);
	}
	
	@GetMapping("/getAllAverageDepartmanMaas")
	public ResponseEntity<List<Long>> getAllAverageDepartmanMaas() {
		return new ResponseEntity<List<Long>>(calisanService.getAllAverageDepartmanMaas(), HttpStatus.OK);
	}
}
