package com.in.power.education.api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
			return	ResponseEntity.ok(responseObj.toString());
		else
			return	ResponseEntity.ok(null);
	}
	
	@RequestMapping(value = "removeQuestionFromTest" , method = RequestMethod.POST)
	public ResponseEntity<?> removeQuestionFromTest(@RequestBody String request){
		JSONObject requestObj;
		JSONObject responseObj = null;
		try {
			requestObj = new JSONObject(request);
			responseObj = powerWorker.removeQuestionFromTest(requestObj);
		} catch (JSONException e) {
			System.err.println("Error in parsing the Request");
			e.printStackTrace();
		}
	
//		return new ResponseEntity(responseObj, HttpStatus.OK);
		if(responseObj!=null)
			return	ResponseEntity.ok(responseObj.toString());
		else
			return	ResponseEntity.ok(null);
	}
	
	@RequestMapping(value = "updateTestStatus" , method = RequestMethod.POST)
	public ResponseEntity<?> updateTestStatus(@RequestBody String request){
		JSONObject requestObj;
		JSONObject responseObj = null;
		try {
			requestObj = new JSONObject(request);
			responseObj = powerWorker.updateTestStatus(requestObj);
		} catch (JSONException e) {
			System.err.println("Error in parsing the Request");
			e.printStackTrace();
		}
	
//		return new ResponseEntity(responseObj, HttpStatus.OK);
		if(responseObj!=null)
			return	ResponseEntity.ok(responseObj.toString());
		else
			return	ResponseEntity.ok(null);
	}
	
	@RequestMapping(value = "getAllQuestionFromTest" , method = RequestMethod.POST)
	public ResponseEntity<?> getAllQuestionFromTest(@RequestBody String request){
		JSONArray responseObj = null;
		try {
			responseObj = powerWorker.getAllQuestionFromTest(new JSONObject(request));
		}catch(Exception e){
			e.printStackTrace();
		}
		if(responseObj!=null)
			return	ResponseEntity.ok(responseObj.toString());
		else
			return	ResponseEntity.ok(null);
	}
	
	@RequestMapping(value = "uploadImage" , method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> uploadImage( @RequestPart("ad") String adString, @RequestPart("file") MultipartFile file) throws IOException{
		System.out.println("In the FIle Upload 2");
		JSONObject responseObj = new JSONObject();
		powerWorker.uploadImage(responseObj);
		byte[] bytes = file.getBytes();
		Path path = Paths.get("E://Workspace//" + file.getOriginalFilename());
		Files.write(path, bytes);
		try {
			responseObj.put("status","Success");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  ResponseEntity.ok(responseObj.toString());
	}
}
