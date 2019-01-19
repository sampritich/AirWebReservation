package com.airline.dao;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.airline.model.Flight;
import com.airline.util.HibernateUtil;




public class SeatDetailsDAO {
	
	
	
	private SessionFactory sessionFactory;

	public SeatDetailsDAO() {
		
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	
	
	
	@SuppressWarnings("deprecation")
	public boolean seatUpdate(int updatedSeatCount,String flightId,String type) {
		
		
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		
		boolean status=false;
		System.out.println(type);
		
		
		//UserModel u = (UserModel) session.get(UserModel.class, um.getCustomerID());
		Flight flight=(Flight) session.get(Flight.class,flightId);
		try {
		if(type.equals("Economy")) 
		{
		flight.setFlightId(flightId);
		flight.setEconomySeat(updatedSeatCount);
		session.saveOrUpdate(flight);
		status=true;
		tr.commit();
		}
		
		else {
			
			
			/*String hql="UPDATE Flight set businessSeat=:flightSeat where flightId=:id ";
			
			@SuppressWarnings("rawtypes")
			Query query = session.createSQLQuery(hql);

			
			query.setParameter("flightSeat",updatedSeatCount);
			query.setParameter("id", flightId);
			
			/*flight.setFlightId(flightId);
			flight.setBusinessSeat(flightSeat);
			session.saveOrUpdate(flight);*/
			flight.setFlightId(flightId);
			flight.setBusinessSeat(updatedSeatCount);
			session.saveOrUpdate(flight);
			status=true;
			tr.commit();
			
		
		}
		
		
		
		}
		
		catch(Exception e){
			
			System.out.println(e.getMessage());
			status=false;
		}
		
		
		
		
		return status;
	}

}
