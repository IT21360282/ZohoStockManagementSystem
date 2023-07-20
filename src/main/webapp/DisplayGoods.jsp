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
	<%@page import="com.oop.model.Goods"%>
	<% 
		int tuple = (Integer)request.getAttribute("tuple");
		String value = (String)request.getAttribute("value");
		ArrayList goodsDetails = (ArrayList)request.getAttribute("goodsDetails");
	%>
	
	<div class="BodyDivTable" >

	<h1><span style="color:orange">Goods Details</span> of <%=value %></h1>
	<table class="Table">
		<tr>
			<th class="Th">Oreder ID</th>
			<th class="Th">Goods Name</th>
			<th class="Th">Quantity</th>
		</tr>
		<%for(int i=0; i<tuple;i++){ %>
		<%Goods goods = (Goods)goodsDetails.get(i); %>
		
		<tr>
			<td class="Td"><%=goods.getOrderID() %></td>
			<td class="Td"><%=goods.getGoodsName() %></td>
			<td class="Td"><%=goods.getQty() %></td>
		</tr>
		
		<%} %>
		<tr>
			<td></td>
			<td></td>
			<td><br><a href="Order.jsp"><input type="button" class="Button" style="margin-left:10px; margin-right:10px;width:2.8cm;" value="Back"></a></td>
		</tr>
	</table>
	</div>
</body>
</html>