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
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/admin.css" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Lato:400,900" rel="stylesheet">
	
	<title>Manage Tests :: Admin | LEARNINGGOODS.COM</title>

</head>
 <body onload="startTime()">
	
	<div class="admin-dashboard">
		<div class="container-fluid">
		<div class="admin-reg">
				<div class="row">
					<div class="col-md-3">
						<%@ include file ="admin-profile.jsp" %>
					</div>
					<div class="col-md-9">
						<div class="row">
							<div class="col-md-12">
								<nav class="navbar navbar-light navbar-toggleable">							
									<a class="navbar-brand" href="#">Tests</a>
									<div class="collapse navbar-collapse menu" id="navbarSupportedContent">
										<ul class="navbar-nav ml-auto menu-nav">
											<li>
												<a href="#" class="nav-link menu-link" data-toggle="modal" data-target="#modalCenter">ADD TEST</a>
												<div class="modal fade" id="modalCenter" tabindex="-1" role="dialog" aria-labelledby="AddTest" aria-hidden="true">
												  <div class="modal-dialog modal-dialog-centered" role="document">
												    <div class="modal-content">
												      <div class="modal-header">
												        <h5 class="modal-title" id="modalLongTitle">Add Test</h5>
												        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
												          <span aria-hidden="true">&times;</span>
												        </button>
												      </div>
												      <div class="modal-body">
												        <form:form method="post" modelAttribute="test" action="addTest">
															<div class="row">
																<div class="col-sm-12">
																	<div class="form-group">
																			<label>Category</label>
																			<form:select path="id" cssClass="form-control">
																				<form:options items="${s1}"/>
																			</form:select>
																	</div>
																</div>
																<div class="col-sm-12">
																	<div class="form-group">
																		<label>Question</label>
																		<form:input path="question" cssClass="form-control"/>
																	</div>
																</div>
																<div class="col-sm-12">
																	<div class="form-group">
																		<label>Answer</label>
																		<form:input path="answer" cssClass="form-control"/>
																	</div>
																</div>
																<div class="col-sm-12">
																	<div class="form-group">
																		<label>Option 1</label>
																		<form:input path="option1" cssClass="form-control"/>
																	</div>
																</div>
																<div class="col-sm-12">
																	<div class="form-group">
																		<label>Option 2</label>
																		<form:input path="option2" cssClass="form-control"/>
																	</div>
																</div>
																<div class="col-sm-12">
																	<div class="form-group">
																		<label>Option 3</label>
																		<form:input path="option3" cssClass="form-control"/>
																	</div>
																</div>
																<div class="col-sm-12">
																	<div class="form-group">
																		<label>Option 4</label>
																		<form:input path="option4" cssClass="form-control"/>
																	</div>
																</div>
																<div class="col-sm-12">
																	<button type="submit" class="btn btn-primary form-control label">ADD</button>
																</div>
															</div>
															</form:form>
												      </div>
												    </div>
												  </div>
												</div>
											</li>
											<li>
												<a href="/learninggoods/admin" class="nav-link menu-link">GO BACK</a>
											</li>
											<%@ include file ="menu.jsp" %>		
										</ul>
									</div>
								</nav>
							</div>
							<div class="col-md-12">
								<table class="table">
							<thead>
							  <tr>
								<th>NO</th>
								<th>Test</th>
								<th>QUSETION</th>
								<th>ANSWER</th>
								<th>UPDATE</th>
								<th>DELETE</th>
							  </tr>
							</thead>
							<tbody>
							  <c:forEach var="t1" items="${list}">      
								  <tr>
								<form:form method="post" modelAttribute="test" action="updateTest">
								  	<td><form:input path="number" cssClass="form-control" value="${t1.number}"/></td>
								  	<td><form:input path="id" cssClass="form-control" value="${t1.id}"/></td>
								  	<td><form:input path="question" cssClass="form-control" value="${t1.question}"/></td>
								  	<td><form:input path="answer" cssClass="form-control" value="${t1.answer}"/></td>
									<td><input type="submit" class="btn btn-success" value="UPDATE"></td>
									<td><a href="/learninggoods/admin/deleteTest/${t1.number}" class="btn btn-danger">DELETE</a></td>
								</form:form>
									</tr>
								 </c:forEach>
							</tbody>
						  </table>
							</div>
						</div>
					</div>							
				</div>
			</div>
		</div>
	</div>
	
	<!-- My JavaScript -->
	<script src="<%=request.getContextPath()%>/resources/js/admin.js"></script>
	<!-- /My JavaScript -->
	
	
	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>