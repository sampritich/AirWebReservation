package com.airline.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.airline.model.Flight;
import com.airline.util.HibernateUtil;

public class FlightRecordsDAO implements FlightDAO {

	private SessionFactory sessionfactory;

	public FlightRecordsDAO() {
		sessionfactory = HibernateUtil.getSessionFactory();
	}

	public List<Flight> records(Flight flight) {

		Session session = sessionfactory.openSession();

		String destination = flight.getDestination();
		String source = flight.getSource();
		Date date = flight.getDate();

		
		//java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
		String hql = "from Flight f where f.destination=:d and f.source=:s and f.date=:dt";
		Query query = session.createQuery(hql);
		
		session.beginTransaction();
		query.setParameter("d", destination);
		query.setParameter("s", source);
		query.setParameter("dt", date);

		List<Flight> flightList = query.list();

		/*for (Flight f : flightList) {
			System.out.println(f.getArilineName());
			System.out.println(f.getSource());
		}
		
		if (flightList.size() == 0) {
			System.out.println("list is empty");
		} else {
			System.out.println("list is full");
		}*/
		
		session.getTransaction().commit();
		session.close();
		return flightList;
	}

}