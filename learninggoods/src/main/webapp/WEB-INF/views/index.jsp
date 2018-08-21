<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/home.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/accordion.css">
	
<title>Learninggoods.com :: It's not a rocket science</title>

</head>
	<body>
		<div class="bd">
			<nav class="navbar navbar-light navbar-toggleable-md">
				<div class="container home-mr">
					<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<a class="navbar-brand" href="/learninggoods"><img src="<%=request.getContextPath()%>/resources/img/logo.png" width="220" height="26"></a>

					<div class="collapse navbar-collapse menu" id="navbarSupportedContent">
						<ul class="navbar-nav ml-auto menu-nav">
							<li>
								<a href="/learninggoods" class="nav-link menu-link">Home</a>
							</li>
							<li>
								<a href="/learninggoods/about" class="nav-link menu-link">About</a>
							</li>
							<li>
								<a href="/learninggoods/contact" class="nav-link menu-link">Contact</a>
							</li>
						</ul>
					</div>
				</div>
			</nav>
	
			<div class="container">
				<div class="row">
					
					<div class="col-sm-6 hidden-xs-down">
						<div class="quote">
						<img src="<%=request.getContextPath()%>/resources/img/code.png" width="500px">
						</div>
					</div>
					
					<div class="col-sm-5 offset-md-1">
						<div id="accordion-btn">
							<div id="btn-l" class="btn-b">
								<a href="#" class="btn-l" onClick="loginToggle()">Login</a>
							</div>
							<div id="btn-r" class="btn-e">
								<a href="#" class="btn-r" onClick="registerToggle()">Register</a>
							</div>
						</div>
						<div id="accordion1">						
							<div class="accordion-panel">			
								<div class="section-login" id="login">
									<form action="performLogin" method="post">
										<div class="form-group">
											<label>Your email</label>
											<input type="email" name="email" class="form-control label" placeholder="Enter email">
										</div>
										<div class="form-group">
											<label>Your password</label>
											<input type="password" name="password" class="form-control label" placeholder="Password">
										</div>
										<button type="submit" class="btn cust-btn form-control label">LOGIN</button>
									</form>
									<a href="/learninggoods/forgot-password">Forgot Password?</a>
								</div>
							</div>
						</div>
						<div id="accordion2">
							<div class="accordion-panel">											
									<div class="section-reg" id="register">
									<form:form method="post" modelAttribute="user" action="performRegistration">
										<div class="form-group">
											<label>Choose a username</label>
											<form:input path="id" cssClass="form-control label" placeholder="Username"/>
										</div>
										<div class="form-group">
											<label>Your email</label>
											<form:input path="email" cssClass="form-control label" placeholder="Enter email"/>
										</div>
										<div class="form-group">
											<label>Choose a password</label>
											<form:password path="pwd" cssClass="form-control label" placeholder="Password"/>
										</div>
										<div class="form-group">
											<label>Confirm password</label>
											<form:password path="conf" cssClass="form-control label" placeholder="Password"/>
										</div>
										<button type="submit" class="btn cust-btn form-control label">REGISTER</button>
									</form:form>
								</div>
							</div>
						</div>
					</div>
				</div>
				<br><br>
			</div>
			
			<footer class="container">
				<div class="footer">
					<ul>
						<li>
							<a href="/learninggoods/disclaimer">Disclaimer</a>
						</li>
						<li>
							<a href="/learninggoods/terms">Terms</a>
						</li>
						<li>
							<a href="/learninggoods/privacy-policy">Privacy Policy</a>
						</li>
						<li>
							<a href="/learninggoods/contact">Contact</a>
						</li>
						<span class="cpr">© 2018 <a href="/learninggoods">LEARNINGGOODS.COM</a> | ALL RIGHTS RESERVED</span>
					</ul>
				</div>
			</footer>

		</div>
		
		<!--custom-->
		<script src="<%=request.getContextPath()%>/resources/js/home.js"></script>
		<!--/custom-->
		
		<!-- Optional JavaScript -->
		<!-- jQuery first, then Popper.js, then Bootstrap JS -->
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>
	</body>
</html>