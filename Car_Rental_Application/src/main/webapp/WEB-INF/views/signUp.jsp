<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name = "viewport" content = "width = device-width, initial-scale = 1.0">
<title>Sign Up</title>

<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css"/>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
<script src="js/myScript.js"></script>
<script>
$(function() {
	$("#login__username1").datepicker();
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
		color: white;
		background-color: black;
	}
</style>
</head>
<body>
	<div id="header">
    	<button id="anchor" onclick="location.href='login.htm'" type="button">Login</button>
	</div>	
  <div class="site__container">
    <div class="grid__container">
      <form:form action="signUp.htm" modelAttribute="user" method="post" class="form form--login">
      <c:out value="${user1}"></c:out>
      <br/>
      <form:errors path="firstName"/>
      <br/>
      <form:errors path="lastName"/>
      <br/>
      <form:errors path="username"/>
      <br/>
      <form:errors path="password"/>
      <br/>
      
      <div class="form__field">
          <label class="fontawesome-user" for="login__firstname"><span class="hidden">First Name</span></label>
          <form:input path="firstName" id="login__username" type="text" class="form__input" placeholder="First Name" />         
        </div>
        <div class="form__field">
          <label class="fontawesome-user" for="login__lastname"><span class="hidden">Last Name</span></label>
          <form:input path="lastName" id="login__username" type="text" class="form__input" placeholder="Last Name" />
          
        </div>
        <div class="form__field">
          <label class="fontawesome-user" for="login__dob"><span class="hidden">Date of Birth</span></label>
          <form:input path="dob" id="login__username1" type="text" class="form__input" placeholder="Date Of Birth" />
          
        </div>
        <div class="form__field">
          <label class="fontawesome-user" for="login__username"><span class="hidden">Username</span></label>
          <form:input path="username" id="login__username" type="text" class="form__input" placeholder="Username" />
          
        </div>
        <div class="form__field">
          <label class="fontawesome-lock" for="login__password"><span class="hidden">Password</span></label>
          <form:input path="password" id="login__password" type="password" class="form__input" placeholder="Password" />
          
        </div>
        <div class="form__field">
          <input type="submit" value="Register">
        </div>
      </form:form>	

    </div>

  </div>

</body>
</html>