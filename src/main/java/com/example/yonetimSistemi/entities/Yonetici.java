package com.example.yonetimSistemi.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
@Table(name = "yoneticiler")
public class Yonetici extends Personel{
	@OneToMany(mappedBy = "yoneticisi")
	private List<Calisan> yoneticisiOlduguCalisanlar;
	
	@OneToOne(mappedBy = "departmanYoneticisi")
	private Departman yonettigiDepartman;

	public Yonetici() {
		super();
	}
	
	public Yonetici(List<Calisan> yoneticisiOlduguCalisanlar, Departman yonettigiDepartman) {
		super();
		this.yoneticisiOlduguCalisanlar = yoneticisiOlduguCalisanlar;
		this.yonettigiDepartman = yonettigiDepartman;
	}

	public List<Calisan> getYoneticisiOlduguCalisanlar() {
		return yoneticisiOlduguCalisanlar;
	}

	public void setYoneticisiOlduguCalisanlar(List<Calisan> yoneticisiOlduguCalisanlar) {
		this.yoneticisiOlduguCalisanlar = yoneticisiOlduguCalisanlar;
	}

	public Departman getYonettigiDepartman() {
		return yonettigiDepartman;
	}

	public void setYonettigiDepartman(Departman yonettigiDepartman) {
		this.yonettigiDepartman = yonettigiDepartman;
	}
	
	
}
