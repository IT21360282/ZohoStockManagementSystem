<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Stock Management System</title>
<link rel = "stylesheet"  href="Styles.css">
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
	<a href="StockEnter.jsp"><input class="func" type="button" name="order" value="Add New Stoke"></a>
	</td>
	<td>
	<form method="post" action="GetStockServlet">
	<input class="func" type="submit" name="order" value="List All Stock">
	</form>
	</td>
	<td>
	<form method="post" action="GetStockServlet">
	<input class="func" type="submit" name="order" value="Delete A Stock">
	</form>
	</td>
	</tr>
	</table>
	</div>
	<div class = "des"> <h1 style= "color: orange;">Description</h1></div>
	<div class="img">
	
	<table>
	<tr>
	<td>
	<img src="img/Prof.png" class="img">
	</td>
	<td><p>&nbsp&nbsp Name: <br><br>
	&nbsp&nbsp Employee ID: <br><br>
	&nbsp&nbsp Designation: <br><br>
	&nbsp&nbsp Gender: </p>
	</td>
	<td>Dhanuka Jayathilaka<br><br>
	DBH003<br><br>
	Stock Database Handler<br><br>
	Male
	</td>
	</tr>
	</table>
	</div>
  <div class = "des">
  <h1>Stock Database <span style="color:white;">Handler</span></h1>
  <p class="desP">Hey Dhanuka! Your main duty is Manage Stock Database. You can access insert, 
  delete and update details the stock database. You have to check the available stock in system 
  and update the details of newly arrived stocks. <font color="white"> Don't forget to Save 
  updated stock details </font> and if stocks are not kind enough, inform to stock manager 
  to order goods. </p>
  <br>
  
  </div>
</body>
</html>