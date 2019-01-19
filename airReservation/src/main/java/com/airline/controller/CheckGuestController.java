package com.airline.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airline.bo.UserBO;
import com.airline.model.Ticket;
import com.airline.model.User;

/**
 * Servlet implementation class CheckGuestController
 */
public class CheckGuestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckGuestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		Ticket ticket =(Ticket)session.getAttribute("ticket");
		RequestDispatcher dispatch=null;
		if ("signup".equals(request.getParameter("signup"))) {
		User user = new User();
		UserBO userBO = new UserBO();

		String emailId = request.getParameter("email");
		String password = request.getParameter("password");
		String contact = request.getParameter("contact");
		user.setEmailId(emailId);
		user.setPassword(password);
		user.setContact(contact);
		System.out.println("New Signup in check ");
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
	}
	}

}
