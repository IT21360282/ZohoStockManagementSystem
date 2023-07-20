<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>vehicle</title>
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
	<h1><span style="color:orange">Assign</span> a Suitable Vehicle</h1>

	<h3>Choose your preffered vehicle</h3>
	<form method="post" action="DisplayVehicleServlet">
	<table style="margin:auto; width:85%; text-align:left">
	<tr>
	<th>Enter the Vehicle ID:</th>

	<th><input class="LoginBox" type="text" name="VID"></th>
	<th>  <button class="Button" type ="submit" name="vehicle" value="Spe">Submit</button></th>
	</tr>
  
	</table>
	</form>
	<br>
</div>

</body>
</html>