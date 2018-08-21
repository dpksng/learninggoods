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

	<title>Java Test :: Learninggoods.com</title>
	
</head>
  <body>
   
	<%@ include file ="header-default.jsp" %>
	
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-sm-2">
				<%@ include file ="side-menu.jsp" %>
			</div>
			<div class="col-sm-8 course-box">
			<h1 style="text-align:center; margin-top:30px;"> Test your ${lang} skills</h1>
				<br><br>
				<form method="post" action="/learninggoods/submitTest/${ans}">
				 <fieldset class="form-group row">
				 <c:set var="i" value="0"/>
				 <c:forEach var="test" items="${list}">
				 <c:set var="i" value="${1+i}"/>
				 <div class="test">
				  <legend class="col-form-legend"><strong>${test.question}</strong></legend>
				  	<div class="form-check">
					  <label class="form-check-label">
						<input class="form-check-input" type="radio" name="question${i}" id="question${i}" value="sdfsdfsdfsadd" hidden checked>		
					  </label>
					</div>
					<div class="form-check">
					  <label class="form-check-label">
						<input class="form-check-input" type="radio" name="question${i}" id="question${i}" value="${test.option1}">
						${test.option1}		
					  </label>
					</div>
					<div class="form-check">
					  <label class="form-check-label">
						<input class="form-check-input" type="radio" name="question${i}" id="question${i}" value="${test.option2}">
						${test.option2}
					  </label>
					</div>
					<div class="form-check">
					  <label class="form-check-label">
						<input class="form-check-input" type="radio" name="question${i}" id="question${i}" value="${test.option3}">
						${test.option3}
					  </label>
					</div>
					<div class="form-check">
					  <label class="form-check-label">
						<input class="form-check-input" type="radio" name="question${i}" id="question${i}" value="${test.option4}">
						${test.option4}
					  </label>
					</div>
				</div>
				<br>
				</c:forEach>
				</fieldset>
				<div class="test">
				<input type="submit" value="SUBMIT" class="btn btn-success">
				</div>
				</form>
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