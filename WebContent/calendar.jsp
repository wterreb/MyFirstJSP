<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">

.main {
width:200px;
border:1px solid black;
}

.month {
background-color:black;
font:bold 12px verdana;
color:white;
}

.daysofweek {
background-color:gray;
font:bold 12px verdana;
color:white;
}

.days {
font-size: 12px;
font-family:verdana;
color:black;
background-color: lightyellow;
padding: 2px;
}

.days #today{
font-weight: bold;
color: red;
}

</style>

</head>
<body>

<select onChange="updatecalendar(this.options)">
<script type="text/javascript">

var themonths=['January','February','March','April','May','June',
'July','August','September','October','November','December']

var todaydate=new Date()
var curmonth=todaydate.getMonth()+1 //get current month (1-12)
var curyear=todaydate.getFullYear() //get current year

function updatecalendar(theselection){
var themonth=parseInt(theselection[theselection.selectedIndex].value)+1
var calendarstr=buildCal(themonth, curyear, "main", "month", "daysofweek", "days", 0)
if (document.getElementById)
document.getElementById("calendarspace").innerHTML=calendarstr
}

document.write('<option value="'+(curmonth-1)+'" selected="yes">Current Month</option>')
for (i=0; i<12; i++) //display option for 12 months of the year
document.write('<option value="'+i+'">'+themonths[i]+' '+curyear+'</option>')


</script>
</select>

<script type="text/javascript" src="basiccalendar.js"></script>

<div id="calendarspace">
<script>
//write out current month's calendar to start
document.write(buildCal(curmonth, curyear, "main", "month", "daysofweek", "days", 0))
</script>
</div>




</body>
</html>