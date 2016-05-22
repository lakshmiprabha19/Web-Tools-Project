<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="css/style.css">
<script>
	javascript:window.history.forward(1);
</script>
</head>
<body>


<body class="align">
<div>
<h2 style="color:yellow">Online Car Rental Application</h2>
<div>
<img src="img/image1.jpg" height="400" width="600"/>
</div></div>
<br/>
<br/>
  <div class="site__container">
    <div class="grid__container">
    	<c:out value="${requestScope.msg }"></c:out>
      <form:form action="login.htm" modelAttribute="user" method="post" class="form form--login" >
        <div class="form__field">
          <label class="fontawesome-user" for="login__username"><span class="hidden">Username</span></label>
          <form:input path="username" id="login__username" type="text" class="form__input" placeholder="Username" value="${cookie.userName.value}" />
          <form:errors path="username"/>
        </div>
        <div class="form__field">
          <label class="fontawesome-lock" for="login__password"><span class="hidden">Password</span></label>
          <form:input path="password" id="login__password" type="password" class="form__input" placeholder="Password" value="${cookie.password.value}"/>
          <form:errors path="password"/>
        </div>
       
          <input type='checkbox' name='rememberMe' id="login__username" class="form__input" value='rememberMe' /> Remember Me
		<br/>
        <div class="form__field">
          <input type="submit" value="Sign In">
        </div>
      </form:form>

      <p class="text--center">Not a member? <a href="signUp.htm">Sign up now</a> <span class="fontawesome-arrow-right"></span></p>

    </div>

  </div>

</body>

</body>
</html>