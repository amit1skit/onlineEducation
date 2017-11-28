package com.in.power.education.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.springframework.data.rest.core.annotation.Description;

@Entity
public class UserInfo  extends AbstractEntity implements Serializable {

	@OneToOne(cascade = CascadeType.ALL)
	@Description(value="User Login information")
	private UserLogin userLogin;  
	
	@Description(value="Role of User")
	private String role;
	
	@Description(value="First Name")
	private String fName;
	
	@Description(value="Last Name")
	private String lName;
	
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
	private String city;
	
	@Description(value="Address State")
	private String state;
	
	@Description(value="Address Country")
	private String country;
	
	@Description(value="UserID")
	private String userID;
	
	public UserInfo(){}
	
	public UserInfo(UserLogin userLogin, String role,String fName,String lName,
			Date dob,String gender,String CellNo,String mailID,String addressLine1,
			String addressLine2,String city,String state,String country, String userID){
		this.userLogin = userLogin;
		this.role = role;
		this.fName = fName;
		this.lName = lName;
		this.dob =dob;
		this.gender = gender;
		this.CellNo = CellNo;
		this.mailID = mailID;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.userID = userID;
	}

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

	public UserLogin getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getfName() {
		return fName;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
}
