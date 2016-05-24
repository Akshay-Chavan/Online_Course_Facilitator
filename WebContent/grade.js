var courseId=0;
var CRN=0;
var grade=0;
var section = 0;
var kid = 0;

var courseValidation=0;
var CRNValidation=0;
var gradeValidation=0;
var sectionValidation=0;
var kidValidation=0;

function validateGrade(){
	
	 courseId=document.forms["gradeform"]["courseid"].value;
	 CRN=document.forms["gradeform"]["crn"].value;
	 grade=document.forms["gradeform"]["grade"].value;
	 section=document.forms["gradeform"]["section"].value;
	 kid=document.forms["gradeform"]["kid"].value;

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
	
	if(grade==null||grade=="")
	{
	document.getElementById("gradeError").innerHTML="Grade required";
	gradeValidation=0;
	}
	else
	{
	document.getElementById("gradeError").innerHTML="";
	gradeValidation=1;
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
	
	if(kid==null||kid=="")
	{
	document.getElementById("kidError").innerHTML="KID required";
	kidValidation=0;
	}
	else
	{
	document.getElementById("kidError").innerHTML="";
	kidValidation=1;
	}


	if(courseIdValidation==1 && CRNValidation==1 && gradeValidation==1 && sectionValidation==1 && kidValidation==1)
	{
	document.getElementById("gradedetails").submit();
	}
}