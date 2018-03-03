package com.in.power.education.worker;

import java.sql.Timestamp;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.in.power.education.model.UserInfo;
import com.in.power.education.model.UserLogin;
import com.in.power.education.model.responseModel.SignInInfo;
import com.in.power.education.repo.UserInfoRepo;
import com.in.power.education.repo.UserLoginRepo;

@Component
public class LoginWorker {
	
	@Autowired
	UserLoginRepo userLoginRepo;
	
	@Autowired
	UserInfoRepo userInfoRepo;
	
	public SignInInfo getSignInInfo(String request){
		SignInInfo info = null;
		JSONObject requestObject = null;
		try{
			requestObject = new JSONObject(request);
			UserLogin userlogin = userLoginRepo.findByuserID(requestObject.getString("userID"));
			System.out.println("ssd"+userlogin.getPassword());
			if(userlogin.getPassword().equals(requestObject.getString("password"))){
				UserInfo userInfo = userInfoRepo.findByuserID(userlogin.getUserID());
				info =  new SignInInfo(userlogin,userInfo);
				System.out.println("Passed Login Information");
				
			}else{
				System.out.println("Failed Login Information");
				if(null == userlogin.getNoOfAttempt())
					userlogin.setNoOfAttempt(1);
				else
					userlogin.setNoOfAttempt(userlogin.getNoOfAttempt()+1);
				userLoginRepo.save(userlogin);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return info;
	}
	
	public SignInInfo setSignUpInfo(String request){
		JSONObject requestObject = null;
		SignInInfo info = null;
		
		try{
			requestObject = new JSONObject(request);
//			Saving User Login Information
			UserLogin userlogin = new UserLogin(requestObject.getString("userID"), requestObject.getString("password"),
					new Timestamp(System.currentTimeMillis()) ,new Timestamp(System.currentTimeMillis()) ,0,null);
			userlogin = userLoginRepo.save(userlogin);
			
			UserInfo userInfo = new UserInfo(userlogin, "", requestObject.getString("firstName"), requestObject.getString("lastName"),
					null, null, null, requestObject.getString("email"), null, null, null, null, null,userlogin.getUserID());
			
			userInfoRepo.save(userInfo);
			info = new SignInInfo(userlogin,userInfo);
			System.out.println("ssd"+userlogin.getPassword());
		}catch(Exception e){
			e.printStackTrace();
		}
		return info;
	}
}
