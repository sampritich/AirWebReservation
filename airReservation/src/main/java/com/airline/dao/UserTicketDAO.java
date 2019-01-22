package com.airline.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.airline.model.Ticket;
import com.airline.model.User;
import com.airline.util.HibernateUtil;

public class UserTicketDAO {
	
	
	private SessionFactory sessionfactory;

	public UserTicketDAO() {
		
		
		sessionfactory=HibernateUtil.getSessionFactory();
	}
	
	
	
	
	
	public List<Ticket> userDisplayTicket(User user){
		
		
		Session session = sessionfactory.openSession();

		
		System.out.println(user.getEmailId());
		
		
		
		String hql="from Ticket where user=:u" ;
		Query query = session.createQuery(hql);
		
		session.beginTransaction();
		query.setParameter("u", user);
		
		List<Ticket> list=query.list();
		
		
		//String hql1="from Ticket where "
		/*for(User t:list) {
			System.out.println(t.getStatus());
			System.out.println(t.getTicketId());
		}*/
		session.getTransaction().commit();
		session.close();
		return list;
		
	}
	

}
