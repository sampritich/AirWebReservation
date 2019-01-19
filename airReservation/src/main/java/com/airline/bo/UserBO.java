package com.airline.bo;

import com.airline.dao.MySqlDAO;
import com.airline.model.User;

public class UserBO {

	public boolean create(User user) {
		// TODO Auto-generated method stub
		
		MySqlDAO mySqlDAO = new MySqlDAO();
		boolean status = mySqlDAO.create(user);
		
		return status;
	}

	public boolean validate(User user) {
		// TODO Auto-generated method stub
		
		MySqlDAO mySqlDAO = new MySqlDAO();
		boolean status = mySqlDAO.validate(user);
		
		return status;
	}

	
	
}
