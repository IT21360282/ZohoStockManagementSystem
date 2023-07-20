<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Stock Management System</title>
<link rel = "stylesheet"  href="Styles.css">
</head>

<body style="font-family:Arial; background-color:#3385ff;">
	<div class="header">
	<h1 style="margin-left:20px;"><font size="60px"><i>ZOHO</i></font><br>
	Stock Management System</h1>
	<hr>
	<h3 style="margin-left:20px;">Stock Database Handler</h3>
	
	</div>

  <h1><span style="color:orange;">List of All</span> <span style="color:white;">Stock</span></h1>
  
<div align="left">
	<table border="1" cellpadding="12">
	<%@page import="java.util.ArrayList" %>
	<%@page import="com.oop.model.Package" %>
	
	<%
		ArrayList StockDet = (ArrayList)request.getAttribute("stockDetails");
		int tuple = (Integer)request.getAttribute("tuple");
	%>

 <tr>
       <th>Package ID</th>
       <th>Package Type</th>
       <th>Package Height</th>
       <th>Package Weight</th>
       <th>Package Length</th>
       <th>Label Color</th>
 </tr>
 <tr>
 <% for(int i=0; i<tuple; i++){ %>
 <% Package pack = (Package)StockDet.get(i);  %>
	<td><%= pack.getP_ID() %></td>
	<td><%= pack.getP_Type() %></td>
	<td><%= pack.getP_Height() %></td>
	<td><%= pack.getP_Weight() %></td>
	<td><%= pack.getP_Lenght() %></td>
	<td><%= pack.getLabel_Color() %></td>
	
</tr>	
 <%} %>
</table>
</div>
 
 
 <br><br><br>
  

</body>
</html>