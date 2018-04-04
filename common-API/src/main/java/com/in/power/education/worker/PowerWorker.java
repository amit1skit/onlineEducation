package com.in.power.education.worker;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.in.power.education.model.Question;
import com.in.power.education.model.Test;
import com.in.power.education.repo.QuestionRepo;
import com.in.power.education.repo.TestRepo;
import com.in.power.education.repo.UserInfoRepo;
import com.in.power.education.util.Constants;

@Component
@PropertySource("application.properties")
public class PowerWorker implements Constants{
	
	@Autowired
	TestRepo testRepo;
	
	@Autowired
	QuestionRepo questionRepo;

	
	@Value("${file.path}")
	private String filePath;
	
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
				responseObj = setResponse(responseObj,"error", "Test Not Found",null,null);
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
				responseObj = setResponse(responseObj,"success", "Saved Data", test.getAutoID(),questionIdsJSON.length());
			} else if (testList.size() == 1) {
				Test test = testList.get(0);
				if(testList.get(0).getQuestionIds()==null){
					test.setQuestionIds(questionIdsJSON.toString().getBytes(StandardCharsets.UTF_8));
					testRepo.save(test);
					responseObj = setResponse(responseObj,"success", "Saved Data",test.autoID,questionIdsJSON.length());
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
					responseObj = setResponse(responseObj,"success", "Saved Data",test.autoID,questionIdsJSON.length());
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
						responseObj = setResponse(responseObj,"warning", "Already Exist.",null,null);
					}else{
						test.setQuestionIds((arrayDBQTemp.toString()).getBytes(StandardCharsets.UTF_8));
						testRepo.save(test);
						responseObj = setResponse(responseObj,"success", "Saved Data",test.autoID,arrayDBQTemp.length());
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
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public JSONObject removeQuestionFromTest(JSONObject request) {
		JSONObject responseObj =  new JSONObject();
		if(request.optString(testAutoId)=="" || request.optString(questionAutoId)=="" || request.optString(index)==""){
			responseObj=setResponse(responseObj, TYPE_ERROR, MESSAGE_MISSING,null,null);
		}else{
			Test test = testRepo.findOne(new Long(request.optString(testAutoId)));
			JSONArray arrayDBQ = null;
			try{
				arrayDBQ = new JSONArray(new String(Base64.getDecoder().decode(test.getQuestionIds())));
			}catch(Exception e){
				try{
					arrayDBQ = new JSONArray(new String(test.getQuestionIds()));
				}catch(Exception e1){
					arrayDBQ = null;
				}
			}
			if(arrayDBQ == null)
				responseObj=setResponse(responseObj, TYPE_ERROR, MESSAGE_Q_NOT_FOUND,null,null);
			else{
				arrayDBQ.remove(new Integer(request.optString(index)));
				test.setQuestionIds((arrayDBQ.toString()).getBytes(StandardCharsets.UTF_8));
				test.setStatus(statusPENDING);
				testRepo.save(test);
				responseObj = setResponse(responseObj,TYPE_SUCCESS, "Removed the question from test successfully.",null,null);
			}
		}
		return responseObj;
	}
	
	public JSONObject updateTestStatus(JSONObject request) {
		
		JSONObject responseObj =  new JSONObject();
		if(request.optString(testAutoId)=="" || request.optString(status)==""){
			responseObj=setResponse(responseObj, TYPE_ERROR, MESSAGE_MISSING,null,null);
		}else{
			Test test = testRepo.findOne(new Long(request.optString(testAutoId)));
			test.setStatus(request.optString(status));
			testRepo.save(test);
			responseObj = setResponse(responseObj,TYPE_SUCCESS, "Test is marked as "+request.optString(status)+". Proceed with your updates",test.autoID,null);
		}
		return responseObj;
	}
	
	public JSONArray getAllQuestionFromTest(JSONObject request){
		JSONArray responseObj =  new JSONArray();
		if(request.optString(questionIds)!=""){
			
			try {
				JSONArray questions = new JSONArray(new String(Base64.getDecoder().decode(request.optString(questionIds))));
				for(int i=0;i<questions.length();i++){
					JSONObject obj = questions.optJSONObject(i);
					Question quest =  questionRepo.findOne(obj.getLong("id"));
					JSONObject outputObj = new JSONObject();
					obj.put(questionsOP, new String(quest.getQuestion(),"UTF-8"));
					obj.put(answersOP, new String(quest.getAnswers(),"UTF-8"));
					obj.put(optionType, quest.getOptionType());
					obj.put(correctAns, quest.getCorrectAns());
					responseObj.put(obj);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return responseObj;
	}
	public JSONObject uploadImage(JSONObject request) {
		JSONObject responseObj =  new JSONObject();
		System.out.println("File Path "+filePath);
		return responseObj;
	}
	
	/**
	 * 
	 * @param response
	 * @param type
	 * @param message
	 * @return
	 */
	private JSONObject setResponse(JSONObject response,String type,String message,Long testAutoId,Integer qAdded){
		try {
			response.put("type", type);
			response.put("message", message);
			response.put("test", testAutoId);
			response.put("qCount", qAdded);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response;
	}

}

