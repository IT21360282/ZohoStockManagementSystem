/**
 * 
 */
 function loadData(name)
{
	if(name=="PlaceO")
	{
		document.getElementById("p1").innerHTML='<form method="post" action="OrderServlet"><div align="center">You only can add maximum 3 goods to a single order<br><br><button class="func" style="width:2cm;height:1cm;" type="submit" name="Order" value="PlaceOrderqty" >OK</button></div></form>';
	}
	else if (name=="PreviousO")
	{
		document.getElementById("p1").innerHTML='<form method="post" action="OrderServlet">Enter Previous Order ID Which You Want to See Details: <input class="LoginBox" style="width:150px;" type="text" name="PrevID"><button class="Button" type="submit" name="Order" value="PrevSpecOrder" >Submit</button><span style="text-align:center;"><h1>OR</h1></span>See Details of All Previous orders: <button class="Button" type="submit" name="Order" value="PrevAllOrder" >Submit</button></form>';
	}
	else if (name=="PendingO")
	{
		document.getElementById("p1").innerHTML='<form method="post" action="OrderServlet">Enter Pending Order ID Which You Want to See Details: <input class="LoginBox" style="width:155px;" type="text" name="PenID"><button class="Button" type="submit" name="Order" value="PenSpecOrder" >Submit</button><span style="text-align:center;"><h1>OR</h1></span>See Details of All Pending orders: <button class="Button" type="submit" name="Order" value="PenAllOrder" >Submit</button></form>';
	}
}

function showButtonPay(name)
{
	if(name=="card")
	{
		document.getElementById("div2").innerHTML='<form method="post" action="DisplayCardServlet"><table><tr><td>Enter Card No:<input class="LoginBox" style="width:150px;" type="text" name="CardNo"></td><td align="right" style="width:180px;" ><button class="Button" type="submit" name="card" value="SpecCard" >Submit</button></td></tr></table><span style="text-align:center;"><h1>OR</h1></span><table><tr><td>See Details of All Debit Cards :</td><td align="right" style="width:225px;"> <button class="Button" type="submit" name="card" value="AllCard" >Submit</button></td></tr></table></form><br><br>';
	}
	
	else if(name=="PayDetails")
	{
		document.getElementById("div1").innerHTML='<form method="post" action="DisplayPaymentServlet"><table><tr><td>Enter Payment ID:<input class="LoginBox" style="width:150px;" type="text" name="PayID"></td><td align="right" style="width:155px;"><button class="Button" type="submit" name="payment" value="SpecPay" >Submit</button></td></tr></table><span style="text-align:center;"><h1>OR</h1></span><table><tr><td>See Details of All Payments :</td><td align="right" style="width:238px;"> <button class="Button" type="submit" name="payment" value="AllPay" >Submit</button></td></tr></table></form><br><br>';
	}
}

function showButton()
{
	document.getElementById("div1").innerHTML='<form method="post" action="DisplaySupplierServlet"><table><tr><td>Enter Supplier Registered No:<input class="LoginBox" style="width:150px;" type="text" name="RegNo"></td><td><button class="Button" type="submit" name="Supplier" value="SpecSupplier" >Submit</button></td></tr></table><span style="text-align:center;"><h1>OR</h1></span><table><tr><td>See Details of All Supplier :</td><td align="right" style="width:250px;"> <button class="Button" type="submit" name="Supplier" value="AllSupplier" >Submit</button></td></tr></table></form><br><br>';
}