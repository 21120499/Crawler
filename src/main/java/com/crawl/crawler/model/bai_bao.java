package com.crawl.crawler.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="bai_bao")
public class bai_bao {
	@Id
	String name;
	@ManyToOne(optional = false)
	@JoinColumn(name ="id_dien_da", nullable = false)
	private dien_gia dien_Gia;
}
