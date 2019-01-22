package com.airline.bo;

import com.airline.dao.TicketDetailsDAO;
import com.airline.model.Ticket;

public class TicketBO {
	
	
	TicketDetailsDAO ticketDetailsDAO = new TicketDetailsDAO();

	public boolean createTicket(Ticket ticket)
	{
		
		boolean status = ticketDetailsDAO.createTicket(ticket);
		
		return status;
	}
	
	
	public Ticket getTicketDetails(int ticketId ) {
		
		Ticket t=ticketDetailsDAO.getTicketDetails(ticketId);
		
		
		System.out.println(t.getTicketId()+"bo");
		
		return t;
		
	}
	
	public boolean updateTicketStatus(String status,int ticketId,float payment) {
		
		boolean ticketstatus=ticketDetailsDAO.updateTicket(status, ticketId,payment);
		
		if(ticketstatus) {
			System.out.println(ticketstatus+"bo");
		}
		else {
			System.out.println(ticketstatus+"bo");

		}
		return ticketstatus;
	}
}
