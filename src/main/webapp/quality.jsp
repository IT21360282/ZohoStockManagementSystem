<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quality</title>
<link rel = "stylesheet"  href="styles.css">
<script>
/**
 * 
 */
 function loadData(name)
{
	if(name=="quality")
	{
		document.getElementById("p1").innerHTML='<form method="post" action="QalityServlet">Enter "Yes" validate the conditions": <input class="LoginBox" type="text" name="qty"><input class="Button" type="submit" name="qtySub" ></form>';
	}
	else if (name=="PreviousO")
	{
		document.getElementById("p1").innerHTML="";
	}
	else if (name=="PendingO")
	{
		document.getElementById("p1").innerHTML="";
	}
}
</script>
</head>
<body style="font-family:Arial; background-color:#3385ff;">
	<div class="header">
	<h1 style="margin-left:20px;"><font size="60px"><i>ZOHO</i></font><br>
	Stock Management System</h1>
	<hr>
	<h3 style="margin-left:20px;">Shipping Manager</h3>
	
	</div>

<br><br>
<center>
<table>
    <tr>
	<td>
	<input class="func" type="button" name="quality" onclick="loadData('quality')" value="Check the quality">
	</td>
	<td>
	<input class="func" type="button" name="arrange" value="Re arrange the stock">
	</td>
</table><br><br><br>
<div id="p1"></div>
</center>
</body>
</html>