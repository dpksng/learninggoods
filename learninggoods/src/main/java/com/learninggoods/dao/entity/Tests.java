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
@Table(name="tests")
public class Tests implements Serializable{

	private static final long serialVersionUID = 2710068267482687574L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="T_NO")
	@NotNull
	private long number;
	
	@Column(name="T_ID")
	private String id;
	
	@Column(name="T_QUES")
	private String question;
	
	@Column(name="T_ANS")
	private String answer;

	@Column(name="OPTION_1")
	private String option1;

	@Column(name="OPTION_2")
	private String option2;

	@Column(name="OPTION_3")
	private String option3;

	@Column(name="OPTION_4")
	private String option4;

	
	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}


}
