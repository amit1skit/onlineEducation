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
public class UserLogin extends AbstractEntity implements Serializable {

	@Description("User Infor mapping")
	@OneToOne(mappedBy="userLogin", cascade=CascadeType.ALL, orphanRemoval = true)
	private UserInfo userInfo; 
	
	@Description("User Report mapping")
	@OneToOne(mappedBy="userReport", cascade=CascadeType.ALL, orphanRemoval = true)
	private UserReport userReport;
	
	@Description("User Subscription mapping")
	@OneToOne(mappedBy="userSubscription", cascade=CascadeType.ALL, orphanRemoval = true)
	private UserSubscription userSubscription;
	
	@Description(value = "User ID")
	private String userID;
	
	@Description(value = "User Password")
	private String password;
	
	@Description(value="Last Login time of User")
	private Timestamp lastLogintime;
	
	@Description(value="Creation time of User")
	private Timestamp creationTime;
	
	@Description(value="Number of failed Attempt")
	private Integer noOfAttempt;
	
	@Description(value="IP address JSON")
	private Blob ipAddresses;
	
	public UserLogin(){}
	
	public UserLogin(String userID, String password,Timestamp lastLogintime, Timestamp creationTime,
			Integer noOfAttempt,Blob ipAddresses){
		this.userID = userID;
		this.password = password;
		this.lastLogintime = lastLogintime;
		this.creationTime = creationTime;
		this.noOfAttempt = noOfAttempt;
		this.ipAddresses = ipAddresses;
	}
	
	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}

	/**
	 * @return the userID
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getLastLogintime() {
		return lastLogintime;
	}

	public void setLastLogintime(Timestamp lastLogintime) {
		this.lastLogintime = lastLogintime;
	}

	public Timestamp getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}
	public Integer getNoOfAttempt() {
		return noOfAttempt;
	}

	public void setNoOfAttempt(Integer noOfAttempt) {
		this.noOfAttempt = noOfAttempt;
	}

	public Blob getIpAddresses() {
		return ipAddresses;
	}

	public void setIpAddresses(Blob ipAddresses) {
		this.ipAddresses = ipAddresses;
	}

}
