
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

<link href="https://fonts.googleapis.com/css?family=Cantata+One"
	rel="stylesheet">

<link href="https://fonts.googleapis.com/css?family=Imprima"
	rel="stylesheet">



<!-- Bootstrap -->

<link type="text/css" rel="stylesheet" href="css4/bootstrap.min.css" />



<!-- Custom stlylesheet -->

<link type="text/css" rel="stylesheet" href="css4/style.css" />



<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->

<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->

<!--[if lt IE 9]>

		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>

		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

		<![endif]-->



</head>



<body>

	<form action="TicketGenerateController" method="post" onSubmit="">



		<%
			int passenger = (Integer) session.getAttribute("passenger");

			System.out.println(passenger);
		%>

		<div id="booking" class="section">

			<div class="section-center">

				<div class="container">

					<div class="row">

						<div class="booking-cta">



							<%
								for (int i = 0; i < passenger; i++)

								{
							%>

							<center>

								<span style="color: white">Make Your Reservation for
									Passenger<%=i + 1%>
								</span>

							</center>

							<br> <br>

						</div>

						<div class="booking-form">


							<div class="col-md-2">

								<div class="form-group">

									<span class="form-label">Seat type 1</span> <select
										class="form-control" name="seattype1<%=i + 1%>">

										<option value="Select">Select</option>

										<option value="Window">Window</option>

										<option value="Aisle">Aisle</option>

										<option value="Near Emergency">Near
											Emergency</option>







									</select> <span class="select-arrow"></span>

								</div>

							</div>

							<div class="col-md-3">

								<div class="form-group">

									<span class="form-label">Seat type 2</span> <select
										class="form-control" name="seattype2<%=i + 1%>">

										<optgroup label="Seat Location Type2">

											<option value="Select">Select</option>

											<option value="Front">Front</option>

											<option value="Middle">Middle</option>

											<option value="Back">Back</option>





										</optgroup>





									</select> <span class="select-arrow"></span>

								</div>

							</div>



							<div class="col-md-3">

								<div class="form-group">

									<span class="form-label">Meal</span> <select
										class="form-control" name="meal<%=i + 1%>">

										<option value="Select">Select</option>

										<option value="Veg">Veg</option>

										<option value="Non Veg">Non Veg</option>









									</select> <span class="select-arrow"></span>

								</div>

							</div>



							<div class="col-md-4">

								<div class="form-group">

									<span class="form-label"> Handicapped</span> <select
										class="form-control" name="medical<%=i + 1%>">


											<option value="No<%=i + 1%>">No</option>

										

											<option value="Wheelchair">Wheelchairs</option>

											<option value="Nurses">Nurses</option>

											<option value="Attendants">Attendants</option>

											<option value="Special Medicines">Special
												Medicines</option>





										



									</select> <span class="select-arrow"></span>

								</div>

							</div>

							<%
								}
							%>


							<div class="col-md-4">

								<div class="form-btn">


									<p></p>
									<p></p>
									
									<button class="submit-btn" name="SpecialServices"
										value="SpecialServices">Choose Special Services</button>

								</div>

							</div>

							<form method="post" action="TicketGenerateController">

								<div class="col-md-3">

									<div class="form-btn">

										<p></p>
										<p></p>

										<button class="submit-btn" name="SkipSpecialServices"
											value="SkipSpecialServices">Skip</button>

									</div>

								</div>

							</form>



						</div>

					</div>

				</div>

			</div>

		</div>

	</form>

</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->



</html>