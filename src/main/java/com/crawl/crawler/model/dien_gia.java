package com.crawl.crawler.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;


@Entity
@Table(name="dien_gia")
public class dien_gia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToMany(mappedBy = "dien_Gia", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<bai_bao> bai_Bao = new ArrayList<bai_bao>();
	@ManyToMany(mappedBy = "dien_Gia", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("dien_gia")
	private List<hoi_nghi>hoi_Nghi = new ArrayList<>();
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
	public List<bai_bao> getBai_Bao() {
		return bai_Bao;
	}
	public void setBai_Bao(List<bai_bao> bai_Bao) {
		this.bai_Bao = bai_Bao;
	}
	public List<hoi_nghi> getHoi_Nghi() {
		return hoi_Nghi;
	}
	public void setHoi_Nghi(List<hoi_nghi> hoi_Nghi) {
		this.hoi_Nghi = hoi_Nghi;
	}
	
}
