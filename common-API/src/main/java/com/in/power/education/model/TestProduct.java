package com.in.power.education.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.springframework.data.rest.core.annotation.Description;




@Entity
public class TestProduct extends AbstractEntity implements Serializable{
	
	@Description(value="This Is name of Category")
	private String pNm;
	
	@Description(value="This Is description of Category")
	private String pDesc;
	
	@Description(value="This Is Free for F or Paid for P")
	private String pMode;
	
	@Description(value="One to Many Relation with Test")
	@OneToMany(mappedBy="testProduct", cascade=CascadeType.ALL, orphanRemoval = true)
	private Set<Test> test;

	public TestProduct(){}
	
	public TestProduct(String pNm, String pDesc, String pMode) {
		super();
		this.pNm = pNm;
		this.pDesc = pDesc;
		this.pMode = pMode;
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
}
