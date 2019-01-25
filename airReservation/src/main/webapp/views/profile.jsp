<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="com.airline.model.*"%>

<%@ page import="java.util.*"%>

<%@ page import="java.text.SimpleDateFormat"%>



<!DOCTYPE html>

<html lang="en">



<head>

<meta charset="utf-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge">

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">


<title>Booking Form HTML Template</title>



<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">



<!-- jQuery library -->

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>



<!-- Latest compiled JavaScript -->

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>



<!-- Google font -->

<link href="https://fonts.googleapis.com/css?family=Hind:400,700"
	rel="stylesheet">



<!-- Bootstrap -->

<link type="text/css" rel="stylesheet" href="css/css1/bootstrap.min.css" />



<!-- Custom stlylesheet -->

<link type="text/css" rel="stylesheet" href="css/css1/style.css" />



<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->

<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->

<!--[if lt IE 9]>

		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>

		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

		<![endif]-->
		<style type="text/css">
		
		
		body {font-family: Arial, Helvetica, sans-serif;}
form {border: 3px solid #f1f1f1;}

input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}

.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}

.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
}

img.avatar {
  width: 40%;
  border-radius: 50%;
}

.container {
  padding: 16px;
}

span.psw {
  float: right;
  padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 100%;
  }
}
    body {
  font-family: "Lato", sans-serif;
}

.sidenav {
  height: 100%;
  width: 0;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  background-color: #111;
  overflow-x: hidden;
  transition: 0.5s;
  padding-top: 60px;
}

.sidenav a {
  padding: 8px 8px 8px 32px;
  text-decoration: none;
  font-size: 25px;
  color: #818181;
  display: block;
  transition: 0.3s;
}

.sidenav a:hover {
  color: #f1f1f1;
}

.sidenav .closebtn {
  position: absolute;
  top: 0;
  right: 25px;
  font-size: 36px;
  margin-left: 50px;
}

@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		</style>
		<script type="text/javascript">
		
		
		function searchValidation()
		{
			
			var source = document.getElementById("source").value;
			var destination = document.getElementById("destination").value;
			var status = false;
			var s=1;
			var d=1;
			if(source == "Select")
			{
				alert("Source is Mandatory");
			}
			else
			{
				s=0;
			}
			if( destination == "Select" )
			{
				alert("Destination is Mandatory");
			}
			else
			{
				d=0;
			}
			
			if(s==0 && d==0)
			{
				status = true;
			}
			
			return status;
		}
		
		
		
		
		
		
		</script>



</head>



<body>

	<%

						User user=new User();
						user=(User)session.getAttribute("user");
						String name=user.getEmailId();
						
						System.out.println(user.getEmailId());
	                   Date date=new Date();
	
                        System.out.println(date);

                        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");

                        String d=sdf.format(date);

                        System.out.println(d);

					%>
<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  
        <a href='TicketDisplayController?profile=profile'>Profile Information</a>
  
  <a href='TicketDisplayController?profile=booking'>Your Booking details</a>
  <a href='TicketDisplayController?profile=information'>Your Information</a>
    <a href='TicketDisplayController?profile=reserve'>Your Reserve Ticket Information</a>
  
 <a href='TicketDisplayController?profile=cupons'>Coupons</a>

  <a href="#">Contact</a>
   <a href='TicketDisplayController?profile=logout'>Logout</a>
  
 
</div>
<span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; Profile</span>








	<div id="booking" class="section">





		<div class="section-center">

			<div class="container">

				<div class="row">

					<div class="booking-form">

						<form action="FlightController" method="post" onsubmit="return searchValidation()">
						
					<%if(user!=null){ %>	
						
						
						<h1 style="color:white">Welcome <%=name %></h1>
<% }%>
							<div class="row">

								<div class="col-md-6">
									<div class="textfield-search one-third " align="center">

										<div class="form-group" align="center">

											<label style="color: white">Source</label>
											 <select align="center" class="form-control" id="source" name="source">

												<option>Select</option>
												<%
													List<Cities> cityList = (List<Cities>) session.getAttribute("citylist");
													for(Cities c:cityList)
													{
														String str = c.getCityName()+"("+c.getAbbreviations()+")";
												%>
												
												<option value=<%=c.getCityName() %>><%=str %></option>
												<%
													}
												%>

											</select>

										</div>
									</div>

								</div>
							</div>
							<br>
							<div class="row">

								<div class="col-md-6">
									<div class="textfield-search one-third">

										<div class="form-group" align="center">

											<label style="color: white">Destination</label> 
											
											<select class="form-control" id="destination" name="destination">

												<option>Select</option>
												<%
													for(Cities c:cityList)
													{
														String str = c.getCityName()+"("+c.getAbbreviations()+")";
												%>
												
												<option value=<%=c.getCityName() %>><%=str %></option>
												<%
													}
												%>
											</select>

										</div>
									</div>

								</div>
							</div>
							<br>
							<div class="row">

								<div class="col-md-6">
									<div class="textfield-search one-third">

										<div class="form-group" align="center">


											<label style="color: white">Journey Date</label> <input
												type="date" name="date" id="date" class="form-control"
												placeholder=<%=d%>>
										</div>

									</div>

								</div>
							</div>
							<br>
														<div class="row">

								<div class="col-md-6">
									<div class="textfield-search one-third">

										<div class="form-group" align="center">

											<label style="color: white">Passenger</label> 
											

												 <select class="form-control" id="passenger" name="passenger">
								 	
												 	<option>Select</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
												
												</select>


										</div>
									</div>

								</div>
							</div>
							<br>

							<div class="row">

								<div class="form-btn">

									<input type="submit" class="submit-btn" name="Flights" value="Flights">

								</div>
							</div>
						</form>

					</div>

				</div>

			</div>
		</div>
	</div>
<script>
function openNav() {
  document.getElementById("mySidenav").style.width = "250px";
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
}
</script>

</body>



</html>