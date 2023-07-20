<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment</title>
<link rel="stylesheet" href="Styles.css">
</head>
<body style="font-family:Arial; background-color:#3385ff;">
	<div class="header">
	<h1 style="margin-left:20px;"><font size="60px"><i>ZOHO</i></font><br>
	Stock Management System</h1>
	<hr>
	<h3 style="margin-left:20px;">Payment</h3>
	</div>
	<div class="BodyDivTable" >

	<h1 style="text-align:center;"><span style="color:orange">Send a Email</span> Here</h1>
	<form method="post" action="">
	<table style="margin:auto; width:56.9%; text-align:left;">
		<tr>
			<td>Supplier Email: <br><br></td>
			<td><input class="LoginBox" type="email" name="Semail" ><br><br></td>
   		</tr>
   		<tr>
			<td>Subject: <br><br></td>
			<td><input class="LoginBox" type="text" name="subject" ><br><br></td>
   		</tr>
   		<tr>
			<td>Message: <br><br></td>
			<td><textarea class="LoginBox" style="height:60px;" id="w3review" name="message" ></textarea><br><br></td>
   		</tr>
	</table>
	<br><br>
			<div>
				<input class="func" type="submit" value="Send" /> <br><br>
			</div>
	</form>
	</div>
</body>
</html>