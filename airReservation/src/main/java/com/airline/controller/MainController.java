package com.airline.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airline.bo.CityBO;
import com.airline.bo.FlightBO;
import com.airline.bo.UserBO;
import com.airline.model.Cities;
import com.airline.model.Flight;
import com.airline.model.User;

/**
 * Servlet implementation class MainController
 */
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MainController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Logged Out");
		HttpSession session = request.getSession(false);
		session.invalidate();
		RequestDispatcher dispatch = request.getRequestDispatcher("InitializerController");
		dispatch.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		System.out.println(session.getId());
		RequestDispatcher dispatch = null;

		User user = new User();
		UserBO userBO = new UserBO();

		String emailId = request.getParameter("email");
		String password = request.getParameter("password");
		String contact = request.getParameter("contact");
		
		//System.out.println(passenger);

		user.setEmailId(emailId);
		user.setPassword(password);
		user.setContact(contact);

		if ("Login".equals(request.getParameter("Login"))) {
			System.out.println("Inside Login");
			boolean status = userBO.validate(user);
			// System.out.println(status);
			if (status) {
				CityBO cityBO = new CityBO();
				
				List<Cities> cityList  = cityBO.cityRecords();
				dispatch = request.getRequestDispatcher("views/profile.jsp");
				session.setAttribute("citylist", cityList);
				session.setAttribute("user", user);
				dispatch.forward(request, response);
			}
		} else if ("Signup".equals(request.getParameter("Signup"))) {
			System.out.println("Inside Signup");
			boolean status = userBO.create(user);
			// System.out.println(status);
			if (status) {
				CityBO cityBO = new CityBO();
				List<Cities> cityList  = cityBO.cityRecords();
				dispatch = request.getRequestDispatcher("views/RegistrationSuccess.jsp");
				session.setAttribute("citylist", cityList);
				session.setAttribute("user", user);
				dispatch.forward(request, response);
			}
		} else if ("Flights".equals(request.getParameter("Flights"))) {
			
			//System.out.println("Flights");
			Flight flight = new Flight();
			
			String source = request.getParameter("source");
			String destination = request.getParameter("destination");
			String date = request.getParameter("date");
			int passenger = Integer.parseInt(request.getParameter("passenger"));
			Date date1=null;
			System.out.println(date);
			if(date.isEmpty()) {

				date1=new Date();

				SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");

				date=sdf.format(date1);

				//System.out.println(date);

			}
			else
			{
				SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
				try {
					date1 = fmt.parse(date);
					//fmt.applyPattern("dd-MM-yyyy");
					System.out.println(date1);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			/*System.out.println(source);
			System.out.println(destination);*/
			
		

			flight.setDestination(destination);
			flight.setSource(source);

			flight.setDate(date1);
			//System.out.println(date1);

			FlightBO flightBO = new FlightBO();

			List<Flight> flightList = flightBO.flightRecords(flight);

			session.setAttribute("flights", flightList);
			//System.out.println(passenger);
			session.setAttribute("passenger", passenger);

			if (flightList.size() == 0) {

				dispatch=request.getRequestDispatcher("views/noflight.jsp");
				dispatch.forward(request, response);
				
				
			} else {
				dispatch = request.getRequestDispatcher("views/flight.jsp");
				//session.setAttribute("user", user);
				dispatch.forward(request, response);
			}
		}
	}

}
