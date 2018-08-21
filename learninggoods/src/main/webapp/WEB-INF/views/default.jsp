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

	<title>Home :: Learninggoods.com</title>
	
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
								<div class="mini-right">
									
									<button class="btn btn-warning" data-toggle="modal" data-target="#modalCenterPost">POST</button>
												<div class="modal fade" id="modalCenterPost" tabindex="-1" role="dialog" aria-labelledby="reply" aria-hidden="true">
												  <div class="modal-dialog modal-dialog-centered" role="document">
												    <div class="modal-content">
												      <div class="modal-header">
												        <h5 class="modal-title" id="modalLongTitle">Ask It</h5>
												        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
												          <span aria-hidden="true">&times;</span>
												        </button>
												      </div>
												      <div class="modal-body">
												        <form action="postQuery/${su.email}" method="post">
															<div class="form-group">
															    <label>Title</label>
															    <input type="text" name="title" class="form-control">
															</div>
															<div class="form-group">
															    <label>Describe your query here..</label>
															    <textarea class="form-control" name="query" rows="4"></textarea>
															</div>
															<input type="submit" class="btn cust-btn" value="POST">
														</form>
												      </div>
												    </div>
												  </div>
												</div>
												
								</div>
							</div>
							<c:forEach var="posted" items="${list}">
							<div class="mini-box">
								
									<img src="<%=request.getContextPath()%>/resources/img/query.png" width="50px">
									<blockqoute style="font-size:22px;">${posted.title}</blockqoute><br><br>
									<p>${posted.desc}</p>
								
								<div class="mini-footer">
								<button class="btn cust-btn" data-toggle="modal" data-target="#modalCenter${posted.number}">REPLY</button>
												<div class="modal fade" id="modalCenter${posted.number}" tabindex="-1" role="dialog" aria-labelledby="reply" aria-hidden="true">
												  <div class="modal-dialog modal-dialog-centered" role="document">
												    <div class="modal-content">
												      <div class="modal-header">
												        <h5 class="modal-title" id="modalLongTitle">Reply</h5>
												        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
												          <span aria-hidden="true">&times;</span>
												        </button>
												      </div>
												      <div class="modal-body">
												        <form action="reply/${su.email}/${posted.number}" method="post">
															<div class="form-group">
															    <textarea class="form-control" name="answer" rows="4"></textarea>
															</div>
															<input type="submit" class="btn cust-btn" value="POST">
														</form>
												      </div>
												    </div>
												  </div>
												</div>
								<a href="/learninggoods/answers/${posted.number}" class="btn btn-outline-danger">CHECK ANSWERS</a>
								<div class="mini-right">
									Posted by ${posted.puser}
								</div>
								</div>
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