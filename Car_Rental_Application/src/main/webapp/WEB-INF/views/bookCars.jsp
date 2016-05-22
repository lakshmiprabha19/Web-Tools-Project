<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Cars</title>
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.7/css/jquery.dataTables.css" />
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script>
   var xmlHttp;
   xmlHttp = GetXmlHttpObject();
   function selectRecord(id) {
       var url = "action=carbooking&carId="+id;
       xmlHttp.onreadystatechange = function stateChanged(){
           if(xmlHttp.readyState == 4){
               document.getElementById("proceed-"+id).value = "Selected";
               var x = document.getElementsByClassName("proceedButton");
               var i;
               for (i = 0; i < x.length; i++) {
                 x[i].disabled = "true";
               }
           }
       };
       xmlHttp.open("POST","selectCar.htm",true);
       xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
       xmlHttp.send(url);
       return false;            
   }
   
   function GetXmlHttpObject()
   {
       var xmlHttp = null;
       try
       {
           // Firefox, Opera 8.0+, Safari
           xmlHttp = new XMLHttpRequest();
       } catch (e)
       {
           // Internet Explorer
           try
           {
               xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
           } catch (e)
           {
               xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
           }
       }
       return xmlHttp;
   }
</script>
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

<%
  HttpSession session1 = request.getSession();
  if (session1.getAttribute("carObject") != null)
  {
%>
<h3>You have already selected a car!!</h3>
<%
  } else {
%>
<form:form action="showReservation.htm" method="post">
        <table border="1" id="display" cellspacing="0" width="100%">
        	<thead>
	            <tr>
	            	
	                <td><b>Car Name</b></td>
	                <td><b>Car Brand</b></td>
	                <td><b>Car Model</b></td>
	                <td><b>Color</b></td>
	                <td><b>Production year</b></td>
	                <td><b>Photo</b></td>
	                <td></td>
	            </tr>
	            </thead>
	            <tbody>
            <c:forEach var="car" items="${carList}">          
                <tr>
                    <td>${car.carName}</td>
                    <td>${car.carBrand}</td>
                    <td>${car.carModel}</td>
                    <td>${car.color}</td>
                    <td>${car.productionYear}</td>
                    <td><img height="150" width="150" src="${car.photoName}" /></td>
                    <td><input type="Submit" value="Choose" id="proceed-${car.carId}" class="proceedButton" onClick="return selectRecord('${car.carId}');"/></td>
                    <td><input type="hidden" name="carValue" value="${car.carId}"/></td>
                </tr>
            </c:forEach>
            <tr>            	
            	<td><input type="Submit" value="Proceed"/></td>
            </tr>
            </tbody>
            
        </table>
</form:form>
<%} %>
    </body>
</html>