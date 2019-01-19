<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

	pageEncoding="ISO-8859-1"%>

	    <%@ page import="java.util.*" %>
	    <%@ page import="com.airline.model.*" %>

	<%@ page import="java.text.SimpleDateFormat" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html lang="en">

  <head>

    <title>Index Page</title>

    <meta charset="utf-8">

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <link href="https://fonts.googleapis.com/css?family=Muli:300,400,600,700" rel="stylesheet">



    <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">

    <link rel="stylesheet" href="css/animate.css">

    

    <link rel="stylesheet" href="css/owl.carousel.min.css">

    <link rel="stylesheet" href="css/owl.theme.default.min.css">

    <link rel="stylesheet" href="css/magnific-popup.css">



    <link rel="stylesheet" href="css/aos.css">



    <link rel="stylesheet" href="css/ionicons.min.css">



    <link rel="stylesheet" href="css/bootstrap-datepicker.css">

    <link rel="stylesheet" href="css/jquery.timepicker.css">



    

    <link rel="stylesheet" href="css/flaticon.css">

    <link rel="stylesheet" href="css/icomoon.css">

    <link rel="stylesheet" href="css/style.css">
    



  </head>

  <body>

    <div id="ftco-nav">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <a class="navbar-brand" href="#">AIRLINE</a>

  <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a href="#" data-toggle="modal"
					data-target="#modalLoginForm" class="nav-link">Login</a>
      </li>
      <li class="nav-item">
        <a href="#" data-toggle="modal"
					data-target="#modalRegisterForm" class="nav-link">SignUp</a></li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>
          
        </div>
          		<form method="post" action="MainController">
			<div class="modal fade" id="modalLoginForm" tabindex="-1"
				role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header text-center">

							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body mx-3">
							<div class="md-form mb-5">

								<label data-error="wrong" data-success="right"
									for="defaultForm-email" class="glyphicon glyphicon-envelope">
									Your email</label> <input type="email" id="defaultForm-email"
									name="email" placeholder="Email" class="form-control validate">

							</div>

							<div class="md-form mb-4">
								<label data-error="wrong" data-success="right"
									for="defaultForm-pass" class="glyphicon glyphicon-lock">
									Your password</label> <input type="password" id="defaultForm-pass"
									name="password" placeholder="Password"
									class="form-control validate">

							</div>

						</div>
						<div style="text-align: center">
							<input type="submit" class="btn btn-primary" name="Login"
								value="Login" style="text-align: center">
						</div>
						<div class="modal-footer">
							<div class="options text-center text-md-right mt-1">
								<p>
									Not a member? <a href="#" data-toggle="modal"
										data-target="#modalRegisterForm" class="blue-text">Sign Up</a>
								</p>
								<p>
									Forgot <a href="#" class="blue-text">Password?</a>
								</p>
							</div>
							<button type="button"
								class="btn btn-outline-info waves-effect ml-auto"
								data-dismiss="modal" style="text-align: center">Close</button>
						</div>
					</div>
				</div>
			</div>
		</form>
          

          <form method="post" action="MainController">
			<div class="modal fade" id="modalRegisterForm" tabindex="-1"
				role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header text-center">
							<h4 style="text-align: center">
								<strong>Sign Up</strong>
							</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body mx-3">

							<div class="md-form mb-5">

								<label data-error="wrong" data-success="right"
									for="orangeForm-email"><span
									class="glyphicon glyphicon-user">Your email</span></label> <input
									type="email" name="email" id="orangeForm-email"
									placeholder="Email" class="form-control validate">
							</div>

							<div class="md-form mb-5">

								<label data-error="wrong" data-success="right"
									for="orangeForm-email"><span
									class="glyphicon glyphicon-earphone">Your Contact Number</span></label>
								<input type="text" name="contact" id="orangeForm-phone"
									placeholder="phone number" class="form-control validate">
							</div>

							<div class="md-form mb-5">
								<label data-error="wrong" data-success="right"
									for="orangeForm-pass"><span
									class="glyphicon glyphicon-lock">Your password</span></label> <input
									type="password" name="password" id="orangeForm-pass"
									placeholder="password" class="form-control validate">

							</div>

							<div class="md-form mb-5">
								<label data-error="wrong" data-success="right"
									for="orangeForm-name"><span
									class="glyphicon glyphicon-lock">Re-enter Your password</span></label>
								<input type="password" name="confirmpassword"
									id="orangeForm-repass" placeholder="re-password"
									class="form-control validate">

							</div>

						</div>
						<div style="text-align: center">
							<input type="submit" name="Signup" value="Signup"
								class="btn btn-primary" style="text-align: center">
						</div>
						<div class="modal-footer">
							<div class="options text-center text-md-right mt-1">
								<p>
									Already Register? <a href="#" data-toggle="modal"
										data-target="#modalLoginForm" class="blue-text">Sign In</a>
								</p>
							</div>
							<button type="button"
								class="btn btn-outline-info waves-effect ml-auto"
								data-dismiss="modal" style="text-align: center">Close</button>
						</div>

					</div>
				</div>
			</div>
		</form>

    </nav>

    <!-- END nav -->

    

    <section class="home-slider owl-carousel">

      <div class="slider-item" style="background-image: url('images/bg_4.jpg');">

        <div class="overlay"></div>

        <div class="container">

          <div class="row slider-text align-items-center">

            <div class="col-md-7 col-sm-12 ftco-animate">

              <h1 class="mb-3">Experience the best trip ever through our AIRLINE</h1>

            </div>

          </div>

        </div>

      </div>



      <div class="slider-item" style="background-image: url('images/bg_1.jpg');">

        <div class="overlay"></div>

        <div class="container">

          <div class="row slider-text align-items-center">

            <div class="col-md-7 col-sm-12 ftco-animate">

              <h1 class="mb-3">Making the most out of your holiday</h1>

            </div>

          </div>

        </div>

      </div>



      <div class="slider-item" style="background-image: url('images/bg_3.jpg');">

        <div class="overlay"></div>

        <div class="container">

          <div class="row slider-text align-items-center">

            <div class="col-md-7 col-sm-12 ftco-animate">

              <h1 class="mb-3">Travel Operator Just For You</h1>

            </div>

          </div>

        </div>

      </div>

    </section>

    <!-- END slider -->



    <div class="ftco-section-search">

      <div class="container">

        <div class="row">

          <div class="col-md-12 tabulation-search">

              <p></p>

            <div class="tab-content py-5" id="v-pills-tabContent">

              <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab">

                <div class="block-17">

                    

                    <%

                        Date date=new Date();

                        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");

                        String d=sdf.format(date);

					%>

                        

                  <form action="MainController" method="post" class="d-block d-lg-flex">

                    <div class="fields d-block d-lg-flex">



                      <div class="textfield-search one-third" style="background-color:#ff5f5f">

                          <div class="form-group"> 

                              <label style="color:white" >Source</label>

								<select class="form-control" id="source" name="source">
						
									<option style="background-color:#ff5f5f">Select</option>
									<%
										List<Cities> cityList = (List<Cities>) request.getAttribute("citylist");
										for(Cities c:cityList)
										{
											String str = c.getCityName()+"("+c.getAbbreviations()+")";
									%>
									
									<option style="background-color:#ff5f5f" value=<%=c.getCityName() %>><%=str %></option>
									<%
										}
									%>
							<!--  		<option value="KOLKATA">Kolkata(CCU)</option>

									<option value="JAIPUR">Jaipur(JAI)</option>

									<option value="MUMBAI">Mumbai(BOM)</option> -->

								</select>

							</div>
						</div>



                      <div class="check-in one-third">

                          <div class="form-group">

                              <label style="color:white">Destination</label>

								 <select class="form-control" id="destination" name="destination">
								 	
								 	<option style="background-color:#ff5f5f">Select</option>

									<%
									for(Cities c:cityList)
									{
										String str = c.getCityName()+"("+c.getAbbreviations()+")";

									
									%>
									
									<option style="background-color:#ff5f5f" value=<%=c.getCityName() %>><%=str %></option>
									<%
										}
									%>

								</select>

							</div></div>



                      <div class="check-out one-third">

                          <label style="color:white" >Journey Date</label>

                          <input type="date" name="date" id="date" class="form-control" placeholder=<%=d%>>
                     </div>
                     
                      <div class="check-in one-third">

                          <div class="form-group">

                              <label style="color:white">Passenger</label>

								 <select class="form-control" id="passenger" name="passenger">
								 	
								 	<option style="background-color:#ff5f5f">Select</option>
									<option style="background-color:#ff5f5f" value="1">1</option>
									<option style="background-color:#ff5f5f" value="2">2</option>
									<option style="background-color:#ff5f5f" value="3">3</option>
									<option style="background-color:#ff5f5f" value="4">4</option>
								
								</select>

							</div></div>

					<input type="submit" class="search-submit btn-primary" name="Flights" value="Flights"> 
					
                    </div>

                     
                    

                  </form>

                </div>

                </div>

              </div>

            </div>

          </div>

        </div>

      </div>



    

    

    <footer class="ftco-footer ftco-bg-dark ftco-section">

      <div class="container">

        <div class="row mb-5">

          <div class="col-md">

            <div class="ftco-footer-widget mb-4">

              <h2 class="ftco-heading-2">Airline Fellow Tourist</h2>

              <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>

            </div>

          </div>

          <div class="col-md">

             <div class="ftco-footer-widget mb-4">

              <h2 class="ftco-heading-2">Book Now</h2>

              <ul class="list-unstyled">

                <li><a href="#" class="py-2 d-block">Flight</a></li>

                <li><a href="#" class="py-2 d-block">Hotels</a></li>

                <li><a href="#" class="py-2 d-block">Tour</a></li>

                <li><a href="#" class="py-2 d-block">Car Rent</a></li>

                <li><a href="#" class="py-2 d-block">Beach &amp; Resorts</a></li>

                <li><a href="#" class="py-2 d-block">Mountains</a></li>

                <li><a href="#" class="py-2 d-block">Cruises</a></li>

              </ul>

            </div>

          </div>

          <div class="col-md">

             <div class="ftco-footer-widget mb-4">

              <h2 class="ftco-heading-2">Top Deals</h2>

              <ul class="list-unstyled">

                <li><a href="#" class="py-2 d-block">Luxe Hotel</a></li>

                <li><a href="#" class="py-2 d-block">Venice Tours</a></li>

                <li><a href="#" class="py-2 d-block">Deluxe Hotels</a></li>

                <li><a href="#" class="py-2 d-block">Boracay Beach &amp; Resorts</a></li>

                <li><a href="#" class="py-2 d-block">Beach &amp; Resorts</a></li>

                <li><a href="#" class="py-2 d-block">Fuente Villa</a></li>

                <li><a href="#" class="py-2 d-block">Japan Tours</a></li>

                <li><a href="#" class="py-2 d-block">Philippines Tours</a></li>

              </ul>

            </div>

          </div>

          <div class="col-md">

             <div class="ftco-footer-widget mb-4">

              <h2 class="ftco-heading-2">Contact Information</h2>

              <ul class="list-unstyled">

                <li><a href="#" class="py-2 d-block">198 West 21th Street, Suite 721 New York NY 10016</a></li>

                <li><a href="#" class="py-2 d-block">+ 1235 2355 98</a></li>

                <li><a href="#" class="py-2 d-block">info@yoursite.com</a></li>

                <li><a href="#" class="py-2 d-block">email@email.com</a></li>

              </ul>

            </div>

          </div>

          <div class="col-md">

            <div class="ftco-footer-widget mb-4">

              <ul class="ftco-footer-social list-unstyled float-md-right float-lft">

                <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>

                <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>

                <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>

              </ul>

            </div>

          </div>

        </div>

        <div class="row">

          <div class="col-md-12 text-center">



            <p>

                Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved

            </p>

          </div>

        </div>

      </div>

    </footer>

    

  



  <!-- loader -->

  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>





  <script src="js/jquery.min.js"></script>

  <script src="js/jquery-migrate-3.0.1.min.js"></script>

  <script src="js/popper.min.js"></script>

  <script src="js/bootstrap.min.js"></script>

  <script src="js/jquery.easing.1.3.js"></script>

  <script src="js/jquery.waypoints.min.js"></script>

  <script src="js/jquery.stellar.min.js"></script>

  <script src="js/owl.carousel.min.js"></script>

  <script src="js/jquery.magnific-popup.min.js"></script>

  <script src="js/aos.js"></script>

  <script src="js/jquery.animateNumber.min.js"></script>

  <script src="js/bootstrap-datepicker.js"></script>

  <script src="js/jquery.timepicker.min.js"></script>

  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>

  <script src="js/google-map.js"></script>

  <script src="js/main.js"></script>

    

  </body>

</html>


