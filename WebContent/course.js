var courseId=0;
var courseName=0;

var courseValidation=0;
var cnValidation=0;

function validateAddCourse(){
	
	 courseId=document.forms["courseform"]["courseid"].value;
	 courseName=document.forms["courseform"]["coursename"].value;
	 
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

	if(courseName==null||courseName=="")
	{
	document.getElementById("cnError").innerHTML="Course Name required";
	cnValidation=0;
	}
	else
	{
	document.getElementById("cnError").innerHTML="";
	cnValidation=1;
	}
	

	if(courseIdValidation==1 && cnValidation==1)
	{
	document.getElementById("coursedetails").submit();
	}
}

function validateRemoveCourse(){
	
	 courseId=document.forms["courseform"]["courseid"].value;
	 
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

	if(courseIdValidation==1)
	{
	document.getElementById("coursedetails").submit();
	}
}