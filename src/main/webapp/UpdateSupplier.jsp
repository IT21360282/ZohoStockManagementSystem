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
    <%String RegNo= (String)request.getAttribute("button");%>
    <div class="BodyDivTable">
	<h1><span style="color:orange">Update Supplier '<%=RegNo %>' </span> Here</h1> <br>
   
    		<span >Fill the fields only you want to update</span><br><br>
	<form method="POST" action="UpdateSupplierServlet">
		<table style="margin:auto; width:65%; text-align:left">
			<tr>
				<td>Registered Number:</td>
				<td><input class="LoginBox" type="text" name="RegNo" value="<%=RegNo %>" readonly /></td>
			</tr>
			<tr>
				<td>Supplier Name:</td>
				<td><input class="LoginBox" type="text" name="Sname" /></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input class="LoginBox" type="text" name="Saddress" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input class="LoginBox" type="text" name="Semail" /></td>
			</tr>
			<tr>
				<td>Contact Number:</td>
				<td><input class="LoginBox" type="text" name="Sphone" /></td>
			</tr>
			</table>
			<br><br>
			<div>
				<input class="func" type="submit" name="update" value="Update" /> <br><br>
				<input  class="func" type="reset" value="Reset" ><br><br>
			</div>
			</form>
			<div>
				<form method= "post" action=""><button class="func" type="button" name="back" value="PM">Back to Profile</button></form><br><br>
			</div>
	</div>
	
    
</body>
</html>