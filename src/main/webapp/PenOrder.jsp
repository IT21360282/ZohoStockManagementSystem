<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Previous Order List</title>
<link rel="stylesheet" href="Styles.css">
</head>
<body style="font-family:Arial; background-color:#3385ff;">
	<div class="header">
		<h1 style="margin-left:20px;"><font size="60px"><i>ZOHO</i></font><br>
		Stock Management System</h1>
		<hr>
		<h3 style="margin-left:20px;">Purchasing Manager</h3>
	</div>
	<%@page import="java.util.ArrayList"%>
	<%@page import="com.oop.model.Orders"%>
	<% 
		int tuple = (Integer)request.getAttribute("tuple");
		String value = (String)request.getAttribute("value");
		ArrayList orderDetails = (ArrayList)request.getAttribute("orderDetails");
	%>
	
	<div class="BodyDivTable" style="margin-left:7cm;margin-right:7cm;">

	<h1><span style="color:orange">Details</span> of <%=value %></h1>
	<table class="Table">
		<tr>
			<th class="Th">Oreder ID</th>
			<th class="Th">Category</th>
			<th class="Th">Supplier</th>
			<th class="Th">Date</th>
			<th class="Th">Total</th>
			<th class="Th">Options</th>
		</tr>
		<%for(int i=0; i<tuple;i++){ %>
		<%Orders order = (Orders)orderDetails.get(i); %>
		
		<tr>
			<td class="Td"><%=order.getOrderID() %></td>
			<td class="Td"><%=order.getCategory() %></td>
			<td class="Td"><%=order.getSupplier() %></td>
			<td class="Td"><%=order.getDate() %></td>
			<td class="Td"><%=order.getSubTotal() %></td>
			<td class="Td"><div style="display:flex;"><form method="post" action="DeletePenOrderServlet"><button class="Button" type="submit" style="margin-left:22px; margin-right:22px;" name="received" value="<%=order.getOrderID()%>">Received</button></form>
			<form method="post" action="DisplayGoodsServlet"><button class="Button" type="submit" style="margin-left:22px; margin-right:22px;" name="goods" value="<%=order.getOrderID()%>">List Goods</button></form>
			</div></td>
		</tr>
		
		<%} %>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td><br><form method="post" action="DisplayCardServlet"><button type="submit" class="Button" style="margin-left:10px; margin-right:10px;width:2.8cm;" name="card" value="Payment">Pay for Order</button></form></td>
			<td><br><a href="Order.jsp"><input type="button" class="Button" style="margin-left:10px; margin-right:10px;width:2.8cm;" value="Back"></a></td>
		</tr>
	</table>
	</div>
</body>
</html>