<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Messages</title>
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.7/css/jquery.dataTables.css" />
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script>
var xmlHttp;
xmlHttp = GetXmlHttpObject();


function accept1(r) {
    var query = "message="+r;
    xmlHttp.onreadystatechange = function stateChanged(){
        if(xmlHttp.readyState == 4){
        	document.getElementById("save_"+r).value = "Approved";
        	document.getElementById("save_"+r).disabled = true;
        	document.getElementById("decline_"+r).disabled = true;
        }
    };
    xmlHttp.open("POST","acceptRequest.htm",true);
    xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlHttp.send(query);
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
<form id="myForm" enctype="multipart/form-data">
	    <table border="1" id="displayMessage" cellspacing="0" width="100%">
			<thead>
            	<tr>
                	<td><b>From </b></td>
                	<td><b>Status</b></td>
                	<td></td>
           		</tr>
           	</thead>
           	
           	<tbody>
           	
	            <c:forEach var="message" items="${requestScope.messageList}">
	                <tr>
	                    <td>${message.fromaddress}</td>
	                    <td>${message.status}</td>
	                    <c:set var="message" value="${message}" scope="session" />
	                    <td><input type="Submit" value="Approve" id="save_${message.messageid}" onClick="return accept1('${message.messageid}');"/></td>
                 
	                </tr>
	            </c:forEach>
	        
            </tbody>
        </table>
        </form>
</body>
</html>