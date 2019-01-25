<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<title>Visa Form</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- LINEARICONS -->
<link rel="stylesheet" href="fonts1/linearicons/style.css">

<!-- MATERIAL DESIGN ICONIC FONT -->
<link rel="stylesheet"
	href="fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">

<!-- DATE-PICKER -->
<link rel="stylesheet" href="vendor/date-picker/css/datepicker.min.css">

<!-- STYLE CSS -->
<link rel="stylesheet" href="css5/style.css">
<style>
.checkbox {
	padding-left: 20px;
}

.checkbox-success input[type="checkbox"]:checked+label::before {
	background-color: #5cb85c;
	border-color: #5cb85c;
}

.checkbox-success input[type="checkbox"]:checked+label::after {
	color: #fff;
}
</style>
<script>

function validate(){
	
	var countryname=document.getElementById("countryname");
	
	
	
	
}

</script>
</head>

<body>

	<div class="wrapper">
		<div class="inner">
			<form action="TicketGenerateController" method="post">
				<h3>Enter your visa information</h3>
				<div class="form-row">
					<div class="form-wrapper">
						<label for=""> country that issued visa *</label> <input
							type="text" class="form-control" name="countryname"  id="countryname" placeholder="Country">
					</div>
					<div class="form-wrapper">
						<label for="">Visa identity number(unique) *</label> <input
							type="text" class="form-control" name="visaid"placeholder="Visa Id">
					</div>
				</div>
				<div class="form-row">
					<div class="form-wrapper">
						<label for=""> Date of the visa issue *</label> <span
							class="lnr lnr-calendar-full"></span> <input type="date"
							class="form-control datepicker-here" name="issuedate">
					</div>
					<div class="form-wrapper">
						<label for="">Date of the visa expiry*</label> <span
							class="lnr lnr-calendar-full"></span> <input type="date"
							class="form-control datepicker-here" name="expirydate">
					</div>
				</div>

				<div class="form-group">
					<div class="form-check">
						<input class="form-check-input" type="checkbox" value=""
							id="invalidCheck2" required> <label
							class="form-check-label" for="invalidCheck2"> <a href="">Agree
								to terms and conditions</a> <br> <span>read terms and
								conditions</span>
						</label>
					</div>
				</div>



					<button class="submit-btn" name="visa"
											value="visa">Pay Now</button>
			</form>
		</div>
	</div>

	<script src="js1/jquery-3.3.1.min.js"></script>

	<!-- DATE-PICKER -->
	<script src="vendor/date-picker/js/datepicker.js"></script>
	<script src="vendor/date-picker/js/datepicker.en.js"></script>

	<script src="js1/main.js"></script>
</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>