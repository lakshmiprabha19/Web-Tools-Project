<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Car Rental</title>
<link rel="stylesheet" href="css/demo.css">
<link rel="stylesheet" href="css/form-basic.css">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
<script>
$(function() {
	$("#reservation_drop").datepicker();
});

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
	}
	body{
		background-image: url("img/yellow-color.jpg");
	}
</style>
</head>
<body>
<div id="header">
    	<a id="anchor" href="logout.htm">Logout</a>
	</div>
	<c:set var="reserve" value="${requestScope.reser}"></c:set>
	<c:set var="car" value="${requestScope.carReservation}"></c:set>	
	<c:choose>
	<c:when test="${!empty requestScope.errormsg}">
		<c:out value="${requestScope.errormsg}"></c:out>
	</c:when>
	<c:otherwise>
		<form:form action="dropCarReservation.htm" modelAttribute="reservation" method="post" class="form-basic">
		<div class="form-row">
                <label>
                    <span>Car Name:</span>
                    <c:out value="${car.carName}"></c:out>
                </label>
            </div>
            <div class="form-row">
                <label>
                    <span>Car Brand:</span>
                    <c:out value="${car.carBrand}"></c:out>
                </label>
            </div>
            <div class="form-row">
                <label>
                    <span>Car PickUp Time:</span>
                    <c:out value="${reserve.pickuptime}${reserve.pickuptimeName}"></c:out>
                </label>
            </div>
            <div class="form-row">
                <label>
                    <span>Car PickUp date:</span>
                    <c:out value="${reserve.pickupdate}"></c:out>
                </label>
            </div>
            <div class="form-row">
                <label>
                    <span>Car Drop Date:</span>
                    <form:input path="dropdate" value="${reserve.pickupdate}" type="text" placeholder="Date Of Pickup" readonly="true"/>
                </label>
            </div>
            <div class="form-row">
                <label>
                    <span>Car Drop Time</span>
                    <form:select path="droptime">
					            <form:option value="1"/>
					            <form:option value="2"/>
					            <form:option value="3"/>
					            <form:option value="4"/>
					            <form:option value="5"/>
					            <form:option value="6"/>
					            <form:option value="7"/>
					            <form:option value="8"/>
					            <form:option value="9"/>
					            <form:option value="10"/>
					            <form:option value="11"/>
					            <form:option value="12"/>
					        </form:select>
					        <form:select path="droptimeName">
					            <form:option value="AM"/>
					            <form:option value="PM"/>
					        </form:select>
                </label>
            </div>
            <c:set var="r_id" value="${reserve.reservationId}" scope="session"></c:set>
            <div class="form-row">
                <input type="Submit" value="Proceed"/>
            </div>
					
		         
		 </form:form>
	</c:otherwise>
	</c:choose>		
</body>
</html>