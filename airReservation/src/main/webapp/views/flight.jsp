<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*"%>

<%@page import="com.airline.model.*"%>

<%@page import="com.airline.controller.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flight Details</title>
<style>


body { background-image: linear-gradient(#abc 100%, #000);}

h1, table { text-align: center; }

table {border-collapse: collapse;  width: 70%; margin: 0 auto 7rem;}

th, td { padding: 0.2rem; font-size: 1.3rem; }

tr {background: hsl(50, 50%, 80%); }

tr, td { transition: .2s ease-in; } 

tr:first-child {background: hsla(12, 100%, 40%, 0.5); }

tr:nth-child(even) { background: hsla(50, 50%, 80%, 0.7); }

td:empty {background: hsla(50, 25%, 60%, 0.7); }

tr:hover:not(#firstrow), tr:hover td:empty {background: #ff0; pointer-events: visible;}
tr:hover:not(#firstrow) { transform: scale(1.05); font-weight: 500; box-shadow: 0px 3px 7px rgba(0, 0, 0, 0.5);}
</style>
</head>
<body>

	<%
		User user = (User) session.getAttribute("user");
		int passenger = (Integer) session.getAttribute("passenger");
		System.out.print(passenger);
		if (user != null)

		{
	%>

	<h2><%=user.getEmailId()%></h2>

	<%
		}
	%>
	<h1>Flight List</h1>
	<table id="racetimes">
		<tr id="firstrow">
		<th>Flight Id</th>
				<th>Airline Name</th>
				<th>Departure</th>
				<th>Arrival</th>

				<th>Date</th>
				<th>Departure Time</th>
				<th>Arrival Time</th>
				<th>Duration</th>

				<th>Business Seat</th>
				<th>Business Seat Price</th>
				<th>Economy Seat</th>

				<th>Economy Seat Price</th>
				<th>Booking Status</th>
				
				<%
			
					if (user != null)
			
					{
				%>
				<th>ReserveSeat</th>
				<th>PrebookSeat</th>
				<%
					}
				%>

		</tr>
		<tr>
			<%
				List<Flight> flightlist = (List<Flight>) session.getAttribute("flights");

				for (Flight f : flightlist) {
			%>

			<td><%=f.getFlightId()%></td>

			<td><%=f.getAirlineName()%></td>

			<td><%=f.getSource()%></td>

			<td><%=f.getDestination()%></td>

			<td><%=f.getDate()%></td>

			<td><%=f.getDepartureTime()%></td>

			<td><%=f.getArrivalTime()%></td>

			<td><%=f.getDuration()%></td>

			<td><%=f.getBusinessSeat()%></td>

			<td><%=f.getBusinessPrice()%></td>

			<td><%=f.getEconomySeat()%></td>

			<td><%=f.getEconomyPrice()%></td>

			<form method="post" action="FlightDetailsController">
				
				<td>
					<button type="submit" class="btn btn-success"

						style="background-color: #32CD32;" name="Booked" value="Economy">BOOK Economy</button>

						<br>

						<button type="submit" class="btn btn-success"

						style="background-color: #32CD32;" name="Booked" value="Business">BOOK Business</button>
				</td>

				<%
			
					if (user != null)
			
					{
				%>
				<td>
					<button type="submit" class="btn btn-success"

						style="background-color: #32CD32;" name="Reserve" value="Economy">Reserve

						Economy</button>

						

						<br>

						<button type="submit" class="btn btn-success"

						style="background-color: #32CD32;" name="Reserve" value="Business">Reserve

						Buisness</button>
				</td>

				<td>
					<button type="submit" class="btn btn-success"

						style="background-color: #32CD32;" name="PreBook" value="Economy">Prebook

						Economy</button>

						<br>

						<button type="submit" class="btn btn-success"

						style="background-color: #32CD32;" name="PreBook" value="Business">Prebook

						Buisness</button>
				<%
					}
				%>	
				</td>
				 <input type="hidden" name="flightid" value=<%=f.getFlightId()%>>
				<input type="hidden" name="airlinename"
					value=<%=f.getAirlineName()%>> <input type="hidden"
					name="source" value=<%=f.getSource()%>> <input
					type="hidden" name="destination" value=<%=f.getDestination()%>>
				<input type="hidden" name="date" value=<%=f.getDate()%>> <input
					type="hidden" name="departuretime" value=<%=f.getDepartureTime()%>>
				<input type="hidden" name="arrivaltime"
					value=<%=f.getArrivalTime()%>> <input type="hidden"
					name="duration" value=<%=f.getDuration()%>> <input
					type="hidden" name="businessseat" value=<%=f.getBusinessSeat()%>>
				<input type="hidden" name="businessprice"
					value=<%=f.getBusinessPrice()%>> <input type="hidden"
					name="economyseat" value=<%=f.getEconomySeat()%>> <input
					type="hidden" name="economyprice" value=<%=f.getEconomyPrice()%>>





			</form>





			</tr>







			<%
				}
			%>
			
		
	</table>

 </body>
</html>

