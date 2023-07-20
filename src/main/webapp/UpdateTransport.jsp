<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ready shipment goods</title>
<link rel = "stylesheet"  href="Styles.css">
<script src="ShippingManager.js"></script>
</head>
<body style="font-family:Arial; background-color:#3385ff;">
	<div class="header">
	<h1 style="margin-left:20px;"><font size="60px"><i>ZOHO</i></font><br>
	Stock Management System</h1>
	<hr>
	<h3 style="margin-left:20px;">Shipping Manager</h3>
	
	</div>
    <br>
    <%String VID= (String)request.getAttribute("button");%>
    <div class="BodyDivTable">
	<h1><span style="color:orange">Update Vehicle '<%=VID %>' </span> Here</h1> <br>
   
    		<span >Fill the relevant fields you want to update</span><br><br>
	<form method="POST" action="UpdateTransportServlet">
		<table style="margin:auto; width:65%; text-align:left">
			<tr>
				<td>Vehicle ID:</td>
				<td><input class="LoginBox" type="text" name="V_ID" value="<%=VID %>" readonly /></td>
			</tr>
			<tr>
				<td>Vehicle Type:</td>
				<td><input class="LoginBox" type="text" name="VType" /></td>
			</tr>
			<tr>
				<td>Vehicle Code:</td>
				<td><input class="LoginBox" type="text" name="VCode" /></td>
			</tr>
			<tr>
				<td>Driver Name:</td>
				<td><input class="LoginBox" type="text" name="DName" /></td>
			</tr>
			<tr>
				<td>Departure Date:</td>
				<td><input class="LoginBox" type="text" name="DDate" /></td>
			</tr>
			</table>
			<br><br>
			<div>
				<input class="func" type="submit" name="update" value="Update" /> <br><br>
				<input  class="func" type="reset" value="Reset" ><br><br>
			</div>
			</form>
			<div>
				<form method= "post" action=""><button class="func" type="button" name="back" value="SM">Back to Profile</button></form><br><br>
			</div>
	</div>
	
    
</body>
</html>