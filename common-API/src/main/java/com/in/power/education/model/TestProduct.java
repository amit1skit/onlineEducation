package com.in.power.education.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.springframework.data.rest.core.annotation.Description;




@Entity
public class TestProduct extends AbstractEntity implements Serializable{
	
	@Description(value="This Is name of Product")
	private String pNm;
	
	@Description(value="This Is description of Product")
	private String pDesc;
	
	@Description(value="This Is Free for F or Paid for P")
	private String pMode;
	
	@Description(value="This Is Base Price of product.")
	private Double basePrice;
	
	
	@Description(value="This Is Tag to find a test.")
	private String pTag;
	
	@Description(value="This Start Date of test when it will appear.")
	private Date startDate;
	
	@Description(value="This Is End Date of Test product when it will end.")
	private Date endDate;
	
	@Description(value="This Is validity in number of days.")
	private Integer validity;
	
	@Description(value="This Is Quiz =0 Test Series = 1  and Quiz/Test =2")
	private Integer pType;
	
	
	@Description(value="One to Many Relation with Test")
	@OneToMany(mappedBy="testProduct", cascade=CascadeType.ALL, orphanRemoval = true)
	private Set<Test> test;

	public TestProduct(){}
	
	public TestProduct(String pNm, String pDesc, String pMode,String pTag,Date startDate,Date endDate,
			Integer validity,Integer pType,Double basePrice) {
		super();
		this.pNm = pNm;
		this.pDesc = pDesc;
		this.pMode = pMode;
		this.pTag =pTag;
		this.startDate = startDate;
		this.endDate = endDate;
		this.validity = validity;
		this.pType = pType;
		this.basePrice = basePrice;
	}

	/**
	 * @return the pNm
	 */
	public String getpNm() {
		return pNm;
	}

	/**
	 * @param pNm the pNm to set
	 */
	public void setpNm(String pNm) {
		this.pNm = pNm;
	}

	/**
	 * @return the pDesc
	 */
	public String getpDesc() {
		return pDesc;
	}

	/**
	 * @param pDesc the pDesc to set
	 */
	public void setpDesc(String pDesc) {
		this.pDesc = pDesc;
	}

	/**
	 * @return the pMode
	 */
	public String getpMode() {
		return pMode;
	}

	/**
	 * @param pMode the pMode to set
	 */
	public void setpMode(String pMode) {
		this.pMode = pMode;
	}

	/**
	 * @return the pTag
	 */
	public String getpTag() {
		return pTag;
	}

	/**
	 * @param pTag the pTag to set
	 */
	public void setpTag(String pTag) {
		this.pTag = pTag;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the validity
	 */
	public Integer getValidity() {
		return validity;
	}

	/**
	 * @param validity the validity to set
	 */
	public void setValidity(Integer validity) {
		this.validity = validity;
	}

	/**
	 * @return the pType
	 */
	public Integer getpType() {
		return pType;
	}

	/**
	 * @param pType the pType to set
	 */
	public void setpType(Integer pType) {
		this.pType = pType;
	}

	/**
	 * @return the test
	 */
	public Set<Test> getTest() {
		return test;
	}

	/**
	 * @param test the test to set
	 */
	public void setTest(Set<Test> test) {
		this.test = test;
	}

	/**
	 * @return the basePrice
	 */
	public Double getBasePrice() {
		return basePrice;
	}

	/**
	 * @param basePrice the basePrice to set
	 */
	public void setBasePrice(Double basePrice) {
		this.basePrice = basePrice;
	}
}
