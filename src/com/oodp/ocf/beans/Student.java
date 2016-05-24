package com.oodp.ocf.beans;

public class Student extends User{
	String  name;
	
	public Student(){
		
	}
	
	public Student(String kID, String name) {
		super(kID);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}
	
	

}
