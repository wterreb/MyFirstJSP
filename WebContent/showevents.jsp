<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Events</title>
</head>
<body>

<jsp:useBean id="eboxdetails" scope= "session"  class="com.EboxDetailsBean">
  <jsp:setProperty name="eboxdetails" property="serialNum" value="0301234567"/>
  <jsp:setProperty name="eboxdetails" property="depot" value="TEST"/>
</jsp:useBean>



<%
    // SERIAL NUMBER
    String serialNum = request.getParameter("serial");
    if (serialNum == null) {
        out.println("Please supply serial number.  Example : serial=0301234567)");
    } else {
    	if (serialNum.length() != 10) {
    		out.println("Supplied serial (" + serialNum + ") is invalid length");
    	}
    	else {
    		eboxdetails.setSerialNum(serialNum);
    	}
    }
    
    // DEPOT
    String depotStr = request.getParameter("depot");
    if (depotStr != null) {
    	eboxdetails.setDepot(depotStr);
    } 
%>

<h6>DEPOT : ${eboxdetails.getDepot()   }</h6>
<h6>SERIAL : ${eboxdetails.getSerialNum() }</h6>



</body>
</html>