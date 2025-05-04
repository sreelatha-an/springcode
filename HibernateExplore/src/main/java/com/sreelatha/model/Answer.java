package com.sreelatha.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="Answer")
public class Answer {

	@Id
	@Column(name="answer_id")
	private Integer id;
	private String answer;
	@OneToOne(cascade=CascadeType.ALL)
	private Question question;
	

	
	@Override
	public String toString() {
		return "Answer [id=" + id + ", answer=" + answer + ", question=" + question + "]";
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getAnswer() {
		return answer;
	}



	public void setAnswer(String answer) {
		this.answer = answer;
	}



	public Question getQuestion() {
		return question;
	}



	public void setQuestion(Question question) {
		this.question = question;
	}



	public Answer() {
		System.out.println("Answer() constructor....");
	}
	
	
}
