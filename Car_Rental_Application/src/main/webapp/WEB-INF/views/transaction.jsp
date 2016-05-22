<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Online Car Rental</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
​
<meta name="keywords" content="Multi Column Footer template Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login sign up Responsive web template, SmartPhone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />

  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
      <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<!--//web font-->

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
<script>
function myFunction(){
	var card = document.getElementById("cardNumber");
	var mon = document.getElementById("expMonth");
	var year = document.getElementById("expYear");
	var cvv = document.getElementById("cvCode");
	var regex = /^\s*-?[0-9]{1,16}\s*$/;	
	if(!regex.test(card.value)){
		alert("Please enter valid Card Number");
		return false;
	}
	if((card.value)=="0"){
		alert("Please enter valid Card Number");
		return false;
	}
	if(!regex.test(mon.value)){
		alert("Please enter valid Expiry Month");
		return false;
	}
	if((mon.value)=="0"){
		alert("Please enter valid Expiry Month");
		return false;
	}
	if(!regex.test(year.value)){
		alert("Please enter valid Expiry Year");
		return false;
	}
	if((year.value)=="0"){
		alert("Please enter valid Expiry Year");
		return false;
	}
	if(!regex.test(cvv.value)){
		alert("Please enter valid Cvv");
		return false;
	}
	if((cvv.value)=="0"){
		alert("Please enter valid Cvv");
		return false;
	}
}
</script>
</head>
<body>
<div id="header">
    	<a id="anchor" href="logout.htm">Logout</a>
	</div>
    <!-- main -->
    <div class="main">
        <h1>Book Car</h1>
        <div class="main-row">
            
            <div class="container">
    <div class="row">
      <div class="col-xs-12 col-md-4">
​
      </div>
        <div class="col-xs-12 col-md-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><img class="pull-right" src="http://i76.imgup.net/accepted_c22e0.png">Payment Details</h3>
                </div>
                <div class="panel-body">
                	<form:form action="saveTransaction.htm" modelAttribute="transaction" method="post" id="payment-form">
                       
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="form-group">
                                    <label for="cardNumber">CARD NUMBER</label>
                                    <div class="input-group">
                                    	<form:input type="text" path="cardnumber" class="form-control" id="cardNumber" name="cardNumber" placeholder="Valid Card Number" maxlength="16" />
                                        <span class="input-group-addon"><i class="fa fa-credit-card"></i></span>
                                    </div>
                                </div>                            
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-7 col-md-7">
                                <div class="form-group">
                                    <label for="expMonth">EXPIRATION DATE</label>
                                    <div class="col-xs-6 col-lg-6 pl-ziro">
                                    
										<form:input type="text" path="expirymonth" class="form-control" id="expMonth" name="expMonth" placeholder="MM" maxlength="2" />                      
                                    </div>
                                    <div class="col-xs-6 col-lg-6 pl-ziro">
                                    	<form:input type="text" path="expiryYear" class="form-control" id="expYear" name="expYear" placeholder="YY" maxlength="2" />
                                    </div>
                                </div>
                            </div>
                            <div class="col-xs-5 col-md-5 pull-right">
                                <div class="form-group">
                                    <label for="cvCode">CVV</label>
                                    <form:input type="password" path="cvv" class="form-control" id="cvCode" name="cvCode" placeholder="CV" maxlength="3" />
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="form-group">
                                    <label for="transaction amount">Transaction Amount</label>
                                    <form:input type="text" path="transactionAmount" value="${sessionScope.totalAmount}" class="form-control" readonly="true"/>
                                </div>
                            </div>                        
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <button class="btn btn-success btn-lg btn-block" onClick="return myFunction();" type="submit">Make Payment</button>
                            </div>
                        </div>
                        <div class="row" style="display:none;">
                            <div class="col-xs-12">
                                <p class="payment-errors"></p>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
​
            <div class="clear"> </div>
        </div>  
    </div>  
    <!--//main -->
    <!--copyright-->
    
    <!--//copyright-->
</body>
</html>