package com.crawl.crawler.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crawl.crawler.model.bai_bao;
import com.crawl.crawler.repository.dien_giaRepository;

@Service
public class dien_giaService {
	@Autowired
	dien_giaRepository dienGiaRepository;
	List<bai_bao> getALLBaiBao(){
		return dienGiaRepository.getAllBaiBao();
	}
}
