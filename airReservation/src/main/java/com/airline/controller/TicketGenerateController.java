package com.airline.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airline.bo.TicketBO;
import com.airline.model.Passenger;
import com.airline.model.SpecialService;
import com.airline.model.Ticket;
import com.airline.model.Visa;

/**
 * Servlet implementation class TicketGenerateController
 */
public class TicketGenerateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketGenerateController() {
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
		
		HttpSession session = request.getSession();
		RequestDispatcher dispatch = null;
		
		
		int passenger=(Integer)session.getAttribute("passenger");
		
		String book = request.getParameter("Book");
		String specialService = request.getParameter("SpecialServices");
		String skipSpecialService = request.getParameter("SkipSpecialServices");
		String visa = request.getParameter("visa");
		
		Ticket ticket = (Ticket) session.getAttribute("ticket");
		
		
		
	
		if(book!=null)
		{
			System.out.println("Passenger Details Taken");
			
			
			List<Passenger> plist = new ArrayList<Passenger>();
			
			for(int i=0;i<passenger;i++)
			{
				String salutation = request.getParameter("salutation"+(i+1));
				String firstName = request.getParameter("firstname"+(i+1));
				String lastName = request.getParameter("lastname"+(i+1));
				String passengerType = request.getParameter("passengertype"+(i+1));
				Passenger p = new Passenger();
				System.out.println(salutation);
				System.out.println(firstName);
				System.out.println(lastName);
				System.out.println(passengerType);
				p.setFirstName(firstName);
				p.setLastName(lastName);
				p.setSalutation(salutation);
				p.setPassengerType(passengerType);
				plist.add(p);
				System.out.println("Added to list");
				//session.setAttribute("passengerlist", plist);
				
			}
			for(Passenger p:plist) {
				System.out.println(p.getFirstName());
				System.out.println(p.getLastName());
			}
			
			//User user = (User) session.getAttribute("user");

			System.out.println(ticket.getPassengerCount());
			//System.out.println(ticket.getStatus());
			ticket.setPassengerList(plist);
			session.setAttribute("ticket", ticket);
			/*ticket.setUser(user);
			System.out.println(ticket.getUser().getEmailId());
			TicketBO ticketBO = new TicketBO();
			boolean status = ticketBO.createTicket(ticket);
			System.out.println(status);*/
			System.out.println("After Booked");
			
			dispatch = request.getRequestDispatcher("views/specialservices.jsp");
			dispatch.forward(request, response);
		}
		else if(specialService!=null)
		{
			System.out.println("Special Service Taken");
			List<Passenger> plist = ticket.getPassengerList();
			for(int i=0;i<passenger;i++)
			{
				String seatType1 = request.getParameter("seattype1"+(i+1));
				String seatType2 = request.getParameter("seattype2"+(i+1));
				String meal = request.getParameter("meal"+(i+1));
				String medical = request.getParameter("medical"+(i+1));
				SpecialService ss = new SpecialService();
				System.out.println(seatType1);
				System.out.println(seatType2);
				System.out.println(meal);
				System.out.println(medical);
				ss.setSeatType1(seatType1);
				ss.setSeatType2(seatType2);
				ss.setMealType(meal);
				ss.setHandicapped(medical);
				Passenger p = plist.get(i);
				p.setSpecialService(ss);
				
				
			}
			//Ticket ticket = (Ticket) session.getAttribute("ticket");
			/*TicketBO ticketBO = new TicketBO();
			boolean status = ticketBO.createTicket(ticket);
			System.out.println(status);*/
			session.setAttribute("ticket", ticket);
			dispatch = request.getRequestDispatcher("views/visa.jsp");
			dispatch.forward(request, response);
		}
		
		else if(skipSpecialService!=null)
		{
			System.out.println("Skipped Special Service");
			dispatch = request.getRequestDispatcher("views/visa.jsp");
			dispatch.forward(request, response);
		}
		else if(visa!=null)
		{
			System.out.println("Visa Information");
			String visaId = request.getParameter("visaid");
			String countryName = request.getParameter("countryname");
			Date issueDate =null;
			Date expiryDate = null;
			try {
				issueDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("issuedate"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			try {
				expiryDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("expirydate"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(visaId);
			System.out.println(countryName);
			System.out.println(issueDate);
			System.out.println(expiryDate);
			Visa v = new Visa();
			v.setCountry(countryName);
			v.setExpiryDate(expiryDate);
			v.setIssueDate(issueDate);
			v.setVisaId(visaId);
			ticket.setVisa(v);
			
			session.setAttribute("ticket", ticket);

			if(ticket.getStatus().contains("Reserve")) {
				TicketBO ticketBO=new TicketBO();
				boolean bookingStatus=ticketBO.createTicket(ticket);
				if(bookingStatus) {
				dispatch=request.getRequestDispatcher("views/reservebooksuccess.jsp");
				dispatch.forward(request, response);
			}
			
				else {
					System.out.println("not updated");
				}
			}
			if(ticket.getStatus().contains("PreBook")) {
				TicketBO ticketBO=new TicketBO();
				boolean bookingStatus=ticketBO.createTicket(ticket);
				System.out.println(ticket.getStatus());
				if(bookingStatus) {
				dispatch=request.getRequestDispatcher("views/reservebooksuccess.jsp");
				dispatch.forward(request, response);
				
			}
				else {
					System.out.println("not updated");
				}
			}
			float payment = (Float) session.getAttribute("price");
			float actualPayment = payment*passenger;
			System.out.println(actualPayment);
			ticket.setPayment(actualPayment);
			
			//session.setAttribute("total price", payment);
			/*TicketBO ticketBO = new TicketBO();
			boolean status = ticketBO.createTicket(ticket);
			System.out.println(status);*/
			
			
			session.setAttribute("ticket", ticket);
			
			
			
			dispatch = request.getRequestDispatcher("views/confirmpayment.jsp");
			dispatch.forward(request, response);
		
		}
	}
}