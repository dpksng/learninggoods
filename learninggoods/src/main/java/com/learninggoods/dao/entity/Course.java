package com.learninggoods.dao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="courses")
public class Course implements Serializable{
	
	private static final long serialVersionUID = -7938520230736410058L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="CRS_ID")
	@NotNull
	private long id;
	
	@Column(name="CRS_TITLE")
	private String title;
	
	@Column(name="CRS_DESC")
	private String desc;
	
	@Column(name="CRS_URL")
	private String url;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
