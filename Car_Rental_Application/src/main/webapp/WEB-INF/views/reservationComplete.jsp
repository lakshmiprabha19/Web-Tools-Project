<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Car Rental</title>
<style>
	#header{
		background-image:linear-gradient(to bottom, #000000, #6F4242);
		text-align:center;
		color: #FFFFFF;
		padding:5px;
		height:30px;
		width:1300px;
		margin: 0px;
	}
	#anchor{
		position: absolute;
		right:50px;
		color: white;
		background-color: black;
	}
	body{
		background-image: url("img/yellow-color.jpg");
	}
</style>
</head>
<body>
<div id="header">
    	<button id="anchor" onclick="location.href='logout.htm'" type="button">Logout</button>
	</div>
	<h2>Reservation Completed!!!!</h2>
	<button id="anchor" onclick="location.href='register.htm'" type="button">Go to home page</button>
</body>
</html>