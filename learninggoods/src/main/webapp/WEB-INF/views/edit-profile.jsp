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

	<title>Profile :: Learninggoods.com</title>
	
</head>
  <body>
   
	<%@ include file ="header-default.jsp" %>
	
	<div class="container content">
		<br><br>
		<h1 style="text-align:center;">Edit Profile</h1>
		<br><br>
		<div class="row justify-content-center">
			<c:set var="edit" value="${edit}"/>
			<div class="col-sm-3">
				<div class="profile">
					<div class="avtar">
						<img src="<%=request.getContextPath()%>/resources/img/avtar/${profile}.png" width="100%">
					</div>
					<div class="info">
						<h4>${edit.name}</h4><br>
						<h5>${edit.gender}</h5><br>
						<h5>${edit.email}</h5>
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<form:form method="post" modelAttribute="getUser" action="updateProfile">
						<div class="form-group">
							<label>Name</label>
							<form:input path="name" cssClass="form-control" value="${edit.name}"/>
						</div>
						<div class="form-group">
							<label>Email</label>
							<form:input path="email" cssClass="form-control" value="${edit.email}"/>
						</div>
						<div class="form-group">
							<label>Gender</label>
							<form:input path="gender" cssClass="form-control label" value="${edit.gender}"/>
						</div>
						<div class="form-group">
							<label>Date of birth</label>
							<form:input path="dob" cssClass="form-control" type="date" value="${edit.dob}"/>
						</div>
						<button type="submit" class="btn cust-btn form-control label">CONFIRM</button>						
					</form:form>	
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