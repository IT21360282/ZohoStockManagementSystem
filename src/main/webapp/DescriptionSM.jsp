<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Description</title>
<link rel = "stylesheet"  href="Styles.css">
</head>

<body style="font-family:Arial; background-color:#3385ff;">
	<div class="header">
	<h1 style="margin-left:20px;"><font size="60px"><i>ZOHO</i></font><br>
	Stock Management System</h1>
	<hr>
	<div Style="display:flex; justify-content:space-between; "><span style="margin-left:20px;font-weight:bold;;"><h3>Purchasing Manager</h3></span> <a href="Login.jsp"><button class="Button" style="margin-right:30px;height:1.3cm;">LogOut</button></a></div>
	
	</div>
	<div class="Descripton">
	<%
 	String value = (String)request.getAttribute("value");
 	%>

 	<h5><%=value %></h5>
	</div>
	<div class="func" >
	<table>
	<tr>
	<td>
	<a href="ReadyShipment.jsp"><input class="func" type="button" name="" value="Ready Packagers"></a>
	</td>
	<td>
	<a href="quality1.jsp"><input class="func" type="button" name="" value="Quality Validation"></a>
	</td>
	<td>
	<a href="AddVehicle.jsp"><input class="func" type="button" name="" value="Vehicle"></a>
	</td>
	</tr>
	</table>
	</div>
	<div class = "des"> <h1 style= "color: orange;">Description</h1></div>
	<div class="img">
	
	<table>
	<tr>
	<td>
	<img src="img/Prof.png" class="img">
	</td>
	<td><p>&nbsp&nbsp Name: <br><br>
	&nbsp&nbsp Employee ID: <br><br>
	&nbsp&nbsp Designation: <br><br>
	&nbsp&nbsp Gender: </p>
	</td>
	<td>Yoshitha Tennakoon<br><br>
	SM003<br><br>
	Shipping Manager<br><br>
	Male
	</td>
	</tr>
	</table>
	</div>
  <div class = "des">
  <h1>Shipping <span style="color:white;">Manager</span></h1>
  <p class="desP">Hey! This is Yoshitha Tennakoon, the shipping manager of the ZOHO stock management system.
  He's an enthusiastic employee here in ZOHO and what he doing is arranging all the relevant 
  goods for the shipment.For that firstly he needs to validate the quality of goods.From
  that he can select the better goods for the further process.Secondly he'll verify the
  user-friendliness of those selected goods.Then he will allow the goods packaging if 
  all are being verified as user-friendly.Finally he'll allow the shipping controller to
  assign a suitable vehicle to transport all packagers to the shipping place.
  Thank you.</p>
  <br>
  </div>
</body>
</html>