<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.airline.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
  font-family: Arial;
  font-size: 17px;
  padding: 8px;
}

* {
  box-sizing: border-box;
}

.row {
  display: -ms-flexbox; /* IE10 */
  display: flex;
  -ms-flex-wrap: wrap; /* IE10 */
  flex-wrap: wrap;
  margin: 0 -16px;
}

.col-25 {
  -ms-flex: 25%; /* IE10 */
  flex: 25%;
}

.col-50 {
  -ms-flex: 50%; /* IE10 */
  flex: 50%;
}

.col-75 {
  -ms-flex: 75%; /* IE10 */
  flex: 75%;
}

.col-25,
.col-50,
.col-75 {
  padding: 0 16px;
}

.container {
  background-color: #f2f2f2;
  padding: 5px 20px 15px 20px;
  border: 1px solid lightgrey;
  border-radius: 3px;
}

input[type=text] {
  width: 100%;
  margin-bottom: 20px;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 3px;
}

label {
  margin-bottom: 10px;
  display: block;
}

.icon-container {
  margin-bottom: 20px;
  padding: 7px 0;
  font-size: 24px;
}

.btn {
  background-color: #4CAF50;
  color: white;
  padding: 12px;
  margin: 10px 0;
  border: none;
  width: 100%;
  border-radius: 3px;
  cursor: pointer;
  font-size: 17px;
}

.btn:hover {
  background-color: #45a049;
}

a {
  color: #2196F3;
}

hr {
  border: 1px solid lightgrey;
}

span.price {
  float: right;
  color: grey;
}

/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other (also change the direction - make the "cart" column go on top) */
@media (max-width: 800px) {
  .row {
    flex-direction: column-reverse;
  }
  .col-25 {
    margin-bottom: 20px;
  }
}
</style>



<script>

function validate(){
	
	var status=false;
	
	var cardname=document.getElementById("cardname").value;
	
	var cardnumber=document.getElementById("cardnumber").value;
	
	var expmonth=document.getElementById("expmonth").value;
	
	var expyear=document.getElementById("expyear").value;
	
	var cvv=document.getElementById("cvv").value;
	
	if(cardname==""){
		alert("name cant be empty");
		
	}
	
	else{
		if(cardnumber.length<16 || isNaN(cardnumber)){
			alert("enter valid card number");
		}
		else{
			if(expmonth==""){
				alert(" month cant be empty");
			}
			else{
				if(expyear.length!=4 || isNaN(expyear)){
					alert(" year cant be empty");
				}
				else{
					
					if(cvv.length<3 || cvv.length>3){
					alert("enter correct cvv")
					}
					else{
						status=true;
					}
					
					
					
				}
				
			}
		}
	}
	return status;
}

</script>
</head>
<body>
<% Ticket t=(Ticket)session.getAttribute("ticket");

int passenger=(Integer)session.getAttribute("passenger");


float actualPrice=t.getPayment();


float price=(Float)session.getAttribute("price");





%>
<center>
<h2>Your total payable amount <%=actualPrice %></h2>
  
   </center> 
    
    
    
    
    
    
    
    
    
<div class="row">
  <div class="col-75">
    <div class="container">
      <form action="TicketDisplayController" method="post" onsubmit="return validate()">
      
        
          
          <div class="col-50">
            <h3>Payment</h3>
            <label for="fname">Accepted Cards</label>
            <div class="icon-container">
              <i class="fa fa-cc-visa" style="color:navy;"></i>
              <i class="fa fa-cc-amex" style="color:blue;"></i>
              <i class="fa fa-cc-mastercard" style="color:red;"></i>
              <i class="fa fa-cc-discover" style="color:orange;"></i>
            </div>
            <label for="cname">Name on Card</label>
            <input type="text"  name="cardname"  id="cardname"/>
            <label for="ccnum">Credit card number</label>
            <input type="text"  name="cardnumber" id="cardnumber"/>
            <label for="expmonth">Exp Month</label>
            <input type="text" id="expmonth" name="expmonth" placeholder="September">
            <div class="row">
              <div class="col-50">
                <label for="expyear">Exp Year</label>
                <input type="text" id="expyear" name="expyear" placeholder="2018">
              </div>
              <div class="col-50">
                <label for="cvv">CVV</label>
                <input type="text" id="cvv" name="cvv" placeholder="352">
              </div>
            </div>
          </div>
          
        </div>
        
        <input type="submit" name="checkout" value="Continue to checkout" class="btn">
      </form>
    </div>
  </div>
  
</div>

</body>
</html>
