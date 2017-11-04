package com.in.power.education.model;

import java.io.Serializable;
import java.security.Timestamp;
import java.sql.Blob;

import javax.persistence.Entity;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.springframework.data.rest.core.annotation.Description;

@Entity
public class CourseInfo extends AbstractEntity implements Serializable  {

	@Description(value="Course mapping")
	private Course course;
	
	@Description(value="Compelete course information")
	private Blob courseInfo;
	
	public CourseInfo() {
	}
	
	public CourseInfo(Course course,Blob courseInfo){
		this.course = course;
		this.courseInfo = courseInfo;
	}
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Blob getCourseInfo() {
		return courseInfo;
	}

	public void setCourseInfo(Blob courseInfo) {
		this.courseInfo = courseInfo;
	}
}
