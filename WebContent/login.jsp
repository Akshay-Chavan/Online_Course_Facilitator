<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="button_styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Course Facilitator</title>
</head>
<body class="homeBodyStyle">
<script type="text/javascript" src="authenticatescript.js">
</script>
<center>
		<div class="header">
			<div class="logo">
				<img hspace="10px" alt="" src="logo.png" width="100" height="90"
					style="position: absolute;">
			</div>
			<div class="headerRight">
				<label class="headerLabel">Online Course Facilitator</label> <br> 
			</div>
		</div>
	</center>
<center>
		<div class="loginMaster">
		<h3 class="addTitle">Please Enter Your Login Credentials</h3>
			<form action="CreateSession" id="loginDetails" name="loginForm">
			<table>
			
				<tr class="colHeightUser">
					<td  class="plainText">Category</td>
					<td ><select class="htmlText" name= "category">
					<option value="Administrator">Administrator</option>
					<option value="Professor">Professor</option>
					<option value="Student">Student</option>
					</select> </td>
				</tr>
				
				<tr class="colHeightUser">
					<td class="plainText">KID</td>
					<td ><input class="htmlText" type="text" name="kid" value=""/> </td>
					<td ><p class="lblerr" id="userIdError"></p></td>
				</tr>
				
				<tr class="colHeightUser">
					<td class="plainText">Password</td>
					<td ><input class="htmlText" type="password" name="password" value=""/> </td>
					<td ><p class="lblerr" id="passwordError"></p></td>
				</tr>
				
				<tr class="colHeight">
					<td></td>
					<td  align="center"><input class="myButton"
						type="button" value='Login' onclick="validate()"  id="authenticateDetails" /></td>
				</tr>
				
				</table>
		</form>
		</div>
	    </center>
	    
	    <center>
		<div class="footer"></div>
		</center>

</body>
</html>