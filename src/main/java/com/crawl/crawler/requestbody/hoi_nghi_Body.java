package com.crawl.crawler.requestbody;

import java.util.Date;

import jakarta.persistence.Lob;

public class hoi_nghi_Body {
	private int id;
	private String name;
	private Date deadline;
	private Date date_start;
	private String address;
	private String chude;
	@Lob
	private String link_hoi_nghi;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public Date getDate_start() {
		return date_start;
	}
	public void setDate_start(Date date_start) {
		this.date_start = date_start;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getChude() {
		return chude;
	}
	public void setChude(String chude) {
		this.chude = chude;
	}
	public String getLink_hoi_nghi() {
		return link_hoi_nghi;
	}
	public void setLink_hoi_nghi(String link_hoi_nghi) {
		this.link_hoi_nghi = link_hoi_nghi;
	}
	
}
