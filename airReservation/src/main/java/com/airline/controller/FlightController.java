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

import com.airline.bo.FlightBO;
import com.airline.model.Flight;

/**
 * Servlet implementation class FlightController
 */
public class FlightController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlightController() {
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
		HttpSession session = request.getSession(false);
		RequestDispatcher dispatch = null;

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
				fmt.applyPattern("dd-MM-yyyy");
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
			dispatch.forward(request, response);
		}
	}

}
