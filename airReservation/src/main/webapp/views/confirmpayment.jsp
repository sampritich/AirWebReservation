<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.airline.model.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
  <style>
body {

	 background: url("img/bg-registration-form-9.jpg") no-repeat right center;
	 background-size: cover;
	  min-height: 100vh;
  position: relative;

}


</style>
</head>
<body>
<form action="TicketDisplayController" method="post">
<% Ticket t=(Ticket)session.getAttribute("ticket");

int passenger=(Integer)session.getAttribute("passenger");


float actualPrice=t.getPayment();


float price=(Float)session.getAttribute("price");





%>

<center>
<h1 style="color:white">Total Amount to pay</h2>
</center>
<br>
<br>

<div class="container" >
 
  <table class="table">
    <thead>
      <tr style="color:white">
        <th>Passenger</th>
        <th>Amount</th>
        <th>Total Amount</th>
      </tr>
    </thead>
    <tbody>
     
      <tr class="table-danger">
         <td><%= passenger%></td>
        <td><%=price %></td>
        <td><%=passenger%>*<%=price%>=<%=actualPrice %></td>
      </tr>
      
    </tbody>
  </table>
</div>
<br>
<br>

<center>
<button type="submit" class="btn btn-lg btn-primary" name="checkoutconfirm" value="checkout" >Continue to check out </button>
                &nbsp;
                   <button type="submit"   class="btn btn-lg btn-primary" name="cancel"  value="cancel">Cancel booking</button>

</center>
</form>
</body>
</html>