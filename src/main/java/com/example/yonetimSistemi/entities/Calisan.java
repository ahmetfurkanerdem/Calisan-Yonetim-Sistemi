package com.example.yonetimSistemi.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

	public Calisan() {
		super();
	}

	public Calisan(Yonetici yoneticisi) {
		super();
		this.yoneticisi = yoneticisi;
	}

	public Yonetici getYoneticisi() {
		return yoneticisi;
	}

	public void setYoneticisi(Yonetici yoneticisi) {
		this.yoneticisi = yoneticisi;
	}

	
}
