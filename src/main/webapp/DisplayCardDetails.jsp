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
	<%@page import="com.oop.model.Card"%>
	<% 
		int tuple = (Integer)request.getAttribute("tuple");
		String value = (String)request.getAttribute("value");
		ArrayList cardDetails = (ArrayList)request.getAttribute("cardDetails");
	%>
	
	<div class="BodyDivTable" style="margin:auto;margin-top:1cm;width:80%;">

	<h1><span style="color:orange">Details</span> of <%=value %></h1>
	<table class="Table" >
		<tr>
			<th class="Th">Card No</th>
			<th class="Th">Expiry</th>
			<th class="Th">CVC</th>
			<th class="Th">Payment Network</th>
			<th class="Th">Bank Name</th>
			<th class="Th">Options</th>
		</tr>
		<%for(int i=0; i<tuple;i++){ %>
		<%Card card = (Card)cardDetails.get(i); %>
		
		<tr>
			<td class="Td"><%=card.getCardNum() %></td>
			<td class="Td"><%=card.getExMonth() %></td>
			<td class="Td"><%=card.getCVC() %></td>
			<td class="Td"><%=card.getPaymentNet() %></td>
			<td class="Td"><%=card.getBankName() %> </td>
			<td class="Td"><div style="display:flex;"><form method="post" action="DeleteCardServlet"><button class="Button" type="submit" style="margin:22px;" name="delete" value="<%=card.getCardNum()%>">Delete</button></form>
			<form method="post" action="UpdateCardServlet"><button class="Button" type="submit" style="margin:22px;" name="update" value="<%=card.getCardNum()%>">Update</button></form></div></td>
		</tr>
		
		<%} %>
		</table>
		<table class="Table" >
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td><form method="post" action="DisplayCardServlet"><button type="submit" class="Button" style="margin-left:10px; margin-right:10px;width:3cm;" name="card" value="Payment">Back Payment</button></form>
			<a href="AddDebitCard.jsp"><input type="button" class="Button" style="margin-left:10px; margin-right:10px;width:3.8cm;" value="Add New Debit Card"></a></td>
		</tr>
	</table>
	
	</div>
</body>
</html>