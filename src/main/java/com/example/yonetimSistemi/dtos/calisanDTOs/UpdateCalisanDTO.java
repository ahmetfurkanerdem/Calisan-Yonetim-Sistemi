package com.example.yonetimSistemi.dtos.calisanDTOs;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UpdateCalisanDTO {
	private int id;
	private String ad;
	private String soyAd;
	private String eposta;
	private long telefon;
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date iseGirisTarihi;
	private float maas;
	private int departmanId;
	private String unvan;
	private int yoneticiId;
	
	public UpdateCalisanDTO() {
		super();
	}
	public UpdateCalisanDTO(int id, String ad, String soyAd, String eposta, long telefon, Date iseGirisTarihi, float maas,
			int departmanId, String unvan, int yoneticiId) {
		super();
		this.id = id;
		this.ad = ad;
		this.soyAd = soyAd;
		this.eposta = eposta;
		this.telefon = telefon;
		this.iseGirisTarihi = iseGirisTarihi;
		this.maas = maas;
		this.departmanId = departmanId;
		this.unvan = unvan;
		this.yoneticiId = yoneticiId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getSoyAd() {
		return soyAd;
	}
	public void setSoyAd(String soyAd) {
		this.soyAd = soyAd;
	}
	public String getEposta() {
		return eposta;
	}
	public void setEposta(String eposta) {
		this.eposta = eposta;
	}
	public long getTelefon() {
		return telefon;
	}
	public void setTelefon(long telefon) {
		this.telefon = telefon;
	}
	public Date getIseGirisTarihi() {
		return iseGirisTarihi;
	}
	public void setIseGirisTarihi(Date iseGirisTarihi) {
		this.iseGirisTarihi = iseGirisTarihi;
	}
	public float getMaas() {
		return maas;
	}
	public void setMaas(float maas) {
		this.maas = maas;
	}
	public int getDepartmanId() {
		return departmanId;
	}
	public void setDepartmanId(int departmanId) {
		this.departmanId = departmanId;
	}
	public String getUnvan() {
		return unvan;
	}
	public void setUnvan(String unvan) {
		this.unvan = unvan;
	}
	public int getYoneticiId() {
		return yoneticiId;
	}
	public void setYoneticiId(int yoneticiId) {
		this.yoneticiId = yoneticiId;
	}
	
	

}
