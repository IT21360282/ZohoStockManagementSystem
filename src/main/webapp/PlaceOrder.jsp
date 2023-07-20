<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="Styles.css">
<title>Place Order</title>
</head>
<body style="font-family:Arial; background-color:#3385ff;">
	<div class="header">
	<h1 style="margin-left:20px;"><font size="60px"><i>ZOHO</i></font><br>
	Stock Management System</h1>
	<hr>
	<%@page import="java.util.ArrayList"%>
	<%@page import="com.oop.model.Suppliers"%>
	<h3 style="margin-left:20px;">Place Order</h3>
	</div>
	<%
 	int value = (Integer)request.getAttribute("value");
	int tuple = (Integer)request.getAttribute("tuple");
	ArrayList supplierDetails = (ArrayList)request.getAttribute("supplierDetails");
 	%>
 	<div class="OrderMain">
	<br><h1><span style="color:orange;">Make a Order</span> Here</h1><br>
	<form method="post" action="AddOrderServlet">
 	<div class="order" Style="margin-top:0.5cm; text-align:left;">
 	<table style="margin:auto; width:65%; text-align:left">
 	<tr>
 	<td><label>Order ID: </label></td>
 	<td><input class="LoginBox" type="text" placeholder="OrderID" name="OrderID"></td></tr>
 	<tr><td><label>Order Category: </label></td>
 	<td><select class="LoginBox" style="width:207px; height: 27px;" name="OrderCat">
			<option>Select one</option>
   			<option value="Electrical">Electrical</option>
    		<option value="Fodds">Foods</option>
   		 	<option value="Drinks">Drinks</option>
   	</select></td></tr>
 	<tr><td><label>Supplier: </label></td>
 	<td><select class="LoginBox" style="width:207px; height: 27px;" name="Supplier">
			<option>Select one</option>
   			<%for(int i=0; i<tuple;i++){ %>
			<%Suppliers suppliers = (Suppliers)supplierDetails.get(i); %>
   			<option value="<%=suppliers.getSname() %>"><%=suppliers.getSname() %></option>
   		 	<%} %>
   	</select></td></tr>
 	<tr><td><label>Placing Date: </label></td>
 	<td><input class="LoginBox" type="date" placeholder="Date" name="Date" ></td></tr>
 	<tr>
 	<td><label>Total Price: </label></td>
 	<td><input class="LoginBox" type="text" placeholder="Total Price" name="Total"></td></tr>
 	</table>
 	</div>
 	<br>
	<div class="order" Style="width:100%; margin-top:0.5cm;">
	<%for(int i =0; i<value; i++){ %>
		<label>Good's Name <%=i+1%>: </label>
		<input class="LoginBox" type="text" placeholder="GoodName<%=i+1%>" name="GoodName<%=i+1%>">&nbsp 
		<label>Quantity Good <%=i+1%>: </label>
		<input class="LoginBox" type="text" placeholder="GoodQty<%=i+1%>" name="GoodQty<%=i+1%>">
		<br><br>
	<%} %>
	<br><br>
	<button class="func" type="submit" name="valueSub" value="<%=value %>" >Submit</button><br><br>
	<input class="func" type="reset" name="order" value="Reset" >
	
	<br><br>
	</div>
	</form>
	</div>
</body>
</html>