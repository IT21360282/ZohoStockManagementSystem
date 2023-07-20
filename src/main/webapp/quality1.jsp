<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quality 1</title>
<link rel = "stylesheet"  href="Styles.css">
</head>
<body style="font-family:Arial; background-color:#3385ff;">
	<div class="header">
	<h1 style="margin-left:20px;"><font size="60px"><i>ZOHO</i></font><br>
	Stock Management System</h1>
	<hr>
	<h3 style="margin-left:20px;">Shipping Manager</h3>
	
	</div>
	
 
 <div class="BodyDivTable" >
 
 <h1><span style="color:orange">Please tick according to</span> the relevant product</h1>
 <br>
 <form method="post" action="QualityValidationServlet">

 <table style="margin:auto; width:65%; text-align:left">
 <tr>
     <th class="qualityT">Condition</th>
     <th class="qualityT">Yes</th>
    
 </tr>
 <tr>
     <td class="qualityT">Reliability</td>
     <td class="qualityT"><input class="center" type="checkbox" name="quality"></td>
  
 </tr>
 <tr>
     <td class="qualityT">Durability</td>
     <td class="qualityT"><input class="center" type="checkbox" name="quality"></td>
     
 </tr>
 <tr>
     <td class="qualityT">User-friendliness</td>
     <td class="qualityT"><input class="center" type="checkbox" name="quality" value="UserFriendliness"></td>
    
 </tr>
 <tr>
     <td class="qualityT">Design Quality</td>
     <td class="qualityT"><input class="center" type="checkbox" name="quality" value="DesignQuality"></td>
    
 </tr>
 <tr>
     <td class="qualityT">Safety</td>
     <td class="qualityT"><input class="center" type="checkbox" name="quality" value="Safety"></td>
     
 </tr>
 <tr>
     <td class="qualityT">Great Positioning</td>
     <td class="qualityT"><input class="center" type="checkbox" name="quality" value="GreatPositioning"></td>
     
 </tr>
 <tr>
     <td class="qualityT">Efficient Marketing</td>
     <td class="qualityT"><input class="center" type="checkbox" name="quality" value="EfficientMarketing"></td>
     
 </tr>
 <tr>
     <td class="qualityT">Proper Storage</td>
     <td class="qualityT"><input class="center" type="checkbox" name="quality" value="ProperStorage"></td>
     
 </tr>
 </table>
 <br>
 <div>
 <input class="func" type="submit" value="Validate" /><br><br>
 <input class="func" type="button" value="Next" /><br><br>
 <input class="func" type="button" value="Back" /><br><br>
</div>
</form>
<div>
				<form method= "post" action="BackDescriptionServlet"><button class="func" type="submit" name="button" value="SM">Back to Profile</button></form><br><br>
			</div>
</div>
</body>
</html>