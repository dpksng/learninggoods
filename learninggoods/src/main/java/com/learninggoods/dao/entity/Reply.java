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
@Table(name="reply")
public class Reply implements Serializable{

	private static final long serialVersionUID = 3499214285233887616L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="R_ID")
	@NotNull
	private long number;
	
	@Column(name="P_ID")
	@NotNull
	private long id;
	
	@Column(name="P_REPLY")
	private String reply;
	
	@Column(name="P_P_USR")
	private String puser;
	
	@Column(name="P_R_USR")
	private String ruser;

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

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getPuser() {
		return puser;
	}

	public void setPuser(String puser) {
		this.puser = puser;
	}

	public String getRuser() {
		return ruser;
	}

	public void setRuser(String ruser) {
		this.ruser = ruser;
	}
	
}
