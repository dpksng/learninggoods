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
	<link href="https://fonts.googleapis.com/css?family=Bitter" rel="stylesheet">

	<title>Reply :: Learninggoods.com</title>
	
</head>
  <body>
   
	<%@ include file ="header-default.jsp" %>
	
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-sm-2">
				<%@ include file ="side-menu.jsp" %>
			</div>
			<div class="col-sm-8">
					<div class="row">
						<div class="col-sm-12">
							<div class="forum-title">
								<div class="mini-left">
								<blockquote style="font-size:24px; color:#FFFFFF;font-family:arial black;">Ask It</blockquote>
								</div>
							</div>
							<div class="mini-box">
									<img src="<%=request.getContextPath()%>/resources/img/query.png" width="50px">
									<blockqoute style="font-size:22px;">${posted.title}</blockqoute><br><br>
									<p>${posted.desc}</p>
								
								<div class="mini-footer">
									<div class="mini-right">
										Posted by ${posted.puser}
									</div>
								</div>
								<br><br>
							</div>
							
							<c:forEach var="replied" items="${list}">
							<div class="mini-box">
									<img src="<%=request.getContextPath()%>/resources/img/answer.png" width="50px"><br><br>
									<p>${replied.reply}</p>
								
								<div class="mini-footer">
									<div class="mini-right">
										Posted by ${replied.ruser}
									</div>
								</div>
								<br><br>
							</div>
							</c:forEach>
							
						</div>
					</div>
			
			</div>
		</div>
	</div>
	<br><br><br>
	<%@ include file ="footer-default.jsp" %>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>