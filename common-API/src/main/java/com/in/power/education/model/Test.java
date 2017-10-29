package com.in.power.education.model;

import java.io.Serializable;
import java.security.Timestamp;
import java.sql.Blob;

import javax.persistence.Entity;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.springframework.data.rest.core.annotation.Description;

@Entity
public class Test extends AbstractEntity implements Serializable  {

//	2. courseID
//	3. subjectID Need To discuss More
////	4. topicID --Need To discuss More
	@Description(value="Number of Question in Test")
	private String qCount;
	
	@Description(value="Questions JSON")
	private Blob questionIds;
	
	@Description(value="Duration of Test")
	private Integer duration;
	
	@Description(value="created by User")
	private String createdBy;
	
	@Description(value="last Modified by")
	private Timestamp lastAccessts;
	
	@Description(value="Difficult level 1. Easy, 2. Medium, 3. difficult")
	private Integer diificultyLevel;
	
	@Description(value="Test Name")
	private String testName;
	
	@Description(value="Test Description")
	private String testDesc;
	
	@Description(value="Base price of Test")
	private String basePriceTest;
	
	@Description(value="status of Test")
	private Integer status;
	
	@Description(value="Percentage of Negative marks")
	private Integer percentNegative;

	public Test() {
	}
	
	public Test(String qCount,Blob questionIds,Integer duration,String createdBy,Timestamp lastAccessts,Integer diificultyLevel,
			String testName,String testDesc,String basePriceTest,Integer status,Integer percentNegative){
		this.qCount = qCount;
		this.questionIds = questionIds;
		this.duration = duration;
		this.createdBy = createdBy;
		this.lastAccessts = lastAccessts;
		this.diificultyLevel = diificultyLevel;
		this.testName = testName;
		this.testDesc = testDesc;
		this.basePriceTest = basePriceTest;
		this.status = status;
		this.percentNegative = percentNegative;
	}

	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}
	
	public String getqCount() {
		return qCount;
	}

	public void setqCount(String qCount) {
		this.qCount = qCount;
	}

	public Blob getQuestionIds() {
		return questionIds;
	}

	public void setQuestionIds(Blob questionIds) {
		this.questionIds = questionIds;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getLastAccessts() {
		return lastAccessts;
	}

	public void setLastAccessts(Timestamp lastAccessts) {
		this.lastAccessts = lastAccessts;
	}

	public Integer getDiificultyLevel() {
		return diificultyLevel;
	}

	public void setDiificultyLevel(Integer diificultyLevel) {
		this.diificultyLevel = diificultyLevel;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getTestDesc() {
		return testDesc;
	}

	public void setTestDesc(String testDesc) {
		this.testDesc = testDesc;
	}

	public String getBasePriceTest() {
		return basePriceTest;
	}

	public void setBasePriceTest(String basePriceTest) {
		this.basePriceTest = basePriceTest;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getPercentNegative() {
		return percentNegative;
	}

	public void setPercentNegative(Integer percentNegative) {
		this.percentNegative = percentNegative;
	}
}
