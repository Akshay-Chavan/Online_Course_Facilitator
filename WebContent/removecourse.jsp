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
<script type="text/javascript" src="course.js">
</script>
<center>
<h3 class="addTitle">Remove Course</h3>
	</center>
	<center>
		<form action="Course" id="coursedetails" name="courseform" method="post">
			<table>
				
				<tr class="colHeightUser">
					<td class="plainText">Course ID</td>
					<td ><input class="htmlText" type="text" name="courseid" /> </td>
					<td ><p class="lblerr" id="courseIdError"></p></td>
				</tr>
				
				
				<tr class="colHeight">
					<td></td>
					<td  align="center"><input class="myButton"
						
						type="button" value='Remove Course' onclick="validateRemoveCourse()"  /></td>
						
				</tr>
				
				
			</table>
			

		</form>

	</center>
</body>
</html>