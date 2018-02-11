<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>button</title>
</head>
<body>




	<FORM NAME="form1" METHOD="POST">
	       <INPUT TYPE="HIDDEN" NAME="buttonName">
	       <INPUT TYPE="BUTTON" VALUE="Button 1" ONCLICK="button1()">
	       
	</FORM>
	
	<% 
	     out.println("Hello <b>" + session.getAttribute("status") + "</b>!");
	     if(request.getParameter("buttonName") != null) {
	        session.setAttribute("status", "guest");
	        out.println(request.getParameter("buttonName"));
	     }
	     
	%>
	
	<SCRIPT LANGUAGE="JavaScript">
	    function button1()
	    {
	        document.form1.buttonName.value = "yes";
	        
	        form1.submit();
	    } 
	</SCRIPT>
	
	 

</body>
</html>