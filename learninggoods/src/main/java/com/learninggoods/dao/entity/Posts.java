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
@Table(name="posts")
public class Posts implements Serializable{

	private static final long serialVersionUID = 3499214285233887616L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="P_NO")
	@NotNull
	private long number;
	
	@Column(name="P_ID")
	private long id;
	
	@Column(name="P_TITLE")
	private String title;
	
	@Column(name="P_DESC")
	private String desc;
	
	@Column(name="P_P_USR")
	private String puser;

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

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

	public String getPuser() {
		return puser;
	}

	public void setPuser(String puser) {
		this.puser = puser;
	}
	
}
