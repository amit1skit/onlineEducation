package com.in.power.education.model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.springframework.data.rest.core.annotation.Description;

@Entity
public class UserReport extends AbstractEntity implements Serializable  {

	@OneToOne(cascade = CascadeType.ALL)
	@Description(value="User Login information")
	private UserLogin userLogin;  
	
	@Description(value="Start Date of Subscription")
	private Timestamp startDt;
	
	@Description(value="End Date of Subscription")
	private Timestamp endDt;
	
	
	public UserReport() {
	}
	
	public UserReport(UserLogin userLogin,Timestamp startDt,Timestamp endDt){
		this.userLogin = userLogin;
		this.startDt = startDt;
		this.endDt = endDt;
	}

	public Timestamp getStartDt() {
		return startDt;
	}

	public void setStartDt(Timestamp startDt) {
		this.startDt = startDt;
	}

	public Timestamp getEndDt() {
		return endDt;
	}

	public void setEndDt(Timestamp endDt) {
		this.endDt = endDt;
	}

	/**
	 * @return the userLogin
	 */
	public UserLogin getUserLogin() {
		return userLogin;
	}

	/**
	 * @param userLogin the userLogin to set
	 */
	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}
}