package com.example.yonetimSistemi.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "unvan_degisimleri")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class UnvanDegisimleri {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	@Column(name = "baslangic_tarihi")
	private Date baslangicTarihi;
	
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	@Column(name = "bitis_tarihi")
	private Date bitisTarihi;
	
	@Column(name = "unvan")
	private String unvan;
	
	@Column(name = "departman_id")
	private int departmanId;
	
	@ManyToOne
	@JoinColumn(name = "calisan_id")
	private Calisan calisan;

	public UnvanDegisimleri() {
		super();
	}

	public UnvanDegisimleri(int id, Date baslangicTarihi, Date bitisTarihi, String unvan, int departmanId,
			Calisan calisan) {
		super();
		this.id = id;
		this.baslangicTarihi = baslangicTarihi;
		this.bitisTarihi = bitisTarihi;
		this.unvan = unvan;
		this.departmanId = departmanId;
		this.calisan = calisan;
	}

	public int getId() {
		return id;
	}


	public Date getBaslangicTarihi() {
		return baslangicTarihi;
	}

	public void setBaslangicTarihi(Date baslangicTarihi) {
		this.baslangicTarihi = baslangicTarihi;
	}

	public Date getBitisTarihi() {
		return bitisTarihi;
	}

	public void setBitisTarihi(Date bitisTarihi) {
		this.bitisTarihi = bitisTarihi;
	}

	public String getUnvan() {
		return unvan;
	}

	public void setUnvan(String unvan) {
		this.unvan = unvan;
	}

	public int getDepartman() {
		return departmanId;
	}

	public void setDepartman(int departmanId) {
		this.departmanId = departmanId;
	}

	public Calisan getCalisan() {
		return calisan;
	}

	public void setCalisan(Calisan calisan) {
		this.calisan = calisan;
	}
	
	
}
