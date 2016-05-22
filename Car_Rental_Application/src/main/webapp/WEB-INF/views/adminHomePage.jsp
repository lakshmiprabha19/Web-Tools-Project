<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home Page</title>
<link rel="stylesheet" href="css/myStyle.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<style>
	#header{
		background-image:linear-gradient(to bottom, #000000, #6F4242);
		text-align:center;
		color: #FFFFFF;
		padding:5px;
		height:30px;
		width:1340px;
		margin: 0px;
	}
	#anchor{
		position: absolute;
		right:50px;
		color: white;
		background-color: black;
	}
	#anchor1{
		position: absolute;
		right:300px;
		color: white;
		background-color: black;
	}
	#anchor2{
		position: absolute;
		right:150px;
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
      <button id="anchor1" onclick="location.href='getCars.htm'" type="button">Show List of Cars</button>
      <button id="anchor2" onclick="location.href='getMessages.htm'" type="button">View Messages</button>
    	<button id="anchor" onclick="location.href='logout.htm'" type="button">Logout</button>
	</div>
<div class="stand">
  <div class="outer-screen">
  
    <div class="inner-screen">
      <div class="form">
      <form:form action="addCar.htm" modelAttribute="car" method="post" enctype="multipart/form-data">
      <h2 style="position:absolute;left:350px">Add a Car</h2>
		<br/>
      <br/>
      <br/>
	      
	      <form:errors path="carName"/>
	      <form:errors path="carBrand"/>
	      <form:errors path="carModel"/>
	      <form:errors path="color"/>
	      <br/>
	        <form:input type="text" path="carName" class="zocial-dribbble" placeholder="Car Name" />
	        
	        <form:input type="text" path="carBrand" placeholder="Car Brand" />
	        
	        <form:input type="text" path="carModel" class="zocial-dribbble" placeholder="Car Model" />
	        
	        <form:input type="text" path="color" placeholder="Color" />
	        
	        <form:input type="text" path="productionYear" placeholder="Manufacture Year" />
	        <form:input path="photo" type="file" style="position:absolute;left:300px" placeholder="Select Photo (Max Size: 5MB)"/>
	        <br/>
	        <br/>
	        <input type="submit" value="Submit" />
	      </form:form>
      </div> 
    </div> 
  </div> 
</div>
    
    </body>
</html>