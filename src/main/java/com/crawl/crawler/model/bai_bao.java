package com.crawl.crawler.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="baibao")
public class bai_bao {
	@Id
	@Column(name="idBaiBao")
	private String idBaiBao;
	@Column(name="TenBaiBao")
	private String TenBaiBao;
	@ManyToMany(mappedBy = "listBai_Bao", cascade = CascadeType.REMOVE)
	@JsonBackReference
	List<hoi_nghi> listHoiNghi = new ArrayList<hoi_nghi>();
	
	public String getIdBaiBao() {
		return idBaiBao;
	}
	public void setIdBaiBao(String idBaiBao) {
		this.idBaiBao = idBaiBao;
	}
	public String getTenBaiBao() {
		return TenBaiBao;
	}
	public void setTenBaiBao(String tenBaiBao) {
		TenBaiBao = tenBaiBao;
	}
	
}
