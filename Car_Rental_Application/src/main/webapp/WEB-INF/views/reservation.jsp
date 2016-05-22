<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/demo.css">
	<link rel="stylesheet" href="css/form-basic.css">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css"/>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
<script>
$(function() {
	$("#reservation_pickup").datepicker();
});

function myFunction(){
	var x = document.getElementById("hours");
	var regex = /^[1-9]$/;	
	if(!regex.test(x.value)){
		alert("Please enter valid hours");
		return false;
	}
	if((x.value)=="0"){
		alert("Please enter valid hours");
		return false;
	}
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
	body{
		background-image: url("img/yellow-color.jpg");
	}
	#anchor{
		position: absolute;
		right:50px;
	}
</style>
</head>
<body>
<div id="header">
    	<a id="anchor" href="logout.htm">Logout</a>
	</div>
	<h1>Car Reservation</h1>
	<c:set var="carItem" value="${requestScope.cars}"></c:set>
	
		<form:form action="bookReservation.htm" modelAttribute="reservation" method="post" class="form-basic">
	<div class="form-row">
                <label>
                    <span>Car Name:</span>
                    <c:out value="${carItem.carName}"></c:out>
                </label>
            </div>
	 <div class="form-row">
                <label>
                    <span>Car Brand:</span>
                    <c:out value="${carItem.carBrand}"></c:out>
                </label>
            </div>
	 <div class="form-row">
                <label>
                    <span>Car Model:</span>
                    <c:out value="${carItem.carModel}"></c:out>
                </label>
      </div>
      <div class="form-row">
         <label>
             <span>Car Color:</span>
             <c:out value="${carItem.color}"></c:out>
         </label>
     </div>
     <div class="form-row">
         <label>
             <span>Production Year:</span>
             <c:out value="${carItem.productionYear}"></c:out>
         </label>
     </div>
	 
	
	<div class="form-row">
         <label>
             <span>Pick Up Location</span>
             <form:select path="picklocation">
        	<form:option value="Prudential"/>
            <form:option value="Ruggles"/>
            <form:option value="Copley"/>
            <form:option value="Northeastern"/>
        </form:select>
         </label>
     </div>
		 <div class="form-row">
         <label>
             <span>Drop Off Location</span>
             <form:select path="droplocation">
        	<form:option value="Prudential"/>
            <form:option value="Ruggles"/>
            <form:option value="Copley"/>
            <form:option value="Northeastern"/>
        </form:select>
         </label>
     	</div>
     	<div class="form-row">
                <label>
                    <span>Date of Pickup</span>
                    <form:input path="pickupdate" id="reservation_pickup" type="text" placeholder="Date Of Pickup" />
                </label>
            </div>
            
            
            <div class="form-row">
                <label>
                    <span>Pickup Time</span>
                    <form:select path="pickuptime">
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
       			 <form:select path="pickuptimeName">
            		<form:option value="AM"/>
            		<form:option value="PM"/>
        		</form:select>
                </label>
            </div>
        <div class="form-row">
                <label>
                    <span>Required Hours</span>
                    <form:input path="hours" id="hours" type="text" placeholder="Required Hours" />
                </label>
            </div>
        <c:set var="carid" value="${carItem.carId}" scope="session"></c:set>
        <div class="form-row">
                <input type="submit" value="Submit" onClick="return myFunction();"/>
            </div>
        
	</form:form>
	
	
</body>
</html>