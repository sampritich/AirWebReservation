package com.airline.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.airline.model.User;
import com.airline.util.HibernateUtil;

public class MySqlDAO implements UserDAO {

	private SessionFactory sessionFactory;
	
	public MySqlDAO()
	{
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public boolean validate(User user) {
		
		Session session = sessionFactory.openSession();
		String hql = "from User where emailId = ?1 and password = ?2";
		
		User u= (User)session.createQuery(hql)
				.setParameter(1, user.getEmailId()).setParameter(2, user.getPassword()).uniqueResult();
		if(u!=null) {
			user.setContact(u.getContact());
			return true;
		}
		return false;
	}

	public boolean create(User user) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
        session.beginTransaction();
 
        try{
        	session.saveOrUpdate(user);
        	 session.getTransaction().commit();
             session.close();
             return true;
        }
        
        catch(HibernateException ex)
        {
        	return false;
        }

	}
	
	

}





