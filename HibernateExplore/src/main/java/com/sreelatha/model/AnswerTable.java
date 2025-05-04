package com.sreelatha.model;

import jakarta.persistence.*;

@Entity
public class AnswerTable {
	@Id
	@Column(name = "answer_id")
	private Integer id;
	private String answer;
	@ManyToOne(cascade = CascadeType.ALL)
	private QuestionTable questionTable;
	
	public void AnswerTable() {
		System.out.println("AnswerTable() constructor....");
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
	public QuestionTable getQuestionTable() {
		return questionTable;
	}
	public void setQuestionTable(QuestionTable questionTable) {
		this.questionTable = questionTable;
	}
	@Override
	public String toString() {
		return "AnswerTable [id=" + id + ", answer=" + answer + ", questionTable=" + questionTable + "]";
	}
	
}