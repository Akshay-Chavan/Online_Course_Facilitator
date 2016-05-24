<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="button_styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: #23262B; color: white;">
<script type="text/javascript" src="script.js">
</script>
<center>
		<h3 class="addTitle">Select Your Semester And Major</h3>
	</center>
	<center>
		<form action="ViewAvailableCourses" id="studentDetails" name="form">
			<table>
				
				<tr class="colHeightUser">
					<td  class="plainText">Semester</td>
					<td ><select class="htmlText" name= "semester">
					<option value="Spring 2015">Spring 2015</option>
					<option value="Summer 2015">Summer 2015</option>
					<option value="Fall 2015">Fall 2015</option>
					</select> </td>
				</tr>
				
				<tr class="colHeightUser">
					<td  class="plainText">Major</td>
					<td ><select class="htmlText" name= "major">
					<option value="Computer Science">Computer Science</option>
					<option value="Electrical Engineering">Electrical Engineering</option>
					<option value="Chemical Engineering">Chemical Engineering</option>
					</select> </td>
				</tr>
				
				<tr class="colHeight">
					<td></td>
					<td  align="center"><input class="myButton"
						type="submit" value='Submit'  id="authenticateDetails" /></td>
				</tr>
				
			</table>
			

		</form>

	</center>
</body>
</html>