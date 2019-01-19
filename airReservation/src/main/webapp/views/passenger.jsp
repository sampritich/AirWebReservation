<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="en">



<head>

<meta charset="utf-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge">

<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->



<title>Booking Form HTML Template</title>



<!-- Google font -->

<link href="https://fonts.googleapis.com/css?family=PT+Sans:400"
	rel="stylesheet">



<!-- Bootstrap -->

<link type="text/css" rel="stylesheet" href="css3/bootstrap.min.css" />




<link type="text/css" rel="stylesheet" href="css3/style.css" />

<script language="javascript" src="js/passenger.js"></script>






</head>



<body>

	<%
		int passenger = (Integer) session.getAttribute("passenger");

		System.out.println(passenger);
	%>

	<div id="booking" class="section">

		<div class="section-center">

			<div class="container">

				<div class="row">

					<div class="booking-form">

						<h1 style="color: #f23e3e">Add Passenger Details</h1>

						<form action="TicketGenerateController" method="post"
							onSubmit="return onCheck()">

							<%
								for (int i = 0; i < passenger; i++)

								{
							%>
							<center>
								<span style="color: white">Passenger <%=i + 1%></span>
							</center>
							<div class="form-group">

								<div align="center">

									<div class="form-check form-check-inline">

										<input type="hidden" id="passenger" value=<%=passenger%>>

										<input type="radio" class="form-check-input"
											id="salutation<%=i + 1%>" name="salutation<%=i + 1%>"
											value="Mr." checked> <label class="form-check-label"
											for="materialInline" style="color: white">Mr.</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;


										<input type="radio" class="form-check-input"
											id="salutation<%=i + 1%>" name="salutation<%=i + 1%>"
											value="Mrs."> <label class="form-check-label"
											for="materialInline" style="color: white">Mrs.</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;


										<input type="radio" class="form-check-input"
											id="salutation<%=i + 1%>" name="salutation<%=i + 1%>"
											value="Miss."> <label class="form-check-label"
											for="materialInline" style="color: white">Miss.</label>

									</div>

								</div>

							</div>

							<div class="row">

								<div class="col-md-4">

									<div class="form-group">

										<span class="form-label">FirstName</span> <input
											class="form-control" type="text"
											placeholder="Enter your Firstname" id="firstname<%=i + 1%>"
											name="firstname<%=i + 1%>">

									</div>

								</div>

								<div class="col-md-4">

									<div class="form-group">

										<span class="form-label">LastName</span> <input
											class="form-control" type="text"
											placeholder="Enter Your Lastname" id="lastname<%=i + 1%>"
											name="lastname<%=i + 1%>">

									</div>

								</div>
								
								<div class="col-md-2">

								<div class="form-group">

									<span class="form-label">Type of passenger</span>

									<select class="form-control" id="passengertype<%=i+1%>" name="passengertype<%=i+1%>">
									

									<option value="Regular" selected>Regular </option>

									

										<option value="Student">Student </option>

										<option value="Handicapped">Handicapped</option>

										<option value="Senior Citizen">Senior citizen</option>

                                        <option value="Airline Staff">Airline Staff</option>

                                     <option  value="Defense Personnel">Defense personnel</option>





									</select>

									<span class="select-arrow"></span>

								</div>

							</div>

							</div>





							<%
								}
							%>



							<div class="row">

								<div class="col-md-3">

									<div class="form-btn">

										<button class="submit-btn" name="Book" value="Book">Book
											Now</button>

									</div>

								</div>



							</div>



						</form>

					</div>

				</div>

			</div>

		</div>

	</div>

</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->



</html>

