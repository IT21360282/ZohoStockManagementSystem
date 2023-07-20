<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet"  href="Styles.css">
</head>
<body style="font-family:Arial; background-color:#3385ff;">
	<div class="header">
	<h1 style="margin-left:20px;"><font size="60px"><i>ZOHO</i></font><br>
	Stock Management System</h1>
	<hr>
	<h3 style="margin-left:20px;">Shipping Manager</h3>
	
	</div>
	
<br><br>
<%@page import="java.util.ArrayList"%>
	<%@page import="com.oop.model.Harbour"%>
	<% 
		int tuple = (Integer)request.getAttribute("tuple");
		ArrayList harbourDetails = (ArrayList)request.getAttribute("harbourDetails");
	%>
	
	<div class="BodyDivTable" style="margin:auto;margin-top:1cm;width:80%;">
<h1><span style="color:orange">Harbour</span> Details</h1> 
 All the relevant destinations and location
	<table class="Table" >
		<tr>
			<th class="Th">Package ID</th>
			<th class="Th">Province</th>
			<th class="Th">Ship ID</th>
			<th class="Th">Harbour Name</th>
		</tr>
		<%for(int i=0; i<tuple;i++){ %>
		<%Harbour harbour = (Harbour)harbourDetails.get(i); %>
		
		<tr>
			<td class="Td"><%=harbour.getP_ID() %></td>
			<td class="Td"><%=harbour.getProvince() %></td>
			<td class="Td"><%=harbour.getShip_ID() %></td>
			<td class="Td"><%=harbour.getHarbour_Name() %></td>
		</tr>
		
		<%} %>
		</table>

  <form method="post" action="BackDescriptionServlet"><button type="submit" class="func" name="button" value="SM" >Back to Description</button></form>
      
 <br>
 <br>
 </div>
</body>
</html>