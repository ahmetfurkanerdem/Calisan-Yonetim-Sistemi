package com.example.yonetimSistemi.dtos.yoneticiDTOs;

import java.util.Collections;
import java.util.List;

import com.example.yonetimSistemi.entities.Calisan;

public class GetYCalisanlariDTO {
	private String ad;
	private List<Calisan> calisanlari;
	public GetYCalisanlariDTO() {
		super();
	}
	public GetYCalisanlariDTO(String ad, List<Calisan> calisanlari) {
		super();
		this.ad = ad;
		this.calisanlari = calisanlari;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public List<Calisan> getCalisanlari() {
		return calisanlari;
	}
	public void setCalisanlari(List<Calisan> calisanlari) {
		this.calisanlari = calisanlari;
	}
	
}
