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
    <br>
    <div class="BodyDivTable" style="margin-top:0.5cm;">
	<h2 class="h2"><span style="color:orange">Ready all the goods</span> and packagers</h2> 
	<h2 class="h2"><span style="color:orange">Please enter the</span> package details</h2>
    <br>
	 
	<form method="POST" action="addpackageservlet">
		<table style="margin:auto; width:65%; text-align:left">

			<tr>
				<td>Package ID</td>
				<td><input class="LoginBox" type="text" name="PackageID"  placeholder="Id" /></td>
			</tr>
			<tr>
				<td>Package Type</td>
				<td><input class="LoginBox" type="text" name="packageType" placeholder="Type" /></td>
			</tr>
			<tr>
				<td>Package Height</td>
				<td><input class="LoginBox" type="text" name="PackageHeight"  placeholder="Height" /></td>
			</tr>
			<tr>
				<td>Package Weight</td>
				<td><input class="LoginBox" type="text" name="Packageweight"  placeholder="Weight"/></td>
			</tr>
			<tr>
				<td>Package Length</td>
				<td><input class="LoginBox" type="text" name="PackageLength"  placeholder="Length"/></td>
			</tr>
			<tr>
				<td>Label Color</td>
				<td><input class="LoginBox" type="text" name="LabelColor"  placeholder=""/></td>
			</tr>
			</table>
			<br>
			<div>
				<input class="func" type="submit" value="Ready Packaging" class="add-button" /><br><br>
				<input  class="func" type="reset" value="Reset Packaging" class="reset-button" /><br><br>
			</div>	
			</form>
			<div>
			<form method="POST" action="packageservlet"><input class="func" type="submit" value="Display all packagers" class="list-button" /><br><br>
			</form>
			</div>
			<div>
				<form method= "post" action="BackDescriptionServlet"><button class="func" type="submit" name="button" value="SM">Back to Profile</button></form><br><br>
			</div>
    </div>
</body>
</html>