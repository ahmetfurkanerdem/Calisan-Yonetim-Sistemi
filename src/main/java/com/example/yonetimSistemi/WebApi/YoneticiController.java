package com.example.yonetimSistemi.WebApi;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.yonetimSistemi.business.abstracts.CalisanService;
import com.example.yonetimSistemi.business.abstracts.YoneticiService;
import com.example.yonetimSistemi.dtos.yoneticiDTOs.GetYCalisanlariDTO;
import com.example.yonetimSistemi.entities.Calisan;

@RestController
@RequestMapping("/yoneticiler")
public class YoneticiController {
	private YoneticiService yoneticiService;
	private CalisanService calisanService;
	
	public YoneticiController(YoneticiService yoneticiService, CalisanService calisanService) {
		this.yoneticiService = yoneticiService;
		this.calisanService = calisanService;
	}


	@GetMapping("/getAllCalisanByYoneticiId")
	public ResponseEntity<GetYCalisanlariDTO> getAllCalisanByYoneticiId(@RequestParam int id){
		return new ResponseEntity<GetYCalisanlariDTO>(yoneticiService.getAllCalisanByYoneticiId(id), HttpStatus.OK);
	}
}
