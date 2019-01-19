package com.airline.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airline.bo.SeatBookBO;
import com.airline.bo.TicketBO;
import com.airline.model.Ticket;

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
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
