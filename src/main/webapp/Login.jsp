<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="Styles.css">
<title>Stock Management System - Login</title>
</head>
<body style="font-family:Arial; background-color:#3385ff;">
	<div class="header">
	<h1 style="margin-left:20px;"><font size="60px"><i>ZOHO</i></font><br>
	Stock Management System</h1>
	<hr>
	<h3 style="margin-left:20px;"> Admin Login</h3>
	
	</div>
	<div class="BodyDiv">
	<br><h2><span style="color:orange;">Login</span> Here</h2><br>
	<form method="post" action="LoginServlet">
		User Name:  
		<input class="LoginBox" type="text" name="As"><br><br>
   		Password:&nbsp&nbsp  <input class="LoginBox" type="password" name="pass">
   		<br><br>
   		<input class="LogButton" type="submit" name="button" value="LOGIN">
   		<br><br><br>
	</form>
	</div>
</body>
</html>