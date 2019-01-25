package com.airline.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airline.bo.BookingCheck;
import com.airline.bo.SeatBookBO;
import com.airline.bo.TicketBO;
import com.airline.bo.UserTicketDisplayBO;
import com.airline.model.Flight;
import com.airline.model.Ticket;
import com.airline.model.User;
import java.util.*;

/**
 * Servlet implementation class TicketDisplayController
 */
public class TicketDisplayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketDisplayController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		
		RequestDispatcher dispatch=null;
		String profile=request.getParameter("profile");
		
		System.out.println(profile);
		if(profile.equals("booking")) {
			
			
			User user=(User)session.getAttribute("user");
			
			
			System.out.println(user.getEmailId());
			
			UserTicketDisplayBO userbo=new UserTicketDisplayBO();
			
			List<Ticket> ticket=userbo.ticketDisplay(user);
			
			for(Ticket t:ticket) {
				
				
				//System.out.println(t.getContact()+"controller");
				System.out.println(t.getTicketId()+"controller");
				
			}
			session.setAttribute("userticketdetails", ticket);
			dispatch=request.getRequestDispatcher("views/ticketdisplay.jsp");
			dispatch.forward(request, response);
			
		}
		else if(profile.equals("reserve")) {
			User user=(User)session.getAttribute("user");
			System.out.println(user.getEmailId());
			UserTicketDisplayBO userbo=new UserTicketDisplayBO();
			List<Ticket> ticket=userbo.ticketDisplay(user);
			List<Ticket> newlist=new ArrayList<>();
			for(Ticket t:ticket) {
				System.out.println(t.getPassengerCount());
				if(t.getStatus().contains("PreBook") || t.getStatus().contains("Reserve")) {
					newlist.add(t);
				}
			}
			for(Ticket t1:newlist) {
				System.out.println(t1.getPassengerCount());
				System.out.println(t1.getFlight().getAirlineName());
			}
			
			session.setAttribute("reservationlist", newlist);
			dispatch=request.getRequestDispatcher("views/reservationlist.jsp");
			dispatch.forward(request, response);
		}
		else if(profile.equals("logout")) {
			
			session.invalidate();
			
			dispatch=request.getRequestDispatcher("InitializerController");
			dispatch.forward(request, response);
		}

	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		RequestDispatcher dispatch=null;
		
		HttpSession session=request.getSession();
		
		
		String confirm=request.getParameter("checkoutconfirm");
		
		System.out.println(confirm);
		if(request.getParameter("Booked")!=null) {
			String ticketId=request.getParameter("Booked");
			System.out.println(ticketId+"succ");
			
			//String ticketStatus=request.getParameter("ticketstatus");
			
			//System.out.println(ticketStatus);
			
			TicketBO ticketbo=new TicketBO();
			Ticket t=ticketbo.getTicketDetails(Integer.parseInt(ticketId));
			
			System.out.println(t.getPassengerCount());
			
			session.setAttribute("passenger", t.getPassengerCount());
			String bookstatus=t.getStatus();
			
			System.out.println(bookstatus);
			
			BookingCheck bookingCheck=new BookingCheck();
			
			boolean status  = bookingCheck.concessionCheck(t.getFlight().getDate());
			if(status) {
				
				float newPrice = 0 ;
				
				if(bookstatus.contains("Economy"))
				{
					//System.out.println("Economy");
					
					newPrice = bookingCheck.giveConcession(t.getFlight().getEconomyPrice());
					System.out.println(newPrice);
				}
				else if(bookstatus.contains("Business"))
				{
					//System.out.println("Business");
					
					newPrice = bookingCheck.giveConcession(t.getFlight().getBusinessPrice());
					System.out.println(newPrice);
				}
				
				session.setAttribute("price", newPrice);
			}
			else
			{
				float oldPrice = 0 ;
						
				if(bookstatus.contains("Economy"))
				{
					//System.out.println("Economy");
					
					oldPrice = t.getFlight().getEconomyPrice();
					System.out.println(oldPrice);
					
				}						
				else if(bookstatus.contains("Business"))
				{
					//System.out.println("Business");
					
					oldPrice = t.getFlight().getBusinessPrice();
					System.out.println(oldPrice);
					
				}
				session.setAttribute("price", oldPrice);
			}
			session.setAttribute("ticket", t);
			

			float payment = (Float) session.getAttribute("price");
			float actualPayment = payment*t.getPassengerCount();
			System.out.println(actualPayment);
			t.setPayment(actualPayment);

			dispatch=request.getRequestDispatcher("views/confirmpayment.jsp");
			dispatch.forward(request, response);
			}
			//dispatch=request.getRequestDispatcher("views/confirmpayment.jsp");
			//dispatch.forward(request, response);
			
		
		
		

	
		
		
		if(request.getParameter("checkoutconfirm")!=null) {
			
			//System.out.println(request.getParameter("checkout"));
			dispatch=request.getRequestDispatcher("views/payment.jsp");
			dispatch.forward(request, response);
		}
		else if(request.getParameter("cancel")!=null) {
			System.out.println("sorry");
			session.invalidate();
			dispatch=request.getRequestDispatcher("views/ticketcancel.jsp");
			dispatch.forward(request, response);
			
		}
	Ticket ticket=(Ticket)session.getAttribute("ticket");
	
System.out.println(ticket.getPassengerCount()+"ticketdisplaycontroller");
	
	
	
		
		if(request.getParameter("checkout")!=null) {
			
			String tstatus=ticket.getStatus();
			System.out.println(tstatus);
			
			if(tstatus.contains("Reserve")) {
				System.out.println("yes");
				TicketBO ticketbo=new TicketBO();
				boolean updateStatus=ticketbo.updateTicketStatus(tstatus, ticket.getTicketId(),ticket.getPayment());
				if(updateStatus) {
					System.out.println(updateStatus+"controller");
					boolean seatUp=false;
					SeatBookBO seat=new SeatBookBO();
					if(ticket.getStatus().contains("Economy")) {
		     			System.out.println(ticket.getStatus()); 
		     			
		     			String type="Economy";
		     			seatUp=seat.updateSeat(ticket.getFlight().getEconomySeat(),ticket.getFlight().getFlightId(),ticket.getPassengerCount(),type);
		     			
		     			System.out.println(seatUp);
		     			
		     			
		     		 
		     		 }
		     		 else {
		     			 
		     			 String type="Business";
		     			seatUp=seat.updateSeat(ticket.getFlight().getBusinessSeat(), ticket.getFlight().getFlightId(),ticket.getPassengerCount(),type);
		     			 
		     			 System.out.println(seatUp);
		     			 
		     		 }
					
					
					System.out.println("successfully booked");
					session.invalidate();
					dispatch=request.getRequestDispatcher("views/bookingsuccess.jsp");
					dispatch.forward(request, response);
					
				}
				
			}
			else if(tstatus.contains("PreBook ")) {
				System.out.println("yes");
				TicketBO ticketbo=new TicketBO();
				boolean updateStatus=ticketbo.updateTicketStatus(tstatus, ticket.getTicketId(),ticket.getPayment());
				if(updateStatus) {
					System.out.println(updateStatus+"controller");
					boolean seatUp=false;
					SeatBookBO seat=new SeatBookBO();
					if(ticket.getStatus().contains("Economy")) {
		     			System.out.println(ticket.getStatus()); 
		     			
		     			String type="Economy";
		     			seatUp=seat.updateSeat(ticket.getFlight().getEconomySeat(),ticket.getFlight().getFlightId(),ticket.getPassengerCount(),type);
		     			
		     			System.out.println(seatUp);
		     			
		     			
		     		 
		     		 }
		     		 else {
		     			 
		     			 String type="Business";
		     			seatUp=seat.updateSeat(ticket.getFlight().getBusinessSeat(), ticket.getFlight().getFlightId(),ticket.getPassengerCount(),type);
		     			 
		     			 System.out.println(seatUp);
		     			 
		     		 }
					
					
					System.out.println("successfully booked");
					session.invalidate();
					dispatch=request.getRequestDispatcher("views/bookingsuccess.jsp");
					dispatch.forward(request, response);
					
				}
				
			}
			else {
			TicketBO ticketBO = new TicketBO();
			boolean status = ticketBO.createTicket(ticket);
			System.out.println(status);
			System.out.println();
			boolean seatUpdate=false;
			 SeatBookBO seat=new SeatBookBO();
			 System.out.println(ticket.getStatus());
			if(ticket.getStatus().contains("Economy")) {
     			System.out.println(ticket.getStatus()); 
     			
     			String type="Economy";
     			seatUpdate=seat.updateSeat(ticket.getFlight().getEconomySeat(),ticket.getFlight().getFlightId(),ticket.getPassengerCount(),type);
     			
     			System.out.println(seatUpdate);
     			
     			
     		 
     		 }
     		 else {
     			 
     			 String type="Business";
     			seatUpdate=seat.updateSeat(ticket.getFlight().getBusinessSeat(), ticket.getFlight().getFlightId(),ticket.getPassengerCount(),type);
     			 
     			 System.out.println(seatUpdate);
     			 
     		 }
			
			
			
			
			System.out.println("succesfully booked");
			session.invalidate();
			
			System.out.println(" successfully logged out");
			dispatch=request.getRequestDispatcher("views/bookingsuccess.jsp");
			dispatch.forward(request, response);
			
			
		}
		
		
		
		
	}
	}
}
