<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="Styles.css">
<title>Purchasing Manager Functions</title>
</head>
<body style="font-family:Arial; background-color:#3385ff;">
	<div class="header">
	<h1 style="margin-left:20px;"><font size="60px"><i>ZOHO</i></font><br>
	Stock Management System</h1>
	<hr>
	<h3 style="margin-left:20px;">Purchasing Manager</h3>
	</div>
	<div class="func" style="margin-top:0.5cm;">
	<table>
	<tr>
	<td>
	<input class="func" type="button" name="order" value="Place Order"  onclick="loadData('PlaceO')">
	</td>
	<td>
	<input class="func" type="button" name="order" value="Previous Orders"  onclick="loadData('PreviousO')">
	</td>
	<td>
	<input class="func" type="button" name="order" value="Pending Order"  onclick="loadData('PendingO')">
	</td>
	</tr>
	</table>
	</div>
	<div class="order">
	<form method="post" action="OrderServlet">
	Enter order ID which you want to see details: <input class="LoginBox" type="text" name="qty">
	<button class="Button" type="submit" name="qtySub" value="Spec">Submit</button>
	<span style="text-align:center;"><h1>OR</h1></span>
	See details of all orders: <button class="Button" type="submit" name="qtySub" value="Spec">Submit</button>
	</form>
	</div>
	
	<form method="post" action="DisplaySupplierServlet">
		<table>
			<tr>
				<td>Enter Supplier Registered No:<input class="LoginBox" style="width:150px;" type="text" name="RegNo"></td>
				<td><button class="Button" type="submit" name="Order" value="SpecSupplier" >Submit</button></td>
			</tr>
		</table>
		<span style="text-align:center;"><h1>OR</h1></span>
		<table>
			<tr>
				<td>See Details of All Supplier :</td>
				<td align="right" style="width:250px;"> <button class="Button" type="submit" name="Order" value="AllSupplier" >Submit</button></td>
			</tr>
		</table>
	</form>
	
	<form method="post" action="DisplaySupplierServlet"><table><tr><td>Enter Supplier Registered No:<input class="LoginBox" style="width:150px;" type="text" name="RegNo"></td><td><button class="Button" type="submit" name="Order" value="SpecSupplier" >Submit</button></td></tr></table><span style="text-align:center;"><h1>OR</h1></span><table><tr><td>See Details of All Supplier :</td><td align="right" style="width:250px;"> <button class="Button" type="submit" name="Order" value="AllSupplier" >Submit</button></td></tr></table></form>

</body>
</html>