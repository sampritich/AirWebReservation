<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.airline.model.*" %>
    <%@ page import="java.util.*" %>
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
<% 


List<Ticket> tlist=(List<Ticket>)session.getAttribute("userticketdetails");



for(Ticket t:tlist){

//System.out.println(t.getPayment());
}

//float actualPrice=t.getPayment();


//float price=(Float)session.getAttribute("price");





%>

<center>
<h1 style="color:white">Your Ticket Details</h2>
</center>
<br>
<br>

<div class="container" >
 
  <table class="table">
    <thead>
      <tr style="color:white">
        <th>TicketId</th>
        <th>PassengerCount</th>
        <th>Payment</th>
               
        
                <th>Status</th>
        
                <th>FlghtId</th>
                                <th>EmailId</th>
                                <th>Date</th>
                                <th>cancel</th>
                                <th>Book</th>
                               
                
        
      </tr>
    </thead>
    
    <tbody>
    
     <%
     
     if(tlist.size()!=0){
     
     
     for(Ticket t:tlist) { %>
     
     
      <tr class="table-danger">
         <td><%= t.getTicketId()%></td>
        <td><%=t.getPassengerCount() %></td>
                <td><%=t.getPayment()%></td>
                
                        <td><%=t.getStatus()%></td>
                        <% String flightId=t.getFlight().getFlightId();
                        
                        String emailId=t.getUser().getEmailId();
                        
                        Date date=t.getFlight().getDate();
                        %>
                                <td><%=flightId %></td>
                                                                 <td><%=emailId %></td>
                                                                 
                          <td><%=date %>
                          
                          <form action="TicketDisplayController" method="post">
                       <td>  <button type="submit" class="btn btn-lg btn-primary" name="cancelticket" value="cancel" >Cancel </button>  </td>                                   
                         
                        
                
                <% if((t.getStatus().contains("PreBook")) || (t.getStatus().contains("Reserve")) ) { %>
                
                
                                                         
                <td>  <button type="submit" class="btn btn-lg btn-primary" name="Booked" value=<%=t.getTicketId() %>>Book</button>
                                   
                                         
                                          </td>               
                
                
                
                <%} 
                else { %>
                  <td>  <button type="submit" class="btn btn-lg btn-primary"   name="bookticket" disabled value="bookticket" >Book </button>  </td> 
                                                                            
                
                 <input type="hidden" name="flightid" value=<%=t.getFlight().getFlightId()%>>
                                  <input type="hidden" name="ticketid" value=<%=t.getTicketId()%>>
                                   <input type="hidden" name="ticketstatus" value=<%=t.getStatus()%>>
                 
				<input type="hidden" name="airlinename"
					value=<%=t.getFlight().getAirlineName()%>> <input type="hidden"
					name="source" value=<%=t.getFlight().getSource()%>> <input
					type="hidden" name="destination" value=<%=t.getFlight().getDestination()%>>
				<input type="hidden" name="date" value=<%=t.getFlight().getDate()%>> <input
					type="hidden" name="departuretime" value=<%=t.getFlight().getDepartureTime()%>>
				<input type="hidden" name="arrivaltime"
					value=<%=t.getFlight().getArrivalTime()%>> <input type="hidden"
					name="duration" value=<%=t.getFlight().getDuration()%>> <input
					type="hidden" name="businessseat" value=<%=t.getFlight().getBusinessSeat()%>>
				<input type="hidden" name="businessprice"
					value=<%=t.getFlight().getBusinessPrice()%>> <input type="hidden"
					name="economyseat" value=<%=t.getFlight().getEconomySeat()%>> <input
					type="hidden" name="economyprice" value=<%=t.getFlight().getEconomyPrice()%>>
                
                
                
                
                <%} %>
        
      </tr>
      </form>
      
      
      <%}
     
      
      }%>
      
    </tbody>
  </table>
</div>
<br>
<br>


</body>
</html>