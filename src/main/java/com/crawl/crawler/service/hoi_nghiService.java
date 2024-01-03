package com.crawl.crawler.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crawl.crawler.model.dien_gia;
import com.crawl.crawler.model.hoi_nghi;
import com.crawl.crawler.repository.hoi_nghiRepository;

@Service
public class hoi_nghiService {
	@Autowired
	private hoi_nghiRepository hoiNghiRepository;
	public List<hoi_nghi> getAllhoi_nghi(){
		return hoiNghiRepository.getAllhoi_nghi();
	}
	public Optional<hoi_nghi> get_hoi_nghi(int id) {
		return hoiNghiRepository.getHoi_Nghi(id);
	}
	public List<dien_gia> getAllDienGiaByHoiNghi(int id){
		List<dien_gia> x = hoiNghiRepository.getAllDienGiaByIdHoiNghi(id);
		for(int i=0;i<x.size();i++) {
			System.out.println(x.get(i).getId());
			System.out.println(x.get(i).getName());

		}
		return hoiNghiRepository.getAllDienGiaByIdHoiNghi(id);
	}
	
	public List<hoi_nghi> getAllhoiNghi_deadline(int id){
		return hoiNghiRepository.getAllHoiNghi_dealine(id);
	}
	
	public List<hoi_nghi> getAllhoiNghi_runningConf(int id){
		return hoiNghiRepository.getAllHoiNghi_running(id);
	}
}
