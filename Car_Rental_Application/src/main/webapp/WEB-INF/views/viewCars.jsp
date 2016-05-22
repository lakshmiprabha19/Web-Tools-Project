<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Cars</title>
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.7/css/jquery.dataTables.css" />
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.11/js/dataTables.jqueryui.min.js"></script>
<script src="https://cdn.datatables.net/1.10.11/css/dataTables.jqueryui.min.css"></script>
<script>
$(document).ready(function() {
    $('#display').DataTable();
} );
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
        <table border="1" id="display" cellspacing="0" width="100%">
        	<thead>
	            <tr>
	                <td><b>Car Name</b></td>
	                <td><b>Car Brand</b></td>
	                <td><b>Car Model</b></td>
	                <td><b>Color</b></td>
	                <td><b>Production year</b></td>
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
                </tr>                
            </c:forEach>
            </tbody>
        </table>
    </body>
</html>