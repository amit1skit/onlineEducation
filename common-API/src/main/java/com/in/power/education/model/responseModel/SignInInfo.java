package com.in.power.education.model.responseModel;

import java.sql.Date;

import com.in.power.education.model.UserInfo;
import com.in.power.education.model.UserLogin;

public class SignInInfo {

	private String userId;
	
	private String fName;
	
	private String lName;
	
	private String role;
	
	Date dob;
	String gender;
	String cellNo;
	String mailID;
	String addressLine1;
	String addressLine2;
	String city;
	String state;
	String country;
	String status;
	Integer zip;
	
	public SignInInfo() {
		// TODO Auto-generated constructor stub
	}
	public SignInInfo(UserLogin login,UserInfo info) {
		this.userId = login.getUserID();
		this.fName = info.getfName();
		this.lName =  info.getlName();
		this.role = info.getRole();
		this.dob= info.getDob() ;
		this.gender= info.getGender() ;
		this.cellNo= info.getCellNo() ;
		this.mailID= info.getMailID() ;
		this.addressLine1= info.getAddressLine1() ;
		this.addressLine2= info.getAddressLine2() ;
		this.city= info.getCity() ;
		this.state= info.getState() ;
		this.country= info.getCountry() ;
		this.zip= info.getZip() ;
		this.status =info.getStatus();
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the cellNo
	 */
	public String getCellNo() {
		return cellNo;
	}
	/**
	 * @param cellNo the cellNo to set
	 */
	public void setCellNo(String cellNo) {
		this.cellNo = cellNo;
	}
	/**
	 * @return the mailID
	 */
	public String getMailID() {
		return mailID;
	}
	/**
	 * @param mailID the mailID to set
	 */
	public void setMailID(String mailID) {
		this.mailID = mailID;
	}
	/**
	 * @return the addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}
	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	/**
	 * @return the addressLine2
	 */
	public String getAddressLine2() {
		return addressLine2;
	}
	/**
	 * @param addressLine2 the addressLine2 to set
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the zip
	 */
	public Integer getZip() {
		return zip;
	}
	/**
	 * @param zip the zip to set
	 */
	public void setZip(Integer zip) {
		this.zip = zip;
	}
}
