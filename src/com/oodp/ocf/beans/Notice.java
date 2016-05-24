package com.oodp.ocf.beans;

import java.util.Calendar;
import java.util.Date;

public class Notice {
	
	String notice, from, time;
	int courseId, CRN, section;
	
	public Notice(){
		
	}
	
	public Notice(String notice, String from, int courseId, int cRN, int section, String time) {
		super();
		this.notice = notice;
		this.from = from;
		this.courseId = courseId;
		CRN = cRN;
		this.section = section;
		this.time = time;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getCRN() {
		return CRN;
	}
	public void setCRN(int cRN) {
		CRN = cRN;
	}
	public int getSection() {
		return section;
	}
	public void setSection(int section) {
		this.section = section;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getTime() {
		return time;
	}
	
	@Override
	public String toString() {
		return "Notice [CRN=" + CRN + ", courseId=" + courseId + ", from="
				+ from + ", notice=" + notice + ", section=" + section + "]";
	}
	

}
