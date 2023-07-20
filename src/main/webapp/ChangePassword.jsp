<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="Styles.css">
<title>Stock Management System - Login</title>
</head>
<body style="font-family:Arial; background-color:#3385ff;">
	<div class="header">
	<h1 style="margin-left:20px;"><font size="60px"><i>ZOHO</i></font><br>
	Stock Management System</h1>
	<hr>
	<h3 style="margin-left:20px;"> Admin Login</h3>
	
	</div>
	<div class="Login">
	<br><h2><span style="color:orange;">Change Password</span> Here</h2><br>
	<form method="post" action="LoginServlet">
		User Name:&nbsp&nbsp   
		<select class="LoginBox" style="width:207px; height: 27px;" name="As">
			<option>Select one</option>
   			<option value="DBHandeler">Database Handler</option>
    		<option value="PurchasingM">Purchasing Manager</option>
   		 	<option value="ShippingM">Shipping Manager</option>
   		</select><br><br>
   		Current Password: <input class="LoginBox" type="password" name="pass"><br><br>
   		Current Password: <input class="LoginBox" type="password" name="pass"><br>
   		Current Password: <input class="LoginBox" type="password" name="pass">
   		<br><br>
   		<input class="LogButton" type="submit" name="button" value="LOGIN">
   		<input class="LogButton" type="reset" name="button" value="RESET">
   		<br><br><br>
	</form>
	</div>
</body>
</html>