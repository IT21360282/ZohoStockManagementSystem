<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Styles.css">
</head>

<body style="font-family:Arial; background-color:#3385ff;">
	<div class="header">
		<h1 style="margin-left:20px;"><font size="60px"><i>ZOHO</i></font><br>
		Stock Management System</h1>
		<hr>
		<h3 style="margin-left:20px;">Purchasing Manager</h3>
	</div>

<div class="BodyDivTable" style="margin:auto;margin-top:2cm;width:80%;">

	
<%String Condition = (String)request.getAttribute("condition");%>
<%String button = (String)request.getAttribute("button");%>

 	<h5><%=Condition %></h5>
	<%=button %>
	<br>
<br></div>
</body>
</html>