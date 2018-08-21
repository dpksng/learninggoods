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

	<title>Python :: Learninggoods.com</title>
	
</head>
  <body>
   
	<%@ include file ="header-default.jsp" %>
	
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-sm-2">
				<%@ include file ="side-menu.jsp" %>
			</div>
			<div class="col-sm-8 course-box">
				<h1 style="text-align:center;">Python Tutorial</h1>
				<br><br>
				<h4>CHAPTER 1</h4><br><br>
				<h5>Introduction</h5>
				<p>Python is a high-level, interpreted, interactive and object-oriented scripting language. Python is designed to be highly readable. It uses English keywords frequently where as other languages use punctuation, and it has fewer syntactical constructions than other languages.</p>
				<p>
				<br>
				<h5>History of Python</h5>
				<p>
				Python was developed by Guido van Rossum in the late eighties and early nineties at the National Research Institute for Mathematics and Computer Science in the Netherlands.
				</p>
				<p>
				Python is derived from many other languages, including ABC, Modula-3, C, C++, Algol-68, SmallTalk, and Unix shell and other scripting languages.
				</p>
				<p>
				Python is copyrighted. Like Perl, Python source code is now available under the GNU General Public License (GPL).
				</p>
				<p>
				Python is now maintained by a core development team at the institute, although Guido van Rossum still holds a vital role in directing its progress.
				</p><br>	
				<h5>Python Features</h5><br>
				<p>
				<b>Python's features include : </b>
				</p>
				<p>
				<b>Easy-to-learn -</b> Python has few keywords, simple structure, and a clearly defined syntax. This allows the student to pick up the language quickly.
				</p>
				<p>
				<b>Easy-to-read -</b> Python code is more clearly defined and visible to the eyes.
				</p>
				<p>
				<b>Easy-to-maintain -</b> Python's source code is fairly easy-to-maintain.
				</p>
				<p>
				<b>A broad standard library -</b> Python's bulk of the library is very portable and cross-platform compatible on UNIX, Windows, and Macintosh.
				</p>
				<p>
				<b>Interactive Mode -</b> Python has support for an interactive mode which allows interactive testing and debugging of snippets of code.
				</p>
				<p>
				<b>Portable -</b> Python can run on a wide variety of hardware platforms and has the same interface on all platforms.
				</p>
				<p>
				<b>Extendable -</b> You can add low-level modules to the Python interpreter. These modules enable programmers to add to or customize their tools to be more efficient.
				</p>
				<p>
				<b>Databases -</b> Python provides interfaces to all major commercial databases.
				</p>
				<p>
				<b>GUI Programming -</b> Python supports GUI applications that can be created and ported to many system calls, libraries and windows systems, such as Windows MFC, Macintosh, and the X Window system of Unix.
				</p>
				<p>
				<b>Scalable -</b> Python provides a better structure and support for large programs than shell scripting.
				</p>	
				<a href="/next" class="btn btn-outline-secondary">NEXT CHAPTER</a>			
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