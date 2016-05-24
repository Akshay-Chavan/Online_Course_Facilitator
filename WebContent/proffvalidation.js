var courseId=0;
var CRN=0;
var notice=0;
var section = 0;

var courseValidation=0;
var CRNValidation=0;
var noticeValidation=0;
var sectionValidation=0;

function validateDetails(){
	
	var courseId=document.forms["registerform"]["courseid"].value;
	var CRN=document.forms["registerform"]["crn"].value;

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


	if(courseIdValidation==1 && CRNValidation==1)
	{
	document.getElementById("coursedetails").submit();
	}
}

function validateNotice(){
	
	 courseId=document.forms["noticeform"]["courseid"].value;
	 CRN=document.forms["noticeform"]["crn"].value;
	 notice=document.forms["noticeform"]["notice"].value;
	 section=document.forms["noticeform"]["section"].value;

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
	
	if(notice==null||notice=="")
	{
	document.getElementById("noticeError").innerHTML="Notice required";
	noticeValidation=0;
	}
	else
	{
	document.getElementById("noticeError").innerHTML="";
	noticeValidation=1;
	}
	
	if(section==null||section=="")
	{
	document.getElementById("sectionError").innerHTML="Section required";
	sectionValidation=0;
	}
	else
	{
	document.getElementById("sectionError").innerHTML="";
	sectionValidation=1;
	}


	if(courseIdValidation==1 && CRNValidation==1 && noticeValidation==1 && sectionValidation==1)
	{
	document.getElementById("noticedetails").submit();
	}
}