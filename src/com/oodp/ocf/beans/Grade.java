package com.oodp.ocf.beans;

public class Grade {
	int courseId, CRN, section;
	String KID, grade, courseName;
	
	public Grade(){
		
	}
	
	public Grade(int courseId, int cRN, int section, String kID, String grade, String courseName) {
		super();
		this.courseId = courseId;
		CRN = cRN;
		this.section = section;
		KID = kID;
		this.grade = grade;
		this.courseName = courseName;
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

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@Override
	public String toString() {
		return "Grade [CRN=" + CRN + ", KID=" + KID + ", courseId=" + courseId
				+ ", grade=" + grade + ", section=" + section + "]";
	}
	
	
	
	

}
