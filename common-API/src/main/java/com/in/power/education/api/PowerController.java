package com.in.power.education.api;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.in.power.education.model.responseModel.SignInInfo;
import com.in.power.education.worker.PowerWorker;

@RestController
@RequestMapping("/secure/power")
public class PowerController {

	@Autowired
	PowerWorker powerWorker;
	
	@RequestMapping(value = "addQuestionToTest" , method = RequestMethod.POST)
	public ResponseEntity<?> addQuestionToTest(@RequestBody String request){
		JSONObject requestObj;
		JSONObject responseObj = null;
		try {
			requestObj = new JSONObject(request);
			responseObj = powerWorker.addQuestionToTest(requestObj);
		} catch (JSONException e) {
			System.err.println("Error in parsing the Request");
			e.printStackTrace();
		}
	
//		return new ResponseEntity(responseObj, HttpStatus.OK);
		if(responseObj!=null)
			return	ResponseEntity.ok(responseObj);
		else
			return	ResponseEntity.ok(null);
	}
	
	
}
