package com.in.power.education.worker;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.in.power.education.model.Test;
import com.in.power.education.repo.TestRepo;
import com.in.power.education.repo.UserInfoRepo;
import com.in.power.education.util.Constants;

@Component
public class PowerWorker implements Constants{
	
	@Autowired
	TestRepo testRepo;
	
	@Autowired
	UserInfoRepo userInfoRepo;
	
	public JSONObject addQuestionToTest(JSONObject request) {
		JSONObject responseObj = new JSONObject();
		JSONArray questionIdsJSON = null;
		List<Test> testList = testRepo.findByTestName(request.optString(testName));
		try {
			if(request.optString(questionIds)!=null && request.optString(questionIds)!="")
				questionIdsJSON = new JSONArray(new String(Base64.getDecoder().decode(request.optString(questionIds))));
			if (testList.size() == 0 && !request.optBoolean(addIfNotExists)) {
				responseObj = setResponse(responseObj,"error", "Test Not Found");
				return responseObj;
			} else if (testList.size() == 0	&& request.optBoolean(addIfNotExists)) {
				Test test = new Test();
				test.setTestName(request.optString(testName));
				test.setCategory(request.optString(category));
				test.setDiificultyLevel(request.optString(diificultyLevel));
				test.setDuration(request.optInt(duration));
				test.setTotalMarks(request.optInt(totalMarks));
				test.setqCount(request.optInt(qCount));
				test.setQuestionIds(questionIdsJSON.toString().getBytes(StandardCharsets.UTF_8));
				test.setStatus(request.optString(status));
				testRepo.save(test);
				responseObj = setResponse(responseObj,"success", "Saved Data");
			} else if (testList.size() == 1) {
				Test test = testList.get(0);
				if(testList.get(0).getQuestionIds()==null){
					test.setQuestionIds(questionIdsJSON.toString().getBytes(StandardCharsets.UTF_8));
					testRepo.save(test);
					responseObj = setResponse(responseObj,"success", "Saved Data");
					return responseObj; 
				}
				JSONArray arrayDBQ,arrayDBQTemp = null;
				System.out.println(">>"+new String(testList.get(0).getQuestionIds())+"<<");
				try{
					arrayDBQ = new JSONArray(new String(Base64.getDecoder().decode(testList.get(0).getQuestionIds())));
					arrayDBQTemp = new JSONArray(new String(Base64.getDecoder().decode(testList.get(0).getQuestionIds())));
				}catch(Exception e){
					try{
						arrayDBQ = new JSONArray(new String(testList.get(0).getQuestionIds()));
						arrayDBQTemp = new JSONArray(new String(testList.get(0).getQuestionIds()));	
					}catch(Exception e1){
						arrayDBQ = null;
						arrayDBQTemp = null;
					}
					
				}
				if (arrayDBQ==null || arrayDBQ.length() == 0) {
					test.setQuestionIds(questionIdsJSON.toString().getBytes(StandardCharsets.UTF_8));
					testRepo.save(test);
					responseObj = setResponse(responseObj,"success", "Saved Data");
					return responseObj; 
				} else {
					boolean isQuestionFound = false;
					for (int i = 0; i < questionIdsJSON.length(); i++) {
						isQuestionFound = false;
						for (int j = 0; j < arrayDBQ.length(); j++) {
							if (questionIdsJSON.optJSONObject(i).get("id").equals(arrayDBQ.optJSONObject(j).get("id"))) {
								isQuestionFound = true;
								break;
							}
						}
						if(!isQuestionFound){
							arrayDBQTemp.put(questionIdsJSON.get(i));	
						}
					}
					if(arrayDBQTemp.length() == arrayDBQ.length()){
						responseObj = setResponse(responseObj,"warning", "Already Exist.");
					}else{
						test.setQuestionIds((arrayDBQTemp.toString()).getBytes(StandardCharsets.UTF_8));
						testRepo.save(test);
						responseObj = setResponse(responseObj,"success", "Saved Data");
					}
				}
			}
		} catch (JSONException e) {
			try {
				responseObj.put("Error","UnExpected Error Occured");
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
			e.printStackTrace();
		}
		return responseObj;
	}
	private JSONObject setResponse(JSONObject response,String type,String message){
		try {
			response.put("type", type);
			response.put("message", message);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response;
	}

}

