<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	body{
		background-image: url("img/yellow-color.jpg");
	}
	#anchor{
		position: absolute;
		right:50px;
		color: white;
		background-color: black;
	}
</style>
</head>
<body>
<div id="header">
    	<button id="anchor" onclick="location.href='logout.htm'" type="button">Logout</button>
	</div>
<h1><c:out value="${requestScope.msg}"></c:out></h1>
<h2>Your transaction details:</h2>
<h3>Hours Used: <c:out value="${sessionScope.hours}"></c:out></h3> 

<h3>Rate per hr : 5$</h3> 

<h3>Amount: <c:out value="${sessionScope.amount}"></c:out></h3>
<h3>Tax: 12.5%</h3>
<h3>Total Amount: <c:out value="${sessionScope.totalAmount}">$</c:out></h3>

<form:form action="createTransaction.htm" modelAttribute="transaction" method="post">
	<input type="Submit" value="Proceed" />
</form:form>

</body>
</html>