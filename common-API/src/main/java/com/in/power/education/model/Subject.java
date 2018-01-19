package com.in.power.education.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.springframework.data.rest.core.annotation.Description;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Subject extends AbstractEntity implements Serializable  {

//	1. courseID
	@Description(value="Subject Name")
	private String subjectName;
	
	@Description(value="Subject Description")
	private String subjectDesc;
	
	@Description(value="Class of Subject")
	private String clas;
	
	@Description(value="Base Price for Subject")
	private Float basePrice;
	
	@Description("Topic to Question mapping")
	@OneToMany(mappedBy="subject", cascade=CascadeType.ALL, orphanRemoval = true)
	private Set<Question> question;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@Description(value="Course Information")
//	private Course course;  
	
	@Description("Subject to Topic mapping")
	@OneToMany(mappedBy="subject", cascade=CascadeType.ALL, orphanRemoval = true)
	private Set<Topic> topic;
	
	
	public Subject() {
	}
	
	public Subject(String subjectName,String subjectDesc,String clas,Float basePrice){
		this.subjectName = subjectName;
		this.subjectDesc = subjectDesc;
		this.clas = clas;
		this.basePrice = basePrice;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectDesc() {
		return subjectDesc;
	}

	public void setSubjectDesc(String subjectDesc) {
		this.subjectDesc = subjectDesc;
	}

	public String getClas() {
		return clas;
	}

	public void setClas(String clas) {
		this.clas = clas;
	}

	public Float getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(Float basePrice) {
		this.basePrice = basePrice;
	}

//	public Course getCourse() {
//		return course;
//	}
//	public void setCourse(Course course) {
//		this.course = course;
//	}
	
}