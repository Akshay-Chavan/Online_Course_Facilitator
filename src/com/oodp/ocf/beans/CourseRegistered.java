package com.oodp.ocf.beans;

public class CourseRegistered {
private int courseId, CRN, section;
private String KID, semester, major, courseName, time, days;

public CourseRegistered(){
	
}

public CourseRegistered(int courseId, int cRN, int section, String kID,
		String semester, String major, String courseName, String time, String days) {
	super();
	this.courseId = courseId;
	CRN = cRN;
	this.section = section;
	KID = kID;
	this.semester = semester;
	this.major = major;
	this.courseName=courseName;
	this.time=time;
	this.days=days;
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

public String getKID() {
	return KID;
}

public void setKID(String kID) {
	KID = kID;
}

public String getSemester() {
	return semester;
}

public String getCourseName() {
	return courseName;
}

public void setCourseName(String courseName) {
	this.courseName=courseName;
}

public String getTime() {
	return time;
}

public void setTime(String time) {
	this.time=time;
}

public String getDays() {
	return days;
}

public void setDays(String days) {
	this.days=days;
}

public void setSemester(String semester) {
	this.semester = semester;
}

public String getMajor() {
	return major;
}

public void setMajor(String major) {
	this.major = major;
}

@Override
public String toString() {
	return "CourseRegistered [CRN=" + CRN + ", KID=" + KID + ", courseId="
			+ courseId + ", courseName=" + courseName + ", days=" + days
			+ ", major=" + major + ", section=" + section + ", semester="
			+ semester + ", time=" + time + "]";
}




}
