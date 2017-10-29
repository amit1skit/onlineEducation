package com.in.power.education.model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Timestamp;

import javax.persistence.Entity;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.springframework.data.rest.core.annotation.Description;

@Entity
public class Subscription extends AbstractEntity implements Serializable  {

//	1. courseID
//	2. UserID
//	3. endDate
//	4. starrtDate


	@Description(value="Start Date of Subscription")
	private Timestamp startDt;
	
	@Description(value="End Date of Subscription")
	private Timestamp endDt;
	
	
	public Subscription() {
	}
	
	public Subscription(Timestamp startDt,Timestamp endDt){
		this.startDt = startDt;
		this.endDt = endDt;
	}

	public Timestamp getStartDt() {
		return startDt;
	}

	public void setStartDt(Timestamp startDt) {
		this.startDt = startDt;
	}

	public Timestamp getEndDt() {
		return endDt;
	}

	public void setEndDt(Timestamp endDt) {
		this.endDt = endDt;
	}
}