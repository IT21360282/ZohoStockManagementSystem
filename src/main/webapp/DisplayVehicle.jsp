<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Previous Order List</title>
<link rel="stylesheet" href="Styles.css">
</head>
<body style="font-family:Arial; background-color:#3385ff;">
	<div class="header">
		<h1 style="margin-left:20px;"><font size="60px"><i>ZOHO</i></font><br>
		Stock Management System</h1>
		<hr>
		<h3 style="margin-left:20px;">Purchasing Manager</h3>
	</div>
	<%@page import="java.util.ArrayList"%>
	<%@page import="com.oop.model.transport"%>
	<% 
		int tuple = (Integer)request.getAttribute("tuple");
		String value = (String)request.getAttribute("value");
		ArrayList VehicleDetails = (ArrayList)request.getAttribute("vehiDetails");
	%>
	
	<div class="BodyDivTable" style="margin:auto;margin-top:1cm;width:80%;">

	<h1><span style="color:orange">Details</span> of <%=value %></h1>
	<table class="Table" >
		<tr>
			<th class="Th">Vehicle ID</th>
			<th class="Th">Vehicle Type</th>
			<th class="Th">Vehicle Code</th>
			<th class="Th">Driver Name</th>
			<th class="Th">Departure Date</th>
			<th class="Th">Options</th>
		</tr>
		<%for(int i=0; i<tuple;i++){ %>
		<%transport vehi = (transport)VehicleDetails.get(i); %>
		
		<tr>
			<td class="Td"><%=vehi.getV_ID() %></td>
			<td class="Td"><%=vehi.getV_Type() %></td>
			<td class="Td"><%=vehi.getV_Code() %></td>
			<td class="Td"><%=vehi.getDriver_Name() %></td>
			<td class="Td"><%=vehi.getDeparture_Date() %> </td>
			<td class="Td"><div style="display:flex;"><form method="post" action="deletetransportservlet"><button class="Button" type="submit" style="margin:22px;" name="delete" value="<%=vehi.getV_ID() %>">Delete</button></form>
			<form method="post" action="UpdateTransportServlet"><button class="Button" type="submit" style="margin:22px;" name="update" value="<%=vehi.getV_ID() %>">Update</button></form></div></td>
		</tr>
		
		<%} %>
		</table>
		<table class="Table" >
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td>
			<a href="AddVehicle.jsp"><input type="button" class="Button" style="margin-left:10px; margin-right:10px;width:3.8cm;" value="Add a Vehicle"></a></td>
		</tr>
	</table>
	
	</div>
</body>
</html>