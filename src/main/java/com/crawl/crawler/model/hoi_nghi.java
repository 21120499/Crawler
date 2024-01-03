package com.crawl.crawler.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="hoi_nghi")
public class hoi_nghi {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	private String name;
	private Date deadline;
	private Date date_start;
	private String address;
	private String chude;
	@Lob
	private String link_hoi_nghi;
	@ManyToMany
	@JoinTable(name="dien_gia_x_hoi_nghi",
	joinColumns = {@JoinColumn(name="id_hoi_nghi")},
	inverseJoinColumns = {@JoinColumn(name="id_dien_gia")})
	@JsonIgnoreProperties("hoi_nghi")
	List<dien_gia> dien_Gia =new ArrayList<dien_gia>();
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
	public List<dien_gia> getDien_Gia() {
		return dien_Gia;
	}
	public void setDien_Gia(List<dien_gia> dien_Gia) {
		this.dien_Gia = dien_Gia;
	}
	
}
