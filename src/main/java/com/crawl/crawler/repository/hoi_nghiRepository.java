package com.crawl.crawler.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crawl.crawler.model.hoi_nghi;

@Repository
public interface hoi_nghiRepository extends JpaRepository<hoi_nghi, String> {
	@Query("SELECT h FROM hoi_nghi h")
	List<hoi_nghi> getAllhoi_nghi();
	

	
	@Query("SELECT a FROM hoi_nghi a WHERE DATEDIFF(a.StartDate, CURRENT_DATE()) >= 0 AND DATEDIFF(a.StartDate, CURRENT_DATE()) <= 7")
	List<hoi_nghi> getAllhoi_nghi_Deadlineahead();

	@Query("SELECT a FROM hoi_nghi a WHERE a.StartDate=CURRENT_DATE()")
	List<hoi_nghi> getAllhoi_nghi_Running();

	
	@Query("SELECT h FROM hoi_nghi h WHERE h.idHoiNghi= ?1")
	Optional<hoi_nghi> getHoi_Nghi(String id);
	
	@Query("SELECT a FROM hoi_nghi a WHERE a.idHoiNghi=?1 AND DATEDIFF(a.StartDate, CURRENT_DATE()) >= 0 AND DATEDIFF(a.StartDate, CURRENT_DATE()) <= 30")
	Optional<hoi_nghi> gethoi_nghi_Deadlineahead(String id);
	
	
	
//	@Query("SELECT a FROM hoi_nghi a WHERE a.id= ?1 AND MONTH(a.deadline) - MONTH(CURRENT_DATE())<=1 AND MONTH(a.deadline) - MONTH(CURRENT_DATE())>=0")
//	List<hoi_nghi> getAllHoiNghi_dealine(int idHoiNghi);
//	@Query("SELECT a FROM hoi_nghi a WHERE a.id= ?1 AND a.deadline = CURRENT_DATE()")
//	List<hoi_nghi> getAllHoiNghi_running(int idHoiNghi);
}
