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
@Table(name="notifications")
public class Notifications implements Serializable{

	private static final long serialVersionUID = 633960919734424911L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="NT_ID")
	@NotNull
	private long id;
	
	@Column(name="NT_TITLE")
	private String title;
	
	@Column(name="NT_DESC")
	private String desc;
	
	@Column(name="NT_URL")
	private String url;
	
	@Column(name="NT_DTE")
	private String date;
	
	@Column(name="NT_TME")
	private String time;

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
