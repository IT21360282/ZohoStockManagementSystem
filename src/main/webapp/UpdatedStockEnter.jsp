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
    <%String S_ID= (String)request.getAttribute("button");%>
    <div class="BodyDivTable">
	<h1><span style="color:orange">Update Stock '<%=S_ID %>' </span> Here</h1> <br>
   
    		<span >Fill the fields only you want to update</span><br><br>
	<form method="POST" action="UpdateStockServlet">
		<table style="margin:auto; width:65%; text-align:left">
			<tr>
				<td>Stock ID:</td>
				<td><input class="LoginBox" type="text" name="S_ID" value="<%=S_ID %>" readonly /></td>
			</tr>
			<tr>
				<td>Stock Name:</td>
				<td><input class="LoginBox" type="text" name="S_Name" /></td>
			</tr>
			<tr>
				<td>Stock Category:</td>
				<td><input class="LoginBox" type="text" name="S_Category" /></td>
			</tr>
			<tr>
				<td>Stock Quantity:</td>
				<td><input class="LoginBox" type="text" name="S_Quantity" /></td>
			</tr>
			<tr>
				<td>Purchasing Price:</td>
				<td><input class="LoginBox" type="text" name="Purchasing_Price" /></td>
			</tr>
			<tr>
				<td>Purchasing Date:</td>
				<td><input class="LoginBox" type="text" name="Purchasing_date" /></td>
			</tr>
			<tr>
				<td>Supplier Name:</td>
				<td><input class="LoginBox" type="text" name="Supplier_Name" /></td>
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