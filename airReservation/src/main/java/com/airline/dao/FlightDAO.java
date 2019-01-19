package com.airline.dao;

import java.util.List;

import com.airline.model.Flight;

public interface FlightDAO {
	
	public List<Flight> records(Flight flight);

}