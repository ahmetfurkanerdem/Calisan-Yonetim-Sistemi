package com.example.yonetimSistemi.dtos.departmanDTOs;

public class DepartmanOrtalamaMaasDTO {
	private String departmanAdi;
	private float ortalamaMaas;
	public DepartmanOrtalamaMaasDTO() {
		super();
	}
	public DepartmanOrtalamaMaasDTO(String departmanAdi, float ortalamaMaas) {
		super();
		this.departmanAdi = departmanAdi;
		this.ortalamaMaas = ortalamaMaas;
	}
	public String getDepartmanAdi() {
		return departmanAdi;
	}
	public void setDepartmanAdi(String departmanAdi) {
		this.departmanAdi = departmanAdi;
	}
	public float getOrtalamaMaas() {
		return ortalamaMaas;
	}
	public void setOrtalamaMaas(float ortalamaMaas) {
		this.ortalamaMaas = ortalamaMaas;
	}
	
	
}
