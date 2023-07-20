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
	<%@page import="com.oop.model.Suppliers"%>
	<% 
		int tuple = (Integer)request.getAttribute("tuple");
		String value = (String)request.getAttribute("value");
		ArrayList supplierDetails = (ArrayList)request.getAttribute("supplierDetails");
	%>
	
	<div class="BodyDivTable" style="margin:auto;margin-top:2cm;width:80%;">

	<h1><span style="color:orange">Details</span> of <%=value %></h1>
	<table class="Table" >
		<tr>
			<th class="Th">Registered No</th>
			<th class="Th">Name</th>
			<th class="Th">Address</th>
			<th class="Th">Email</th>
			<th class="Th">Contact No</th>
			<th class="Th">Options</th>
		</tr>
		<%for(int i=0; i<tuple;i++){ %>
		<%Suppliers suppliers = (Suppliers)supplierDetails.get(i); %>
		
		<tr>
			<td class="Td"><%=suppliers.getRegNo() %></td>
			<td class="Td"><%=suppliers.getSname() %></td>
			<td class="Td"><%=suppliers.getSaddress() %></td>
			<td class="Td"><%=suppliers.getSemail() %></td>
			<td class="Td"><%=suppliers.getSphone() %> </td>
			<td class="Td"><div style="display:flex;"><form method="post" action="DeleteSupplierServlet"><button class="Button" type="submit" style="margin:22px;" name="delete" value="<%=suppliers.getRegNo()%>">Delete</button></form>
			<form method="post" action="UpdateSupplierServlet"><button class="Button" type="submit" style="margin:22px;" name="update" value="<%=suppliers.getRegNo()%>">Update</button></form></div></td>
		</tr>
		
		<%} %>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td><br><a href="Supplier.jsp"><input type="button" class="Button" style="margin-left:10px; margin-right:10px;width:2.8cm;" value="Back Supplier"></a></td>
		</tr>
	</table>
	
	</div>
</body>
</html>