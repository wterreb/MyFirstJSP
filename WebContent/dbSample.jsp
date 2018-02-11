<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Database access sample</title>
</head>
<body>

	<jsp:useBean id="credentials"  class="com.CredentialsBean" scope= "session">
 	<jsp:setProperty name="credentials" property="username" value="dummyusername"/>  
    <jsp:setProperty name="credentials" property="password" value="dummypassword"/>  
    </jsp:useBean>
    
    <jsp:useBean id="dbsample"  class="com.DbSample" scope= "session">

    </jsp:useBean>
    
    <% 
	     String uname = credentials.getUsername();
	     String pword = credentials.getPassword();
	    // out.println("Username is <b>" + uname + "</b>    password is <b>" + pword + "</b>" );
	     
	     if ( (uname != null) && (pword != null) ) {
	    	 dbsample.setUsername(uname);
	    	 dbsample.setPassword(pword);
	     }
	     dbsample.setSerialnum("0312345678");
	     out.println("Organization = <b>" + dbsample.getOrganization() + "</b>");
	%>
	
	uname=<%= credentials.getUsername() %> and  uname=<%= credentials.getPassword() %> 
	
</body>
</html>