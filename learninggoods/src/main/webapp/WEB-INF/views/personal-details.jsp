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

	<title>Register :: Learninggoods.com</title>
	
</head>
  <body>
   
	<%@ include file ="header.jsp" %>		
	
	<div class="container-fluid content">
		<br>
		<div class="row justify-content-center">
			<div class="col-sm-4 form-panel personal">
				<h1>Personal Details</h1>
				<div class="form-group">
					<form:form method="post" modelAttribute="user" action="completeRegistration">
						<div class="form-group">
							<label>Your Email</label>
							<form:input path="email" cssClass="form-control" Value="${email}"/>	
						</div>
						<div class="form-group">
							<label>Your name</label>
							<form:input path="name" cssClass="form-control" placeholder="Full name"/>	
						</div>
						<div class="form-group">
								<label>Gender</label>
								<form:select path = "gender" cssClass="form-control">
									<form:option value = "unknown" label = "Select"/>
									<form:options items="${gender}"/>
								</form:select>
						</div>
						<div class="form-group">
							<label>Date of birth</label>
							<form:input type="date" path="dob" class="form-control"/>
						</div>
						<div class="form-group">
								<label>Choose a security question</label>
								<form:select path = "question1" cssClass="form-control">
									<form:options items="${question1}"/>
								</form:select>
						</div>
						<div class="form-group">
								<label>Answer</label>
								<form:input path="answer1" cssClass="form-control" placeholder="Answer"/>
						</div>
						<div class="form-group">
								<label>Choose a security question</label>
								<form:select path = "question2" cssClass="form-control">
									<form:options items="${question2}"/>
								</form:select>
							</div>
							<div class="form-group">
								<label>Answer</label>
								<form:input path="answer2" cssClass="form-control" placeholder="Answer"/>
							</div>
						<button type="submit" class="btn cust-btn form-control label">CONFIRM</button>						
					</form:form>
				</div>
			</div>
		</div>
	</div>
	
	<%@ include file ="footer.jsp" %>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>