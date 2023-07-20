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
<div class="bodyDiv1">  



<div class="BodyDivTable" style="margin:auto;margin-top:2cm;width:80%;">
	<h1><span style="color:orange;">List of All</span> <span style="color:white;">Stock</span></h1>
	<table class="Table">
	<%@page import="java.util.ArrayList" %>
	<%@page import="com.oop.model.Stock" %>
	
	<%
		ArrayList StockDet = (ArrayList)request.getAttribute("stockDetails");
		int tuple = (Integer)request.getAttribute("tuple");
	%>

 <tr>
       <th class="Th">Stock ID</th>
       <th class="Th">Stock Name</th>
       <th class="Th">Stock Category</th>
       <th class="Th">Quantity</th>
       <th class="Th">Purchasing Price</th>
       <th class="Th">Purchasing Date</th>
       <th class="Th">Supplier</th>
       <th class="Th">Options</th>
 </tr>
 <tr>
 <% for(int i=0; i<tuple; i++){ %>
 <% Stock stock = (Stock)StockDet.get(i);  %>
	<td class="Td"><%= stock.getS_ID() %></td>
	<td class="Td"><%= stock.getS_Name() %></td>
	<td class="Td"><%= stock.getS_Category() %></td>
	<td class="Td"><%= stock.getS_Quantity() %></td>
	<td class="Td"><%= stock.getPurchasing_Price() %></td>
	<td class="Td"><%= stock.getPurchasing_date() %></td>
	<td class="Td"><%= stock.getSupplier_Name() %></td>
	<td class="Td" ><div style="display:flex;"><form action="DeleteStockServlet" method="post"><button class="Button" style="margin:22px;" type="submit" value="<%=stock.getS_ID()%>" name="delete">Delete</button></form>
	<form method="post" action="UpdateStockServlet"><button class="Button" type="submit" style="margin:22px;" name="update" value="<%=stock.getS_ID()%>">Update</button></form></div></td>
	</tr>	
 <%} %>
</table>
<a href="StockEnter.jsp"><input class="func" type="submit" value="Add New Stock" class="add-button" /></a> <br><br>
</div>
</div>
	

</body>
</html>