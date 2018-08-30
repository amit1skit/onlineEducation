package com.in.power.education.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.in.power.education.model.responseModel.SignInInfo;
import com.in.power.education.worker.LoginWorker;

@RestController
@RequestMapping("/secure/logon")
public class LoginController {

	@Autowired
	LoginWorker loginWorker;
	
	@RequestMapping(value = "signIn" , method = RequestMethod.POST)
	public ResponseEntity<?> getSignInInfo(@RequestBody String request){
		Object responseObj = null;
		SignInInfo info =  loginWorker.getSignInInfo(request);
//		return new ResponseEntity(responseObj, HttpStatus.OK);
		return	ResponseEntity.ok(info); 	
	}
	
	@RequestMapping(value = "signUp" , method = RequestMethod.POST)
	public ResponseEntity<?> setSignUpInfo(@RequestBody String request){
		Object responseObj = null;
		SignInInfo info = loginWorker.setSignUpInfo(request);
		return	ResponseEntity.ok(info); 	
	}
}
