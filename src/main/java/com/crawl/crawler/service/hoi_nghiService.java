package com.crawl.crawler.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crawl.crawler.model.hoi_nghi;
import com.crawl.crawler.repository.hoi_nghiRepository;

@Service
public class hoi_nghiService {
	@Autowired
	private hoi_nghiRepository hoiNghiRepository;
	
	public List<hoi_nghi> getAllhoi_nghi(){
		List<hoi_nghi> x = hoiNghiRepository.getAllhoi_nghi();
		System.out.println("ALL HOI NGHI");
		for(int i=0;i<x.size();i++) {
			System.out.println("link: "+x.get(i).getWebsiteURL());
		}
		
		return hoiNghiRepository.getAllhoi_nghi();
	}
	public List<hoi_nghi> getAllhoi_nghi_deadlineahead(){
		List<hoi_nghi> x = hoiNghiRepository.getAllhoi_nghi_Deadlineahead();
		System.out.println("DEALINE AHEAD "+x.size());
		for(int i=0;i<x.size();i++) {
			System.out.println("link: "+x.get(i).getWebsiteURL());
		}
		
		return hoiNghiRepository.getAllhoi_nghi_Deadlineahead();
	}
	public List<hoi_nghi> getAllhoi_nghi_running(){
		List<hoi_nghi> x = hoiNghiRepository.getAllhoi_nghi_Running();
		System.out.println("running "+x.size());
		for(int i=0;i<x.size();i++) {
			System.out.println("link: "+x.get(i).getWebsiteURL());
		}
		
		return hoiNghiRepository.getAllhoi_nghi_Running();
	}
	public Optional<hoi_nghi> get_hoi_nghi_deadline(String id) {
		return hoiNghiRepository.gethoi_nghi_Deadlineahead(id);
	}
	
	public Optional<hoi_nghi> Get_hoi_nghi(String id) {
		return hoiNghiRepository.getHoi_Nghi(id);
	}

//	public List<hoi_nghi> getAllhoi_nghi_Deadlineahead(){
//		return hoiNghiRepository.getAllhoi_nghi_Deadlineahead();
//	}
}
