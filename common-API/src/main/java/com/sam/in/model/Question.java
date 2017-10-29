package com.sam.in.model;

import java.io.Serializable;
import java.security.Timestamp;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.springframework.data.rest.core.annotation.Description;

import java.sql.Blob;

import javax.persistence.Entity;

@Entity
public class Question extends AbstractEntity implements Serializable  {

	@Description(value="Full Question with different language")
	private Blob question;
	
	@Description(value="Oprion Type value one Answer is 1, MCQ is 2")
	private Integer optionType;
	
	@Description(value="Answers JSON which contains Answer and it's Weightage")
	private Blob answers;
	
//	@Description(value="Answers JSON which contains Answer and it's Weigtage")
//	5. courseID
	
	@Description(value="Difficulty level of question")
	private Integer difficultyLevel;
	
	@Description(value="Language 1 for Hindi 2 for English")
	private Integer langCd;
//	@Description(value="Answers JSON which contains Answer and it's Weigtage")
//	8. subjectID
//	@Description(value="Answers JSON which contains Answer and it's Weigtage")
//	9. topicID
	@Description(value="Explanation of Right Answer")
	private String expln;
	
	@Description(value="Answers JSON which contains Answer and it's Weigtage")
	private Timestamp expiryTime;
	
	@Description(value="Status of Question 0 In-active, 1 Active")
	private Integer status;
	
	@Description(value="default Score of Question")
	private Integer score;
	
	@Description(value="Usage of Question in different tests.")
	private Blob testUasge;
																
	public Question() {	}
	
	public Question(Blob question, Integer optionType,Blob answers, Integer difficultyLevel,
			Integer langCd,String expln,Timestamp expiryTime,Integer status,Integer score,Blob testUasge ){
		this.question = question;
		this.optionType = optionType;
		this.answers = answers;
		this.langCd = langCd;
		this.difficultyLevel = difficultyLevel;
		this.expln = expln;
		this.expiryTime = expiryTime;
		this.status = status;
		this.score =score;
		this.testUasge = testUasge;
	}

	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}
	
	public Blob getQuestion() {
		return question;
	}

	public void setQuestion(Blob question) {
		this.question = question;
	}

	public Integer getOptionType() {
		return optionType;
	}

	public void setOptionType(Integer optionType) {
		this.optionType = optionType;
	}

	public Blob getAnswers() {
		return answers;
	}

	public void setAnswers(Blob answers) {
		this.answers = answers;
	}

	public Integer getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(Integer difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public Integer getLangCd() {
		return langCd;
	}

	public void setLangCd(Integer langCd) {
		this.langCd = langCd;
	}

	public String getExpln() {
		return expln;
	}

	public void setExpln(String expln) {
		this.expln = expln;
	}

	public Timestamp getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(Timestamp expiryTime) {
		this.expiryTime = expiryTime;
	}
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Blob getTestUasge() {
		return testUasge;
	}

	public void setTestUasge(Blob testUasge) {
		this.testUasge = testUasge;
	}	
}
