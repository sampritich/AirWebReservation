package com.airline.bo;

import java.util.List;

import com.airline.dao.UserTicketDAO;
import com.airline.model.Ticket;
import com.airline.model.User;

public class UserTicketDisplayBO {
	
	
	
	
	public List<Ticket> ticketDisplay(User user){
		
		UserTicketDAO userdao=new UserTicketDAO();
		
		
		List<Ticket> list=userdao.userDisplayTicket(user);
	
		for(Ticket t:list) {
			System.out.println(t.getPassengerCount()+"bo");
		}
		
		
		
		return list;
		
		
		
		
		
	}

}
