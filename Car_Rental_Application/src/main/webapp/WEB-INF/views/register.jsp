<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.neu.myapplication.dao.MessageDAO" %>
<%@ page import="com.neu.myapplication.pojo.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Car Rental</title>
<script type="text/javascript">
	function myFunction(){
		document.getElementById("button1").disabled="true";
	}
</script>
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
<body >

    <div id="header">
    	<button id="anchor" onclick="location.href='logout.htm'" type="button">Logout</button>
	</div>
	<h2>Welcome ${user.username}</h2>
	<%
		User u = (User)session.getAttribute("user");
		String status=null;
		MessageDAO mess = new MessageDAO();
		int r = mess.checkMessage(u);
		if(r == 1){
			status = mess.getStatus(u);
		}
		else if(r==2){
			status= null;
		}
	%>
	<% if ((status != null) && (status.equals("approved"))){ %>
			<table>
	             <tr>
	             <td colspan="2" class="form__field"><a href="bookCar.htm">Click here to book the Car</a></td>
	             </tr>
	             <tr>
	             <td colspan="2" class="form__field"><a href="dropCar.htm">Click here to drop off the car</a></td>
	             </tr>
			 </table>
		<%}else if ((status != null) && (status.equals("sent"))) { %>	
				<h2>Your request is waiting admin approval</h2>
			<%} else { %>	
				<c:out value="${requestScope.errormsg}"></c:out>
			<h2><c:out value="${requestScope.messageSent}"></c:out></h2>
			
			Request for a card:
			
			      <form:form action="sendRequest.htm" method="post">
			
			         <table>		
			             <tr>
			                 <td colspan="2" class="form__field"><input type="submit" value="REQUEST ZIP CARD" /></td>
			             </tr>
			             </table>
			             </form:form>
		<%} %>
</body>
</html>