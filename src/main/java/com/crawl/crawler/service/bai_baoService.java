package com.crawl.crawler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crawl.crawler.model.bai_bao;
import com.crawl.crawler.repository.bai_baoRepository;

@Service
public class bai_baoService {
	@Autowired
	private bai_baoRepository bai_BaoRepository;

}
