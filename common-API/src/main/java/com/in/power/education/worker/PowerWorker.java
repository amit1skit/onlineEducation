package com.in.power.education.worker;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.in.power.education.model.Test;
import com.in.power.education.model.UserInfo;
import com.in.power.education.model.UserLogin;
import com.in.power.education.model.responseModel.SignInInfo;
import com.in.power.education.repo.TestRepo;
import com.in.power.education.repo.UserInfoRepo;
import com.in.power.education.repo.UserLoginRepo;
import com.in.power.education.util.Constants;

@Component
public class PowerWorker implements Constants{
	
	@Autowired
	TestRepo testRepo;
	
	@Autowired
	UserInfoRepo userInfoRepo;
	
	public JSONObject addQuestionToTest(JSONObject request){
		request.optString(testName);
		List<Test> testList = testRepo.findByTestName(testName);
		try {
			if(testList.size()==0){
				return new JSONObject().put("Error","Test Not Found");
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		SignInInfo info = null;
//		JSONObject requestObject = null;
//		try{
//			requestObject = new JSONObject(request);
//			UserLogin userlogin = userLoginRepo.findByuserID(requestObject.getString("userID"));
//			System.out.println("ssd"+userlogin.getPassword());
//			if(userlogin.getPassword().equals(requestObject.getString("password"))){
//				UserInfo userInfo = userInfoRepo.findByuserID(userlogin.getUserID());
//				info =  new SignInInfo(userlogin,userInfo);
//				System.out.println("Passed Login Information");
//				
//			}else{
//				System.out.println("Failed Login Information");
//				if(null == userlogin.getNoOfAttempt())
//					userlogin.setNoOfAttempt(1);
//				else
//					userlogin.setNoOfAttempt(userlogin.getNoOfAttempt()+1);
//				userLoginRepo.save(userlogin);
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		return null;
	}
//	
//	public SignInInfo setSignUpInfo(String request){
//		JSONObject requestObject = null;
//		SignInInfo info = null;
//		
//		try{
//			requestObject = new JSONObject(request);
////			Saving User Login Information
//			UserLogin userlogin = new UserLogin(requestObject.getString("userID"), requestObject.getString("password"),
//					new Timestamp(System.currentTimeMillis()) ,new Timestamp(System.currentTimeMillis()) ,0,null);
//			userlogin = userLoginRepo.save(userlogin);
//			
//			UserInfo userInfo = new UserInfo(userlogin, "", requestObject.getString("firstName"), requestObject.getString("lastName"),
//					null, null, null, requestObject.getString("email"), null, null, null, null, null,userlogin.getUserID());
//			
//			userInfoRepo.save(userInfo);
//			info = new SignInInfo(userlogin,userInfo);
//			System.out.println("ssd"+userlogin.getPassword());
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return info;
//	}
}
