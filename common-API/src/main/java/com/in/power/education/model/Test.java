package com.in.power.education.model;

import java.io.Serializable;
import java.security.Timestamp;
import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.springframework.data.rest.core.annotation.Description;

@Entity
public class Test extends AbstractEntity implements Serializable  {

	@Description(value="Number of Question in Test")
	private Integer qCount;
	
	@Description(value="Questions JSON")
	@Lob
	private byte[] questionIds;
	
	@Description(value="Duration of Test")
	private Integer duration;
	
	@Description(value="created by User")
	private String createdBy;
	
	@Description(value="last Modified by")
	private Timestamp lastAccessts;
	
	@Description(value="Difficult level 1. Easy, 2. Medium, 3. difficult")
	private String diificultyLevel;
	
	@Description(value="Test Name")
	private String testName;
	
	@Description(value="Test Description")
	private String testDesc;
	
	@Description(value="Base price of Test")
	private String basePriceTest;
	
	@Description(value="status of Test")
	private String status;
	
	@Description(value="Percentage of Negative marks")
	private Integer percentNegative;
	
	@Description(value="Total Marks of Test")
	private Integer totalMarks;
	
	@Description(value="Category is similar to Tag that we can have.")
	private String category;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@Description(value="Mapping to Test Product")
	private TestProduct testProduct;

	public Test() {
	}
	
	public Test(Integer qCount,byte[] questionIds,Integer duration,String createdBy,Timestamp lastAccessts,
			String diificultyLevel,String testName,String testDesc,String basePriceTest,String status,
			Integer percentNegative,Integer totalMarks,TestProduct testProduct,String category){
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
		this.totalMarks = totalMarks;
		this.testProduct = testProduct;
		this.category = category;
	}

	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}
	
	public Integer getqCount() {
		return qCount;
	}

	public void setqCount(Integer qCount) {
		this.qCount = qCount;
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

	public String getDiificultyLevel() {
		return diificultyLevel;
	}

	public void setDiificultyLevel(String diificultyLevel) {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getPercentNegative() {
		return percentNegative;
	}

	public void setPercentNegative(Integer percentNegative) {
		this.percentNegative = percentNegative;
	}

	/**
	 * @return the totalMarks
	 */
	public Integer getTotalMarks() {
		return totalMarks;
	}

	/**
	 * @param totalMarks the totalMarks to set
	 */
	public void setTotalMarks(Integer totalMarks) {
		this.totalMarks = totalMarks;
	}

	/**
	 * @return the testProduct
	 */
	public TestProduct getTestProduct() {
		return testProduct;
	}

	/**
	 * @param testProduct the testProduct to set
	 */
	public void setTestProduct(TestProduct testProduct) {
		this.testProduct = testProduct;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the questionIds
	 */
	public byte[] getQuestionIds() {
		return questionIds;
	}

	/**
	 * @param questionIds the questionIds to set
	 */
	public void setQuestionIds(byte[] questionIds) {
		this.questionIds = questionIds;
	}
}
