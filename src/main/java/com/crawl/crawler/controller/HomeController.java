package com.crawl.crawler.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crawl.crawler.model.dien_gia;
import com.crawl.crawler.model.hoi_nghi;
import com.crawl.crawler.requestbody.hoi_nghi_Body;
import com.crawl.crawler.responsebody.DetailConferenceBody;
import com.crawl.crawler.service.hoi_nghiService;

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	hoi_nghiService hoiNghiService;
	
	@GetMapping("/homepage")
	String homePage(Model model) {
		List<hoi_nghi> hoi_Nghis= hoiNghiService.getAllhoi_nghi();
		model.addAttribute("listHoiNghi",hoi_Nghis);
		return "home";
	}
	@GetMapping("/dealine_ahead")
	String deadlineAhead(Model model){
		List<hoi_nghi>hoi_nghis=hoiNghiService.getAllhoi_nghi();
		List<hoi_nghi>deadlineAheads = new ArrayList<hoi_nghi>();
		for(int i=0;i<hoi_nghis.size();i++) {
			Date deadline = hoi_nghis.get(i).getDeadline();
			Date currentDate = new Date();
			LocalDate Ldeadline = deadline.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
			LocalDate LcurrenDate = currentDate.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
			System.out.println(i);
			Period period = Period.between(LcurrenDate, Ldeadline);
			int days = period.getDays();
			System.out.println("days: "+days);
			System.out.println("deadline: "+Ldeadline);
			if(days<=30&&days>0)
				deadlineAheads.add(hoi_nghis.get(i));
		}
		model.addAttribute("listHoiNghi", deadlineAheads);
		if(deadlineAheads.size()==0){
			return "nothing";
		}
		return "home";
	}
	@GetMapping("/runningconference")
	String runningConference(Model model){
		List<hoi_nghi>hoi_nghis=hoiNghiService.getAllhoi_nghi();
		List<hoi_nghi>runningConferences = new ArrayList<hoi_nghi>();
		for(int i=0;i<hoi_nghis.size();i++) {
			Date dateStart = hoi_nghis.get(i).getDate_start();
			Date currentDate = new Date();
			LocalDate LdateStart = dateStart.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
			LocalDate LcurrenDate = currentDate.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
			System.out.println(i);
			Period period = Period.between(LcurrenDate, LdateStart);
			int days = period.getDays();
			System.out.println("days: "+days);
			if(days==0)
				runningConferences.add(hoi_nghis.get(i));
		}
		model.addAttribute("listHoiNghi", runningConferences);
		if(runningConferences.size()==0){
			return "nothing";
		}
		return "hone";
	}
	@GetMapping("/detailConference/{id}")
	public String detailConference(@PathVariable int id, Model model){
		Optional<hoi_nghi> opHoiNghi = hoiNghiService.get_hoi_nghi(id);
		hoi_nghi hoi_Nghi = opHoiNghi.get();
		model.addAttribute("hoiNghi", hoi_Nghi);
		return "inner";
	}
	@GetMapping("/dealineahead/{id}")
	public String deadlineAhead(@PathVariable int id, Model model){
		Optional<hoi_nghi> opHoiNghi = hoiNghiService.get_hoi_nghi(id);
		hoi_nghi hoi_Nghi=opHoiNghi.get();
		model.addAttribute("hoiNghi", hoi_Nghi);
		return "inner";
	}
	@GetMapping("/runningconference/{id}")
	public String runningConf(@PathVariable int id, Model model){
		Optional<hoi_nghi> opHoiNghi = hoiNghiService.get_hoi_nghi(id);
		hoi_nghi hoi_Nghi=opHoiNghi.get();
		model.addAttribute("hoiNghi", hoi_Nghi);
		return "inner";
	}
	
}
