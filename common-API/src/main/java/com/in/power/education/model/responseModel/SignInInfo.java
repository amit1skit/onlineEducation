package com.in.power.education.model.responseModel;

import com.in.power.education.model.UserInfo;
import com.in.power.education.model.UserLogin;

public class SignInInfo {

	private String userId;
	
	private String fName;
	
	private String lName;
	
	private String role;
	
	public SignInInfo() {
		// TODO Auto-generated constructor stub
	}
	public SignInInfo(UserLogin login,UserInfo info) {
		this.userId = login.getUserID();
		this.fName = info.getfName();
		this.lName =  info.getlName();
		this.role = info.getRole();
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
}
