package com.crawl.crawler.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crawl.crawler.model.dien_gia;
import com.crawl.crawler.model.hoi_nghi;

@Repository
public interface hoi_nghiRepository extends JpaRepository<hoi_nghi, Integer> {
	@Query("SELECT h FROM hoi_nghi h")
	List<hoi_nghi> getAllhoi_nghi();
	
	@Query("SELECT h FROM hoi_nghi h WHERE h.id= ?1")
	Optional<hoi_nghi> getHoi_Nghi(int id);
	
	@Query("SELECT a.dien_Gia FROM hoi_nghi a where a.id =?1")
	List<dien_gia> getAllDienGiaByIdHoiNghi(int id);
	
	@Query("SELECT a FROM hoi_nghi a WHERE a.id= ?1 AND MONTH(a.deadline) - MONTH(CURRENT_DATE())<=1 AND MONTH(a.deadline) - MONTH(CURRENT_DATE())>=0")
	List<hoi_nghi> getAllHoiNghi_dealine(int idHoiNghi);
	@Query("SELECT a FROM hoi_nghi a WHERE a.id= ?1 AND a.deadline = CURRENT_DATE()")
	List<hoi_nghi> getAllHoiNghi_running(int idHoiNghi);
}
