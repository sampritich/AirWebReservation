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

<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->



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



	<div id="booking" class="section">





		<div class="section-center">

			<div class="container">

				<div class="row">

					<div class="booking-form">

						<form action="FlightController" method="post">
						
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


</body>



</html>