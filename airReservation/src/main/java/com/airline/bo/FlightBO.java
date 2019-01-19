package com.airline.bo;

import java.util.List;

import com.airline.dao.FlightRecordsDAO;
import com.airline.model.Flight;

public class FlightBO {
	
	//List<FlightDetails> list=new ArrayList<>();
	
	public List<Flight>  flightRecords(Flight flight){
		
		
		FlightRecordsDAO flightDAO=new FlightRecordsDAO();
		
	List<Flight> list=flightDAO.records(flight);
	
		
		return list;
		
	}

}
