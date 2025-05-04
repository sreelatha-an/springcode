package com.sreelatha.model;

import jakarta.persistence.*;
import java.util.List;
@Entity
public class QuestionTable
{
	@Id
	@Column(name="question_id")
	private Integer id;
	private String question;
	@OneToMany(cascade=CascadeType.ALL)
	private List<AnswerTable> answerList;
	public QuestionTable()
	{
		System.out.println("Zero Param Constructor of Question");
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<AnswerTable> getAnswerList() {
		return answerList;
	}
	public void setAnswerList(List<AnswerTable> answerList) {
		this.answerList = answerList;
	}
	@Override
	public String toString() {
		final int maxLen = 10;
		return "QuestionTable [id=" + id + ", question=" + question + ", answerList="
				+ (answerList != null ? answerList.subList(0, Math.min(answerList.size(), maxLen)) : null) + "]";
	}


}
