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
<script type="text/javascript" src="proffvalidation.js">
</script>
<center>
<h3 class="addTitle">Add Notice Here</h3>
	</center>
	<center>
		<form action="AddNotice" id="noticedetails" name="noticeform">
			<table>
				
				<tr class="colHeightUser">
					<td class="plainText">Course ID</td>
					<td ><input class="htmlText" type="text" name="courseid" /> </td>
					<td ><p class="lblerr" id="courseIdError"></p></td>
				</tr>
				
				<tr class="colHeightUser">
					<td class="plainText">CRN</td>
					<td ><input class="htmlText" type="text" name="crn" /> </td>
					<td ><p class="lblerr" id="CRNError"></p></td>
				</tr>
				
				<tr class="colHeightUser">
					<td class="plainText">Section</td>
					<td ><input class="htmlText" type="text" name="section" /> </td>
					<td ><p class="lblerr" id="sectionError"></p></td>
				</tr>
				
				<tr class="colHeightNotice">
					<td class="plainText">Notice</td>
					<td ><textarea rows="5" cols="15" class="noticeText" name="notice"> </textarea> </td>
					<td ><p class="lblerr" id="noticeError"></p></td>
				</tr>
                
                
				
				<tr class="colHeight">
					<td></td>
					<td  align="center"><input class="myButton"
						
						type="button" value='Add Notice' onclick="validateNotice()"  id="noticedetails" /></td>
						
				</tr>
				
				
			</table>
			

		</form>

	</center>
</body>
</html>