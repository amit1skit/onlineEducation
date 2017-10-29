package com.in.power.education.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.springframework.data.rest.core.annotation.Description;

@Entity
public class UserInfo  extends AbstractEntity implements Serializable {

	@OneToOne
	private UserLogin userLogin;  
	
	@Description(value="Role of User")
	private String role;
	
	@Description(value="First Name")
	private String FName;
	
	@Description(value="Last Name")
	private String LName;
	
	@Description(value="Date of Birth")
	private Date dob;
	
	@Description(value="Gender of user")
	private String gender;
	
	
	@Description(value="Cell Number")
	private String CellNo;
	
	@Description(value="Mail Address")
	private String mailID;
	
	@Description(value="Address Line1")
	private String addressLine1;
	
	@Description(value="Address Line2")
	private String addressLine2;
	
	@Description(value="Address City")
	private String addressCity;
	
	@Description(value="Address State")
	private String addressState;
	
	@Description(value="Address Country")
	private String addressCountry;
	
	
	public UserInfo(){}
	
//	public UserInfo(String userID, String password,Timestamp lastLogintime, Timestamp creationTime){
//		this.userID = userID;
//		this.password = password;
//		this.lastLogintime = lastLogintime;
//		this.creationTime = creationTime;
//	}

	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFName() {
		return FName;
	}

	public void setFName(String fName) {
		FName = fName;
	}

	public String getLName() {
		return LName;
	}

	public void setLName(String lName) {
		LName = lName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCellNo() {
		return CellNo;
	}

	public void setCellNo(String cellNo) {
		CellNo = cellNo;
	}

	public String getMailID() {
		return mailID;
	}

	public void setMailID(String mailID) {
		this.mailID = mailID;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressState() {
		return addressState;
	}

	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}

	public String getAddressCountry() {
		return addressCountry;
	}

	public void setAddressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
	}
}
