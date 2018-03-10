<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Login Results</title>
</head>
<body>
	<jsp:useBean id="login"  class="com.LoginBean" scope= "session"> 
    </jsp:useBean>

	<% 
	// Get parameters from Login request
	String uname = request.getParameter("username");
	String pword = request.getParameter("password");	
	%>
	

	
	<%
	 if ( uname != null ) {
	    	 login.setUsername(uname);
	    	 login.setPassword(pword);
	    	 login.lookup();
	 }
	%>
	
	username = <%= login.getUsername() %><br>
	password = <%= login.getPassword() %><br>
	first name = <%= login.getFirstname() %><br>
	last name = <%= login.getLastname() %><br>
	email = <%= login.getEmail() %><br>
	isAdmin = <%= login.getIsAdmin() %><br>
	

</body>
</html>