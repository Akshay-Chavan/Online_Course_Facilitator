package com.oodp.ocf.beans;

import com.oodp.ocf.dao.AuthenticateDAO;
import com.oodp.ocf.factory.ConnectionFactory;

public class User {
private String KID,password,category;
AuthenticateDAO authenticate;

public User(){
	
}

public User(String KID){
	this.KID = KID;
}

public User(String KID, String password, String category) {
	super();
	this.KID = KID;
	this.password = password;
	this.category = category;
}

public String getKID() {
	return KID;
}

public void setKID(String userId) {
	this.KID = userId;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category = category;
}

public boolean validate(){
	boolean valid=false;
	authenticate=new AuthenticateDAO();
	if(authenticate.authenticateUser(KID, password, category)){
		valid=true;
		System.out.println(valid);
	} 
	return valid;
}

@Override
public String toString() {
	return "User [category=" + category + ", password=" + password
			+ ", userId=" + KID + ", getCategory()=" + getCategory()
			+ ", getPassword()=" + getPassword() + ", getUserId()="
			+ getKID() + ", getClass()=" + getClass() + ", hashCode()="
			+ hashCode() + ", toString()=" + super.toString() + "]";
}
}
