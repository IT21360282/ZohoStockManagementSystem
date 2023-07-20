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
	<script>
	  function success(){
		  alert("All the vehicle details are assigned successfully! Thank you..");
	  }
	  
	</script>
<br><br>

	

 
<%@page import="java.util.ArrayList"%>
	<%@page import="com.oop.model.transport"%>
	<% 
		int tuple = (Integer)request.getAttribute("tuple");
		ArrayList VehicleDetails = (ArrayList)request.getAttribute("vehicleDetails");
	%>
	
	<div class="BodyDivTable" style="margin:auto;margin-top:1cm;width:80%;">
<h1><span style="color:orange">Assign Vehicle</span> Here</h1> 
 <p>All the relevant vehicle details to transport packagers to the shipping place</p>
 
	
	<table class="Table" >
		<tr>
			<th class="Th">Vehicle ID</th>
			<th class="Th">Vehicle Type</th>
			<th class="Th">Vehicle Code</th>
			<th class="Th">Driver Name</th>
			<th class="Th">Departure Date</th>
		</tr>
		<%for(int i=0; i<tuple;i++){ %>
		<%transport vehi = (transport)VehicleDetails.get(i); %>
		
		<tr>
			<td class="Td"><%=vehi.getV_ID() %></td>
			<td class="Td"><%=vehi.getV_Type() %></td>
			<td class="Td"><%=vehi.getV_Code() %></td>
			<td class="Td"><%=vehi.getDriver_Name() %></td>
			<td class="Td"><%=vehi.getDeparture_Date() %> </td>
		</tr>
		
		<%} %>
		</table>

  <button type="button" class="func" onclick = "success()">Assign</button>
  <a href="vehicle.jsp"><button type="button" class="func" name="vehi">Previous page</button></a>
  <a href="findplace.jsp"><button type="button" class="func" name="">Check Shipment Harbour</button></a>
 <br>
 <br>
 </div>
 
</body>
</html>