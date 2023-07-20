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
	<%@page import="com.oop.model.Package"%>
	<% 
		int tuple = (Integer)request.getAttribute("tuple");
		String value = (String)request.getAttribute("value");
		ArrayList supplierDetails = (ArrayList)request.getAttribute("packDetails");
	%>
	
	<div class="BodyDivTable" style="margin:auto;margin-top:2cm;width:80%;">

	<h1><span style="color:orange">Details</span> of <%=value %></h1>
	<table class="Table" >
		<tr>
			<th class="Th">Package ID</th>
			<th class="Th">Type</th>
			<th class="Th">Height</th>
			<th class="Th">Weight</th>
			<th class="Th">Length</th>
			<th class="Th">Label Color</th>
		</tr>
		<%for(int i=0; i<tuple;i++){ %>
		<%Package pack = (Package)supplierDetails.get(i); %>
		
		<tr>
			<td class="Td"><%=pack.getP_ID() %></td>
			<td class="Td"><%=pack.getP_Type() %></td>
			<td class="Td"><%=pack.getP_Height() %></td>
			<td class="Td"><%=pack.getP_Weight() %></td>
			<td class="Td"><%=pack.getP_Lenght() %> </td>
			<td class="Td"><%=pack.getLabel_Color() %> </td>
			</tr>
		
		<%} %>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td><br><a href="ReadyShipment.jsp"><input type="button" class="Button" style="margin-left:10px; margin-right:10px;width:2.8cm;" value="Back"></a></td>
		</tr>
	</table>
	
	</div>
</body>
</html>