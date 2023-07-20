<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ready shipment goods</title>
<link rel = "stylesheet"  href="Styles.css">
</head>
<body style="font-family:Arial; background-color:#3385ff;">
	<div class="header">
	<h1 style="margin-left:20px;"><font size="60px"><i>ZOHO</i></font><br>
	Stock Management System</h1>
	<hr>
	<h3 style="margin-left:20px;">Shipping Manager</h3>
	
	</div>
	<div class="BodyDivTable">

  <h1><span style="color:orange;">ADD a</span> <span style="color:white;"> New Vehicle</span></h1>

	   ZOHO Stock Database Management System
	<br>
	<br>

<form method="POST" action="addtransportservlet">
		<table style="margin:auto; width:60%; text-align:left">
		
			<tr>
				<td>Vehicle Id:</td>
				<td><input class="LoginBox" type="text" name="V_ID" /></td>
			</tr>
			<tr>
				<td>Vehicle Type:</td>
				<td><input class="LoginBox" type="text" name="V_Type" /></td>
			</tr>
			<tr>
				<td>Vehicle Code:</td>
				<td><input class="LoginBox" type="text" name="V_Code" /></td>
			</tr>
			<tr>
				<td>Driver Name:</td>
				<td><input class="LoginBox" type="text" name="Driver_Name" /></td>
			</tr>
			<tr>
				<td>Departure Date:</td>
				<td><input class="LoginBox" type="text" name="Departure_Date" /></td>
			</tr>
			</table>
			<br>
			<div>
			<input class="func" type="submit" value="Add New Vehicle" class="add-button" />	<br><br>
			<input class="func" type="reset" value="Reset Vehicle" class="reset-button" />
			</div>
			<br>
			</form>
			<div>
			<form method="POST" action="DisplayVehicleServlet">
				<button class="func" type="submit"  name="vehicle" value="Allvehi" >List All Vehicles</button>
			</form>
			</div><br>
			<div>
				<form method= "post" action="BackDescriptionServlet"><button class="func" type="submit" name="button" value="SM">Back to Profile</button></form><br><br>
			</div>
	
</div>
</body>
</html>