package com.airline.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airline.bo.BookingCheck;
import com.airline.bo.SeatBookBO;
import com.airline.bo.TicketBO;
import com.airline.bo.UserBO;
import com.airline.model.Flight;
import com.airline.model.Ticket;
import com.airline.model.User;

/**
 * Servlet implementation class FlightDetailsController
 */
public class FlightDetailsController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @see HttpServlet#HttpServlet()
	 * 
	 */

	public FlightDetailsController() {

		super();

		// TODO Auto-generated constructor stub

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// TODO Auto-generated method stub
		
		
		
		HttpSession session = request.getSession(false);
		System.out.println(session.getId());
		RequestDispatcher dispatch = null;
		
		Ticket ticket = new Ticket();
		TicketBO ticketBO = new TicketBO();

		//Flight flight = new Flight();
		//String guestButton = null;
		
		
		//Ticket gticket=new Ticket();
		
		/*if ("signup".equals(request.getParameter("signup"))) {
			User user = new User();
			UserBO userBO = new UserBO();

			String emailId = request.getParameter("email");
			String password = request.getParameter("password");
			String contact = request.getParameter("contact");
			user.setEmailId(emailId);
			user.setPassword(password);
			user.setContact(contact);
			System.out.println("New Signup");
			boolean status = userBO.create(user);
			System.out.println(status);
			
			
			//int passengercount=(Integer)session.getAttribute("passenger");

			ticket.setUser(user);
			
			System.out.println(ticket.getStatus()+"FD");
			//System.out.println(gstatus+"gstatus");
			
			session.setAttribute("ticket", ticket);

			//gticket.setStatus(guestButton);
			//System.out.println(gstatus);
			//session.setAttribute("ticket", gticket);
			dispatch=request.getRequestDispatcher("views/passenger.jsp");
			dispatch.forward(request, response);
		}*/

		 

			String button = null;
			String booked = request.getParameter("Booked");
			String reserve = request.getParameter("Reserve");
			String preBook = request.getParameter("PreBook");
			
			if(booked!=null)
			{
				button="Booked "+booked;
				System.out.println(button);
			}
			else if(reserve!=null)
			{
				button="Reserve "+reserve;
				System.out.println(button);
			}
			else if(preBook!=null)
			{
				button="PreBook "+preBook;
				System.out.println(button);
			}
			
			
			
			
			Flight flight = new Flight();

			String flightId = request.getParameter("flightid");
			String airlineName = request.getParameter("airlinename");
			String source = request.getParameter("source");
			Date arrivalTime = null;
			try {
				arrivalTime = new SimpleDateFormat("HH:mm:ss").parse(request.getParameter("arrivaltime"));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			java.sql.Time sqlTime = new java.sql.Time(arrivalTime.getTime());
			float businessPrice = Float.parseFloat(request.getParameter("businessprice"));
			int businessSeat = Integer.parseInt(request.getParameter("businessseat"));
			Date date = null;
			try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String destination = request.getParameter("destination");
			Date departureTime = null;
			try {
				departureTime = new SimpleDateFormat("HH:mm:ss").parse(request.getParameter("departuretime"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sqlTime = new java.sql.Time(departureTime.getTime());
			float duration = Float.parseFloat(request.getParameter("duration"));
			float economyPrice = Float.parseFloat(request.getParameter("economyprice"));
			int economySeat = Integer.parseInt(request.getParameter("economyseat"));

			flight.setAirlineName(airlineName);
			flight.setSource(source);
			flight.setArrivalTime(sqlTime);
			flight.setBusinessPrice(businessPrice);
			flight.setBusinessSeat(businessSeat);
			flight.setDate(date);
			flight.setDestination(destination);
			flight.setDepartureTime(sqlTime);
			flight.setDuration(duration);
			flight.setEconomyPrice(economyPrice);
			flight.setEconomySeat(economySeat);
			flight.setFlightId(flightId);

			session.setAttribute("selectedflight", flight);
			
			BookingCheck bookingCheck = new BookingCheck();
			
			
			int passengercount=(Integer)session.getAttribute("passenger");
			
			
			
			ticket.setFlight(flight);
	   	    ticket.setPassengerCount(passengercount);
	   	    ticket.setStatus(button);
	   	 User user = (User) session.getAttribute("user");
			if (user != null) {

				System.out.println(user.getContact() + " flightdetails");
				

				
	   	    	ticket.setUser(user);
	   	    	
	   	    	
				if (reserve!=null) {

					boolean status = bookingCheck.validateBookingReserve(date);

					System.out.println("to block ");

					if (status) {
						session.setAttribute("ticket", ticket);

						
						dispatch=request.getRequestDispatcher("views/passenger.jsp");
			        	 dispatch.forward(request, response);

						//boolean bookingStatus=ticketBO.createTicket(ticket);

			        	 

			        	// if(bookingStatus) {

			        		 //System.out.println("successfully update");
			        		// SeatBookBO seat=new SeatBookBO();
			        		 //boolean seatupdate=false;
			        		/* if(button.contains("Economy")) {
			        			System.out.println(button); 
			        			
			        			//String type="Economy";
			        			
			        			
			        			
			        			//seatupdate=seat.updateSeat(economySeat,flightId,passengercount,type);
			        			
			        			//System.out.println(seatupdate);
			        			
			        			
			        		 
			        		 }
			        		 else {
			        			 
			        			 String type="Business";
			        			 seatupdate=seat.updateSeat(businessSeat, flightId,passengercount,type);
			        			 
			        			 System.out.println(seatupdate);
			        			 
			        		 }
			        		 
			        		 
			        		 
			        		 

			        	 }*/

			        	/* else {

			        		 System.out.println("not updated");

			        	 }
						//System.out.println("allowed");

			        	 
			        	 dispatch=request.getRequestDispatcher("views/reservebooksuccess.jsp");
			        	 dispatch.forward(request, response);
					}*/
					}

					else {

						System.out.println("not allow");

						dispatch=request.getRequestDispatcher("views/reservebookfailed.jsp");
			        	 dispatch.forward(request, response);
					}

				}

				else if (preBook!=null) {

					System.out.println("to prebook");

					boolean status = bookingCheck.validatePrebooking(date);

					if (status) {
						
                    session.setAttribute("ticket", ticket);

						
						dispatch=request.getRequestDispatcher("views/passenger.jsp");
			        	 dispatch.forward(request, response);
					}

					//	boolean bookingStatus=ticketBO.createTicket(ticket);

			        	 

			        	/* if(bookingStatus) {

			        		 System.out.println("successfully update");
			        		 
			        		 SeatBookBO seat=new SeatBookBO();
			        		 
			        		 boolean seatupdate=false;
			        		 
			        		 if(button.contains("Economy")) {
				        			System.out.println(button); 
				        			
				        			String type="Economy";
				        			seatupdate=seat.updateSeat(economySeat,flightId,passengercount,type);
				        			
				        			System.out.println(seatupdate);
				        			if(seatupdate) {
				        				
				        			}
				        			
				        		 
				        		 }
				        		 else {
				        			 
				        			 String type="Business";
				        			 seatupdate=seat.updateSeat(businessSeat, flightId,passengercount,type);
				        			 
				        			 System.out.println(seatupdate);
				        			 
				        		 }
			        		 

			        	 }

			        	 else {

			        		 System.out.println("not updated");

			        	 }

					}*/

					else {

						System.out.println(" not allowed+controller");

					}

				}
				else if(booked!=null)
				{
					boolean status  = bookingCheck.concessionCheck(date);
					if(status)
					{
						float newPrice = 0 ;
						
						if("Economy".equals(booked))
						{
							//System.out.println("Economy");
							
							newPrice = bookingCheck.giveConcession(economyPrice);
							System.out.println(newPrice);
						}
						else if("Business".equals(booked))
						{
							//System.out.println("Business");
							
							newPrice = bookingCheck.giveConcession(businessPrice);
							System.out.println(newPrice);
						}
						
						session.setAttribute("price", newPrice);
					}
					else
					{
						float oldPrice = 0 ;
								
						if("Economy".equals(booked))
						{
							//System.out.println("Economy");
							
							oldPrice = economyPrice;
							System.out.println(oldPrice);
							
						}						
						else if("Business".equals(booked))
						{
							//System.out.println("Business");
							
							oldPrice = businessPrice;
							System.out.println(oldPrice);
							
						}
						session.setAttribute("price", oldPrice);
					}
					
					session.setAttribute("ticket", ticket);
					
					dispatch = request.getRequestDispatcher("views/passenger.jsp");
					dispatch.forward(request, response);
				}

			}

			else if (user == null) {

				System.out.println("non user");
				
			
				
				System.out.println(ticket.getPassengerCount()+"FD ");
				System.out.println(ticket.getFlight().getAirlineName());
				
				
				if(ticket.getStatus().contains("Business")) {
					session.setAttribute("price", ticket.getFlight().getBusinessPrice());
				}
				else {
					session.setAttribute("price", ticket.getFlight().getEconomyPrice());
				}
				
				session.setAttribute("ticket",ticket);
				
System.out.println(ticket.getStatus());
				dispatch = request.getRequestDispatcher("views/signup.jsp");
				dispatch.forward(request, response);

			}
		}

	}


