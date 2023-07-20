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
	<%@page import="com.oop.model.Payment"%>
	<% 
		int tuple = (Integer)request.getAttribute("tuple");
		String value = (String)request.getAttribute("value");
		ArrayList paymentDetails = (ArrayList)request.getAttribute("paymentDetails");
	%>
	
	<div class="BodyDivTable" style="margin:auto;margin-top:2cm;width:80%;">

	<h1><span style="color:orange">Details</span> of <%=value %></h1>
	<table class="Table" >
		<tr>
			<th class="Th">Payment ID</th>
			<th class="Th">Reason for Payment</th>
			<th class="Th">Used Debit Card</th>
			<th class="Th">Amount</th>
			<th class="Th">Paid Date</th>
		</tr>
		<%for(int i=0; i<tuple;i++){ %>
		<%Payment payment = (Payment)paymentDetails.get(i); %>
		
		<tr>
			<td class="Td"><%=payment.getPID() %></td>
			<td class="Td"><%=payment.getReason() %></td>
			<td class="Td"><%=payment.getUsedCard() %></td>
			<td class="Td"><%=payment.getAmount() %></td>
			<td class="Td"><%=payment.getPaidDate() %> </td>
		</tr>
		
		<%} %>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td><br><form method="post" action="DisplayCardServlet"><button type="submit" class="Button" style="margin-left:10px; margin-right:10px;width:3cm;" name="card" value="Payment">Back Payment</button></form></td>
		</tr>
	</table>
	
	</div>
</body>
</html>