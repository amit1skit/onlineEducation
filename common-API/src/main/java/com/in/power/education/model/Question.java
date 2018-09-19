package com.in.power.education.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.springframework.data.rest.core.annotation.Description;

@Entity
public class Question extends AbstractEntity implements Serializable  {

	@Description(value="Full Question with different language")
	@Lob
	@Column(name="Question")
	private byte[] question;
	
	@Description(value="Oprion Type value one Answer is 1, MCQ is 2")
	private String optionType;
	
	@Description(value="Answers JSON which contains Answer and it's Weightage")
	@Lob
	@Column(name="Answers")
	private byte[] answers;
	
	@Description(value="Topic Information")	
	@ManyToOne()
	private Topic topic;
	
	@Description(value="Subject Information")
	@ManyToOne()
	private Subject subject;
	
	@Description(value="Difficulty level of question")
	private String difficultyLevel;
	
	@Description(value="Language 1 for Hindi 2 for English")
	private String langCd;
	
	
	@Description(value="Explanation of Right Answer")
	private String expln;
	
	@Description(value="Answers JSON which contains Answer and it's Weigtage")
	private Timestamp expiryTime;
	
	@Description(value="Status of Question 0 In-active, 1 Active")
	private Integer status;
	
	@Description(value="default Score of Question")
	private Integer score;
	
	@Description(value="Usage of Question in different tests.")
	@Lob
	@Column(name="TestUsage")
	private byte[] testUasge;
	
	@Description(value="Tag a question to different set of tests")
	private String tagId;
	
	@Description(value="Index numbe of correct Answer")
	private String correctAns;
																
	public Question() {	}
	
	public Question(byte[] question, String optionType,byte[] answers, String difficultyLevel, String tagId,Topic topic, Subject subject,
			String langCd,String expln,Timestamp expiryTime,Integer status,Integer score,byte[] testUasge, String correctAns){
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
		this.topic = topic;
		this.subject =subject;
		this.tagId = tagId;
		this.correctAns = correctAns;
	}

	
	
	public byte[] getQuestion() {
		return question;
	}

	public void setQuestion(byte[] question) {
		this.question = question;
	}

	public String getOptionType() {
		return optionType;
	}

	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}

	public byte[] getAnswers() {
		return answers;
	}

	public void setAnswers(byte[] answers) {
		this.answers = answers;
	}

	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public String getLangCd() {
		return langCd;
	}

	public void setLangCd(String langCd) {
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

	public byte[] getTestUasge() {
		return testUasge;
	}

	public void setTestUasge(byte[] testUasge) {
		this.testUasge = testUasge;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public String getTagId() {
		return tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
	}

	/**
	 * @return the subject
	 */
	public Subject getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	/**
	 * @return the correctAns
	 */
	public String getCorrectAns() {
		return correctAns;
	}

	/**
	 * @param correctAns the correctAns to set
	 */
	public void setCorrectAns(String correctAns) {
		this.correctAns = correctAns;
	}	
	
}
