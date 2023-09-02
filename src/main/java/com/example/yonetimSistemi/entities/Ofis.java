package com.example.yonetimSistemi.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ofisler")
public class Ofis {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "ofis_adi")
	private String ofisAdi;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "lokasyon_id", referencedColumnName = "id")
	private Lokasyon lokasyon;
	
	
	public Ofis() {
		super();
	}

	public Ofis(Long id, String ofisAdi, Lokasyon lokasyon) {
		super();
		this.id = id;
		this.ofisAdi = ofisAdi;
		this.lokasyon = lokasyon;
	}

	public Long getId() {
		return id;
	}

	public String getOfisAdi() {
		return ofisAdi;
	}

	public void setOfisAdi(String ofisAdi) {
		this.ofisAdi = ofisAdi;
	}

	public Lokasyon getLokasyon() {
		return lokasyon;
	}

	public void setLokasyon(Lokasyon lokasyon) {
		this.lokasyon = lokasyon;
	}
	
	
		
}
