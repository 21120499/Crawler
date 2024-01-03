package com.crawl.crawler.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.crawl.crawler.model.bai_bao;
import com.crawl.crawler.model.dien_gia;

public interface dien_giaRepository extends JpaRepository<dien_gia, Integer> {
	@Query("SELECT d.bai_Bao FROM dien_gia d")
	public List<bai_bao> getAllBaiBao();
}
