<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet"
   type = "text/css"
   href = "Styles.css" />

<meta charset="UTF-8">
<title>Stock Management System</title>
</head>
<body class="body" style="font-family:Arial; background-color:#3385ff;">
	<div class="header">
	<h1 style="margin-left:20px;"><font size="60px"><i>ZOHO</i></font><br>
	Stock Management System</h1>
	<hr>
	<h3 style="margin-left:20px;">Stock Database Handler</h3>
	</div>

<div class="BodyDivTable">

  <h1><span style="color:orange;">ADD New Stock</span> <span style="color:white;">Page</span></h1>

	<br>

<form method="POST" action="AddStockServlet">
		<table style="margin:auto; width:65%; text-align:left">
		
			<tr>
				<td>Stock ID</td>
				<td><input class="LoginBox" type="text" name="S_ID" /></td>
			</tr>
			<tr>
				<td>Stock Name</td>
				<td><input class="LoginBox" type="text" name="S_Name" /></td>
			</tr>
			<tr>
				<td>Stock Category</td>
				<td><input class="LoginBox" type="text" name="S_Category" /></td>
			</tr>
			<tr>
				<td>Quantity</td>
				<td><input class="LoginBox" type="text" name="S_Quantity" /></td>
			</tr>
			<tr>
				<td>Purchasing Price</td>
				<td><input class="LoginBox" type="text" name="Purchasing_Price" /></td>
			</tr>
			<tr>
				<td>Purchasing Date</td>
				<td><input class="LoginBox" type="date" name="Purchasing_date" /></td>
			</tr>
			<tr>
				<td>Supplier Name</td>
				<td><input class="LoginBox" type="text" name="Supplier_Name" /></td>
			</tr>
			</table>
			<br><br>
			<div>
				<input class="func" type="submit" value="Add New Stock" class="add-button" /><br><br>
				
				<input class="func" type="reset" value="Reset Stock" class="reset-button" /><br><br>
			</div>
			</form>
		
			<div>
			
				<form method="POST" action="GetStockServlet">
					<input class="func" type="submit" value="List All Stock" class="list-button" /><br><br>
				</form>
				<form method="POST" action="BackDescriptionServlet">
					<button class="func" type="submit" name="button" value="DBH" >Back to Description</button><br><br>
				</form>
			</div>
<br>	
</div>
</body>
</html>