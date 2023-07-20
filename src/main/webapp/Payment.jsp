<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ready shipment goods</title>
<link rel = "stylesheet"  href="Styles.css">
<script src="PurchasingManager.js"></script>
</head>
<body style="font-family:Arial; background-color:#3385ff;">
	<div class="header">
	<h1 style="margin-left:20px;"><font size="60px"><i>ZOHO</i></font><br>
	Stock Management System</h1>
	<hr>
	<h3 style="margin-left:20px;">Payment</h3>
	
	</div>
    <br>
    <div class="BodyDivTable" style="margin-top:0.5cm;">
	<h1><span style="color:orange">Make a Payment</span> Here</h1> <br>
    <br>
    <%@page import="java.util.ArrayList"%>
	<%@page import="com.oop.model.Card"%>
	<% 
		int tuple = (Integer)request.getAttribute("tuple");
		ArrayList cardDetails = (ArrayList)request.getAttribute("cardDetails");
	%>
	<form method="POST" action="DoPaymentServlet">
		<table style="margin:auto; width:57%; text-align:left">

			<tr>
				<td>Payment ID:</td>
				<td><input class="LoginBox" type="text" name="PID" /></td>
			</tr>
			<tr>
				<td>Payment for:</td>
				<td><input class="LoginBox" type="text" name="Reason" /></td>
			</tr>
			<tr>
				<td>Debit Card No:</td>
				<td><select class="LoginBox" style="width:207px; height: 27px;" name="UsedCard">
						<option>Select one</option>
						<%for(int i=0; i<tuple;i++){ %>
						<%Card card = (Card)cardDetails.get(i); %>
   						<option value="<%=card.getCardNum() %>"><%=card.getCardNum() %></option>
   		 				<%} %>
   			</select><br></td>
			</tr>
			<tr>
				<td>Amount:</td>
				<td><input class="LoginBox" type="text" name="Amount" /></td>
			</tr>
			<tr>
				<td>Date:</td>
				<td><input class="LoginBox" type="date" name="PaidDate" /></td>
			</tr>
			</table>
			<br><br>
			<div>
				<input class="func" type="submit" value="Pay" /> <br><br>
				<input  class="func" type="reset" value="Reset" ><br><br>
			</div>
			</form>
			<div>
				<input class="func" type="button" value="Card Deails"  onclick="showButtonPay('card')"><br>	<br>
				<div style="margin:auto;width:80%;" id="div2" ></div>
				<input class="func" type="button" value="Payment Details" onclick="showButtonPay('PayDetails')" >
			</div>
			
			<br><div style="margin:auto;width:80%;" id="div1" ></div>
			<div>
				<form method= "post" action="BackDescriptionServlet"><button class="func" type="submit" name="button" value="PM">Back to Profile</button></form><br><br>
			</div>
	</div>
	
    
</body>
</html>