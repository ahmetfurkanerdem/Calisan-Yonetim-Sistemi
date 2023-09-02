package com.example.yonetimSistemi.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;


@MappedSuperclass
public class Personel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "ad")
	private String ad;
	
	@Column(name = "soyad")
	private String soyAd;
	
	@Column(name = "eposta")
	private String eposta;
	
	@Column(name = "telefon")
	private int telefon;
	
	@Column(name = "ise_giris_tarihi")
	private Date iseGirisTarihi;
	
	@Column(name = "maas")
	private long maas;
	
	@Column(name = "unvan")
	private String unvan;
	
	@ManyToOne
	@JoinColumn(name = "departman_id")
	private Departman departmani;
	
	
	public Personel() {
		super();
	}

	public Personel(Long id, String ad, String soyAd, String eposta, int telefon, Date iseGirisTarihi, long maas,
			String unvan, Departman departmani) {
		super();
		this.id = id;
		this.ad = ad;
		this.soyAd = soyAd;
		this.eposta = eposta;
		this.telefon = telefon;
		this.iseGirisTarihi = iseGirisTarihi;
		this.maas = maas;
		this.unvan = unvan;
		this.departmani = departmani;
	}

	
	public Long getId() {
		return id;
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

	public int getTelefon() {
		return telefon;
	}

	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}

	public Date getIseGirisTarihi() {
		return iseGirisTarihi;
	}

	public void setIseGirisTarihi(Date iseGirisTarihi) {
		this.iseGirisTarihi = iseGirisTarihi;
	}

	public long getMaas() {
		return maas;
	}

	public void setMaas(long maas) {
		this.maas = maas;
	}

	public String getUnvan() {
		return unvan;
	}

	public void setUnvan(String unvan) {
		this.unvan = unvan;
	}

	public Departman getDepartmani() {
		return departmani;
	}

	public void setDepartmani(Departman departmani) {
		this.departmani = departmani;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
