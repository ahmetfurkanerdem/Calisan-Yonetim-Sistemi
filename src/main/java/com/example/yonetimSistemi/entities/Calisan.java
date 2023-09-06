package com.example.yonetimSistemi.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
@Table(name = "calisanlar")
public class Calisan extends Personel{
	@ManyToOne
	@JoinColumn(name = "yonetici_id")
	private Yonetici yoneticisi;
	
	@OneToMany(mappedBy = "calisan")
	private List<UnvanDegisimleri> unvanDegisimleri;

	public Calisan() {
		super();
	}

	public Calisan(Yonetici yoneticisi, List<UnvanDegisimleri> unvanDegisimleri) {
		super();
		this.yoneticisi = yoneticisi;
		this.unvanDegisimleri = unvanDegisimleri;
	}

	public Yonetici getYoneticisi() {
		return yoneticisi;
	}

	public void setYoneticisi(Yonetici yoneticisi) {
		this.yoneticisi = yoneticisi;
	}

	public List<UnvanDegisimleri> getUnvanDegisimleri() {
		return unvanDegisimleri;
	}

	public void setUnvanDegisimleri(List<UnvanDegisimleri> unvanDegisimleri) {
		this.unvanDegisimleri = unvanDegisimleri;
	}

}
