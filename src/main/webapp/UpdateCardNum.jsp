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
	<h3 style="margin-left:20px;">Shipping Manager</h3>
	
	</div>
    <br>
       <%String CardNum= (String)request.getAttribute("button");%>
    <div class="BodyDivTable">
	<h1><span style="color:orange">Update Supplier '<%=CardNum %>'</span> Here</h1> <br>
    <br>
 
	<form method="POST" action="UpdateCardServlet">
		<table style="margin:auto; width:65%; text-align:left">

			<tr>
				<td>Card Number:</td>
				<td><input class="LoginBox" type="text" name="CardNum" value="<%=CardNum %>" /></td>
			</tr>
			<tr>
				<td>Expiry:</td>
				<td><input class="LoginBox" type="text" name="ExMonth" placeholder="MM/YY" /></td>
			</tr>
			<tr>
				<td>CVC:</td>
				<td><input class="LoginBox" type="text" name="CVC" /></td>
			</tr>
			<tr>
				<td>Payment Network:</td>
				<td><input class="LoginBox" type="text" name="PaymentNet" /></td>
			</tr>
			<tr>
				<td>Bank Name:</td>
				<td><input class="LoginBox" type="text" name="bankName" /></td>
			</tr>
			</table>
			<br><br>
			<div>
				<input class="func" type="submit" name="update" value="Update" /> <br><br>
				<input  class="func" type="reset" value="Reset" ><br><br>
				
			</div>
			</form>
			
	</div>
	
    
</body>
</html>