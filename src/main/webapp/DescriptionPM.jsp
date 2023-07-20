<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="Styles.css">
<title>Purchasing Manager</title>
</head>
<body style="font-family:Arial; background-color:#3385ff;">
	<div class="header">
	<h1 style="margin-left:20px;"><font size="60px"><i>ZOHO</i></font><br>
	Stock Management System</h1>
	<hr>
	<div Style="display:flex; justify-content:space-between; "><span style="margin-left:20px;font-weight:bold;;"><h3>Purchasing Manager</h3></span> <a href="Login.jsp"><button class="Button" style="margin-right:30px;height:1.3cm;">LogOut</button></a></div>
	
	</div>
	<div class="Descripton">
	<%
 	String value = (String)request.getAttribute("value");
 	%>

 	<h5><%=value %></h5>
	</div>
	<div class="func" >
	<table>
	<tr>
	<td>
	<a href="Order.jsp"><input class="func" type="button" name="order" value="Order"></a>
	</td>
	<td>
	<form method="post" action="DisplayCardServlet"><input class="func" type="submit" name="card" value="Payment"></form>
	</td>
	<td>
	<a href="Supplier.jsp"><input class="func" type="button" name="sup" value="Suppliers"></a>
	</td>
	</tr>
	</table>
	</div>
	<div class="des">
	<h1>Description</h1>
	</div>
	<div class="img">
	<table>
	<tr>
	<td>
	<img src="img/Prof.png" class="img">
	</td>
	<td><p>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Name: <br><br>
	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp  Employee ID: <br><br>
	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Designation: <br><br>
	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Gender: </p>
	</td>
	<td>Sanjana Nilanka Perera<br><br>
	ZPM001<br><br>
	Purchasing Manager<br><br>
	Male
	</td>
	</tr>
	</table>
	</div>
	<div class="des">
	<h1>Purchasing <span style="color:white;"> Manager</span></h1>
	<P class="desP">This is Purchasing Manager of ZOHO stock management system and he is capable of placing stock orders, doing payments and  Editing suppliers.</P>
	<br>
  	
  	<br><br>
	</div>
</body>
</html>