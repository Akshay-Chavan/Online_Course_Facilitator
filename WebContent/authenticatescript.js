//function changeText() {
//	var x=document.getElementById("doc").value;
//	document.write(x);
//}

var userId=0;
var password=0;
var userIdValidation=0;
var passwordValidation=0;

var courseId=0;
var CRN=0;
var section=0;
var courseIdValidation=0;
var CRNValidation=0;
var sectionError=0;

function validate()
{
var userId=document.forms["loginForm"]["kid"].value;
var password=document.forms["loginForm"]["password"].value;

if(userId==null||userId=="")
	{
	document.getElementById("userIdError").innerHTML="KID required";
	userIdValidation=0;
	}
else
	{
	document.getElementById("userIdError").innerHTML="";
	userIdValidation=1;
	}

if(password==null||password=="")
{
document.getElementById("passwordError").innerHTML="Password required";
passwordValidation=0;
}
else
{
document.getElementById("passwordError").innerHTML="";
passwordValidation=1;
}

if(userIdValidation==1 && passwordValidation==1)
{
document.getElementById("loginDetails").submit();
}

}

function validateCourse()
{
var courseId=document.forms["registerform"]["courseid"].value;
var CRN=document.forms["registerform"]["crn"].value;
var section=document.forms["registerform"]["section"].value;

if(courseId==null||courseId=="")
	{
	document.getElementById("courseIdError").innerHTML="CourseId required";
	courseIdValidation=0;
	}
else
	{
	document.getElementById("courseIdError").innerHTML="";
	courseIdValidation=1;
	}

if(CRN==null||CRN=="")
{
document.getElementById("CRNError").innerHTML="CRN required";
CRNValidation=0;
}
else
{
document.getElementById("CRNError").innerHTML="";
CRNValidation=1;
}

if(section==null||section=="")
{
document.getElementById("sectionError").innerHTML="CRN required";
sectionValidation=0;
}
else
{
document.getElementById("sectionError").innerHTML="";
sectionValidation=1;
}

if(courseIdValidation==1 && CRNValidation==1 && sectionValidation==1)
{
document.getElementById("coursedetails").submit();
}

}

function goForward() {
	window.history.forward();
}

function goBackward() {
	window.history.back();
}

