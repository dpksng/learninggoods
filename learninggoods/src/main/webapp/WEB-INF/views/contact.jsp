<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css" type="text/css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" type="text/css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/font-awesome.css" type="text/css"> 
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/animate.css" type="text/css">

	<title>Contact :: Learninggoods.com</title>
	
</head>
  <body>
   
	<%@ include file ="header-default.jsp" %>
	
		<div class="container content">
		<div class="row justify-content-center">
			<div class="col-sm-6 form-panel">
				<h1>Contact Us</h1>
				<div class="form-group">
					<form:form method="post" modelAttribute="feed" action="sendContact">
						<div class="form-group">
							<label>Your email</label>
							<form:input path="email" cssClass="form-control" placeholder="abc@email.com"/>
						</div>
						<div class="form-group">
							<label>Message</label>
							<form:textarea path="feedback" cssClass="form-control" rows="4" placeholder="Feedback"/>
						</div>
						<button type="submit" class="btn cust-btn form-control label">SEND</button>						
					</form:form>
				</div>
			</div>
			<div class="col-sm-5 form-panel">
				<h1>Contact Details</h1>
				<div class="form-group">
				<h4>Email :</h4>
				<h5 style="font-size:16px;">contact@learninggoods.com</h5>
				<h5 style="font-size:16px;">support@learninggoods.com</h5>
				<h5 style="font-size:16px;">feedback@learninggoods.com</h5>
				</div>
			</div>
		</div>
	</div>

	<%@ include file ="footer-default.jsp" %>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>