package com.crawl.crawler.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="hoinghi")
public class hoi_nghi {
	@Id
	@Column(name="idHoiNghi")
	String idHoiNghi;
	@Column(name="ShortName")
	private String ShortName;
	@Column(name="StartDate")
	private Date StartDate;
	@Column(name="EndDate")
	private Date EndDate;
	@Column(name="Position")
	private String Position;
	@Column(name="WebsiteURL")
	@Lob
	private String WebsiteURL;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="HoiNghi_has_BaiBao", joinColumns = {@JoinColumn(name="HoiNghi_idHoiNghi")},
	inverseJoinColumns = {@JoinColumn(name="BaiBao_idBaiBao")})
	@JsonBackReference
	List<bai_bao> listBai_Bao = new ArrayList<bai_bao>();
	

	public String getIdHoiNghi() {
		return idHoiNghi;
	}
	public void setIdHoiNghi(String idHoiNghi) {
		this.idHoiNghi = idHoiNghi;
	}
	public String getShortName() {
		return ShortName;
	}
	public void setShortName(String shortName) {
		ShortName = shortName;
	}
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	public Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
	public String getPosition() {
		return Position;
	}
	public void setPosition(String position) {
		Position = position;
	}
	public String getWebsiteURL() {
		return WebsiteURL;
	}
	public void setWebsiteURL(String websiteURL) {
		WebsiteURL = websiteURL;
	}
	public List<bai_bao> getListBai_Bao() {
		return listBai_Bao;
	}
	public void setListBai_Bao(List<bai_bao> listBai_Bao) {
		this.listBai_Bao = listBai_Bao;
	}


	
}
