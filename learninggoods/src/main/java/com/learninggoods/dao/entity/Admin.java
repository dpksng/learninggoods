package com.learninggoods.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="admin_details")
public class Admin{
	
	@Id
	@Column(name="ADMN_ID")
	@NotNull
	private String id;
	
	@Column(name="ADMN_NME")
	@NotNull
	private String name;
	
	@Column(name="ADMN_GEN")
	@NotNull
	private String gender;
	
	@Column(name="ADMN_PWD")
	@NotNull
	private String pwd;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
