<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="Styles.css">
<script src="PurchasingManager.js"></script>
<title>Order</title>
</head>
<body style="font-family:Arial; background-color:#3385ff;">
	<div class="header">
	<h1 style="margin-left:20px;"><font size="60px"><i>ZOHO</i></font><br>
	Stock Management System</h1>
	<hr>
	<h3 style="margin-left:20px;">Order</h3>
	</div>
	<div class="func" style=" color:white;margin-top:1cm; margin-bottom:1cm;border:2px solid black;background-color:#0047b3;height:420px;width:60%;">

	<h1 style="text-align:center;"><span style="color:orange">Order</span> Controller</h1> <br>
	<div align="center">
	<table>
	<tr>
	<td>
	<input class="func" type="button" name="order" value="Place Order"  onclick="loadData('PlaceO')">
	</td>
	<td>
	<input class="func" type="button" name="PrevOrder" value="Previous Orders"  onclick="loadData('PreviousO')">
	</td>
	<td>
	<input class="func" type="button" name="order" value="Pending Order"  onclick="loadData('PendingO')">
	</td>
	</tr>
	</table>
	</div>
	<div class="order" style="margin-top:1cm;width:90%;">
		<p id="p1" style="text-align:justify;"></p>
	</div><br><br>
	<div align="center">
		<form method= "post" action="BackDescriptionServlet"><button class="func" type="submit" name="button" value="PM">Back to Profile</button></form>
	</div>
	</div>
</body>
</html>