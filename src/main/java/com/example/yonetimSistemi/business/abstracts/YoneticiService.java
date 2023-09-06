package com.example.yonetimSistemi.business.abstracts;

import com.example.yonetimSistemi.dtos.yoneticiDTOs.GetYCalisanlariDTO;

public interface YoneticiService {
	GetYCalisanlariDTO getAllCalisanByYoneticiId(int yoneticiId);
}
