package com.in.power.education.model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.springframework.data.rest.core.annotation.Description;

@Entity
public class UserSubscription extends AbstractEntity implements Serializable  {

	@OneToOne(cascade = CascadeType.ALL)
	@Description(value="User Login information")
	private UserLogin userLogin;

	@Description(value="Start Date of Subscription {id: expiryDate: , subscribeDate: }")
	@Lob
	@Column(name="subscriptionInfo")
	private byte[] subsProductInfo;
	
	@Description(value="End Date of Subscription")
	private Timestamp lastChanged;
	
	
	public UserSubscription() {
	}
	
	public UserSubscription(UserLogin userLogin,byte[] subsProductInfo,Timestamp lastChanged){
		this.userLogin = userLogin;
		this.subsProductInfo = subsProductInfo;
		this.lastChanged = lastChanged;
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
	/**
	 * @return the subsProductInfo
	 */
	public byte[] getSubsProductInfo() {
		return subsProductInfo;
	}

	/**
	 * @param subsProductInfo the subsProductInfo to set
	 */
	public void setSubsProductInfo(byte[] subsProductInfo) {
		this.subsProductInfo = subsProductInfo;
	}

	/**
	 * @return the lastChanged
	 */
	public Timestamp getLastChanged() {
		return lastChanged;
	}

	/**
	 * @param lastChanged the lastChanged to set
	 */
	public void setLastChanged(Timestamp lastChanged) {
		this.lastChanged = lastChanged;
	}
}