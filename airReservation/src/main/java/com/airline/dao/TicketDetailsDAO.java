package com.airline.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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

}
