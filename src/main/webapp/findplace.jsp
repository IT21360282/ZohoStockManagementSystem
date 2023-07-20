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
<form method="post" action="DisplayHarbourServlet">
<h1><span style="color:orange">Check Shipment Harbour</span> Details</h1>

<h3>Enter the package id to find out the exact shipment place</h3>
<br>
<table style="margin:auto; width:85%; text-align:left">
<tr>
<th >Enter the package ID:</th>

<th ><input type="text" name="P_ID" class="text"></th>
<th >  <button type ="submit" class="Button" name="harbour" value="Sp">Submit</button></th>
</tr>

  
</table>
<br>
</form>
</div>
</body>
</html>