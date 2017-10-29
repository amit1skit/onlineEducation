package com.in.power.education.model;

import java.io.Serializable;
import java.io.Serializable;
import java.security.Timestamp;
import java.sql.Blob;
import javax.persistence.Entity;
import org.springframework.data.rest.core.annotation.Description;

@Entity
public class StudentReport extends AbstractEntity implements Serializable  {

//	1. StudentReportID
//	2. courseSubscriptionID
//	3. TestID
	@Description(value="Scored the marks durig the exam")
	private Float score;

	@Description(value="Answers to given questions")
	private Blob QAnss;
	
	@Description(value="Test Status is in-Active 0, Active 1, In-progress 2")
	private Integer testStat;

	@Description(value="Current Attempt Count")
	private Integer currAtmpt;

	@Description(value="Current question which user is answering")
	private Integer qAttempted;

	@Description(value="Grade Acquied by User")
	private String grade;

	public StudentReport() {
	}
	
	public StudentReport(Float score,Blob QAnss,Integer testStat,Integer currAtmpt,Integer qAttempted,String grade) {
		this.score =score;
		this.QAnss = QAnss;
		this.testStat = testStat;
		this.currAtmpt = currAtmpt;
		this.qAttempted = qAttempted;
		this.grade = grade;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public Blob getQAnss() {
		return QAnss;
	}

	public void setQAnss(Blob qAnss) {
		QAnss = qAnss;
	}

	public Integer getTestStat() {
		return testStat;
	}

	public void setTestStat(Integer testStat) {
		this.testStat = testStat;
	}

	public Integer getCurrAtmpt() {
		return currAtmpt;
	}

	public void setCurrAtmpt(Integer currAtmpt) {
		this.currAtmpt = currAtmpt;
	}

	public Integer getqAttempted() {
		return qAttempted;
	}

	public void setqAttempted(Integer qAttempted) {
		this.qAttempted = qAttempted;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
}
