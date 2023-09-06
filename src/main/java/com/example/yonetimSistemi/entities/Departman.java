package com.example.yonetimSistemi.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
@Table(name = "departmanlar")
public class Departman {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "departman_adi")
	private String departmanAdi;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "lokasyon_id", referencedColumnName = "id")
	private Lokasyon lokasyon;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "yonetici_id", referencedColumnName = "id")
	private Yonetici departmanYoneticisi;
	
	@OneToMany(mappedBy = "departmani")
	private List<Calisan> calisanlar;

	public Departman() {
		super();
	}

	public Departman(int id, String departmanAdi, Lokasyon lokasyonu, Yonetici departmanYoneticisi,
			List<Calisan> calisanlar) {
		super();
		this.id = id;
		this.departmanAdi = departmanAdi;
		this.lokasyon = lokasyonu;
		this.departmanYoneticisi = departmanYoneticisi;
		this.calisanlar = calisanlar;
	}

	public int getId() {
		return id;
	}

	public String getDepartmanAdi() {
		return departmanAdi;
	}

	public void setDepartmanAdi(String departmanAdi) {
		this.departmanAdi = departmanAdi;
	}

	public Lokasyon getLokasyon() {
		return lokasyon;
	}

	public void setLokasyon(Lokasyon lokasyonu) {
		this.lokasyon = lokasyonu;
	}

	public Yonetici getDepartmanYoneticisi() {
		return departmanYoneticisi;
	}

	public void setDepartmanYoneticisi(Yonetici departmanYoneticisi) {
		this.departmanYoneticisi = departmanYoneticisi;
	}

	public List<Calisan> getCalisanlar() {
		return calisanlar;
	}

	public void setCalisanlar(List<Calisan> calisanlar) {
		this.calisanlar = calisanlar;
	}
	
	

}
