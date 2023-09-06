package com.example.yonetimSistemi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "lokasyonlar")
public class Lokasyon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "lokasyon_adi")
	private String lokasyonAdi;
	
	@Column(name = "adres")
	private String adres;
	
	@Column(name = "posta_kodu")
	private int postaKodu;
	
	@Column(name = "sehir")
	private String sehir;
	
	@Column(name = "ulke")
	private String ulke;
	
	@OneToOne(mappedBy = "lokasyon")
	private Departman departman;

	public Lokasyon() {
		super();
	}

	public Lokasyon(int id, String lokasyonAdi, String adres, int postaKodu, String sehir, String ulke, Departman departman) {
		super();
		this.id = id;
		this.lokasyonAdi = lokasyonAdi;
		this.adres = adres;
		this.postaKodu = postaKodu;
		this.sehir = sehir;
		this.ulke = ulke;
		this.departman = departman;
	}

	public int getId() {
		return id;
	}

	public String getLokasyonAdi() {
		return lokasyonAdi;
	}

	public void setLokasyonAdi(String lokasyonAdi) {
		this.lokasyonAdi = lokasyonAdi;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public int getPostaKodu() {
		return postaKodu;
	}

	public void setPostaKodu(int postaKodu) {
		this.postaKodu = postaKodu;
	}

	public String getSehir() {
		return sehir;
	}

	public void setSehir(String sehir) {
		this.sehir = sehir;
	}

	public String getUlke() {
		return ulke;
	}

	public void setUlke(String ulke) {
		this.ulke = ulke;
	}

	public Departman getDepartman() {
		return departman;
	}

	public void setDepartman(Departman departman) {
		this.departman = departman;
	}
	
}
