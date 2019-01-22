package com.airline.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.airline.model.Flight;
import com.airline.model.Ticket;
import com.airline.util.HibernateUtil;

public class TicketDetailsDAO implements TicketDAO {

	private SessionFactory sessionfactory;

	public TicketDetailsDAO() {

		sessionfactory = HibernateUtil.getSessionFactory();

	}

	public boolean createTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		Session session = sessionfactory.openSession();

		session.beginTransaction();

		/*System.out.println(ticket.getPassengerCount());

		System.out.println(ticket.getFlight().getAirlineName());*/

		try {

			session.saveOrUpdate(ticket);

			session.getTransaction().commit();

			session.close();

			return true;

		}

		catch (HibernateException ex)

		{

			return false;

		}
	}
	
	
	public Ticket getTicketDetails(int ticketId) {
		
		
		Session session=sessionfactory.openSession();
		
		//session.beginTransaction();
		
		String hql="from Ticket where ticketId=:t";
		
		Query query = session.createQuery(hql);
		session.beginTransaction();
		query.setParameter("t", ticketId);
		
		
Ticket ticket=(Ticket) query.getSingleResult();
		
		
		//String hql1="from Ticket where "
		/*for(User t:list) {
			System.out.println(t.getStatus());
			System.out.println(t.getTicketId());
		}*/
		session.getTransaction().commit();
		session.close();
		return ticket;
	}
	
	public boolean updateTicket(String tstatus,int ticketId,float payment) {
		
		Session session=sessionfactory.openSession();
		boolean status=false;
		//Flight flight=(Flight) session.get(Flight.class,flightId);
		Transaction tr=session.beginTransaction();
		Ticket t=(Ticket)session.get(Ticket.class, ticketId);
		try {
		
	t.setTicketId(ticketId);
	if(tstatus.contains("Business")) {
		t.setStatus("Booked Business");
	}
	else {
	t.setStatus("Booked Economy");	
	}
		t.setPayment(payment);
		session.saveOrUpdate(t);
		status=true;
		tr.commit();
		
		
	}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		/* Query qry = session.createQuery("update Ticket t set t.status=?1 where t.ticketId=?2");
				 	        qry.setParameter(1,tstatus);
				 	       qry.setParameter(2,ticketId);
				 	        int res = qry.executeUpdate();

		if(res>0) {
			status=true;
			System.out.println(res);
		}
		System.out.println(status+"dao");*/
		System.out.println(tstatus);
		System.out.println(ticketId);
		System.out.println(payment);
		/*String hql = "UPDATE Ticket set status = :status ,payment=:payment   WHERE ticketId = :ticketId";
	Query query = session.createQuery(hql);
	query.setParameter("status","Booked Economy" );
	query.setParameter("ticketId",ticketId);
	query.setParameter("payment",payment);

	int result = query.executeUpdate();
	System.out.println("Rows affected: " + result);
	if(result>=0) {
		status=true;
	}*/
return status;
}
}
