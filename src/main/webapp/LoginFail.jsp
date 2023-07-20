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
	<%
 	String value = (String)request.getAttribute("value");
 	%>

	 <h4><%=value %></h4>
	</div>
</body>
</html>