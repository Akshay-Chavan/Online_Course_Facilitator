package com.oodp.ocf.beans;

public class CoursesAvailable {
private int courseId, CRN, totalSeats, seatsAvailable, section;
private String courseName, time, instructor, days;

public CoursesAvailable(){
	
}

public CoursesAvailable(int courseId, int cRN, int totalSeats,
		int seatsAvailable, int section, String courseName, String time,
		String instructor, String days) {
	super();
	this.courseId = courseId;
	CRN = cRN;
	this.totalSeats = totalSeats;
	this.seatsAvailable = seatsAvailable;
	this.section = section;
	this.courseName = courseName;
	this.time = time;
	this.instructor = instructor;
	this.days = days;
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

public int getTotalSeats() {
	return totalSeats;
}

public void setTotalSeats(int totalSeats) {
	this.totalSeats = totalSeats;
}

public int getSeatsAvailable() {
	return seatsAvailable;
}

public void setSeatsAvailable(int seatsAvailable) {
	this.seatsAvailable = seatsAvailable;
}

public int getSection() {
	return section;
}

public void setSection(int section) {
	this.section = section;
}

public String getCourseName() {
	return courseName;
}

public void setCourseName(String courseName) {
	this.courseName = courseName;
}

public String getTime() {
	return time;
}

public void setTime(String time) {
	this.time = time;
}

public String getInstructor() {
	return instructor;
}

public void setInstructor(String instructor) {
	this.instructor = instructor;
}

public String getDays() {
	return days;
}

public void setDays(String days) {
	this.days = days;
}

@Override
public String toString() {
	return "AvailableCourses [CRN=" + CRN + ", courseId=" + courseId
			+ ", courseName=" + courseName + ", days=" + days + ", instructor="
			+ instructor + ", seatsAvailable=" + seatsAvailable + ", section="
			+ section + ", time=" + time + ", totalSeats=" + totalSeats + "]";
}



}
