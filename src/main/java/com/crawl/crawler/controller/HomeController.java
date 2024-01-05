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

import com.crawl.crawler.model.hoi_nghi;
import com.crawl.crawler.requestbody.hoi_nghi_Body;
import com.crawl.crawler.service.hoi_nghiService;

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	hoi_nghiService hoiNghiService;
	
	@GetMapping("/homepage")
	String homePage(Model model) {
		List<hoi_nghi> hoi_Nghis= hoiNghiService.getAllhoi_nghi();
		if(hoi_Nghis.size()==0)
			return "nothing";
		model.addAttribute("listHoiNghi",hoi_Nghis);
		return "home";
	}
	@GetMapping("/dealineahead")
	String deadlineAhead(Model model){
		List<hoi_nghi>hoi_Nghis=hoiNghiService.getAllhoi_nghi_deadlineahead();
		if(hoi_Nghis.size()==0)
			return "nothing";
		model.addAttribute("listHoiNghi",hoi_Nghis);
		return "home";
	}
	@GetMapping("/runningconference")
	String runningConference(Model model){
		List<hoi_nghi>hoi_Nghis=hoiNghiService.getAllhoi_nghi_running();
		if(hoi_Nghis.size()==0)
			return "nothing";
		model.addAttribute("listHoiNghi",hoi_Nghis);
		return "home";
	}
	
	@GetMapping("/about")
	String about(Model model){
		return "about";
	}

	
	
}
