package com.airline.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.airline.model.Cities;
import com.airline.util.HibernateUtil;

public class CityRecordsDAO implements CityDAO {

	private SessionFactory sessionfactory;

	public CityRecordsDAO() {
		sessionfactory = HibernateUtil.getSessionFactory();
	}
	public List<Cities> records() {
		// TODO Auto-generated method stub
		Session session = sessionfactory.openSession();
		String hql = "from Cities";
		List<Cities> cityList = (List<Cities>) session.createQuery(hql).list();
		return cityList;
	}

}
