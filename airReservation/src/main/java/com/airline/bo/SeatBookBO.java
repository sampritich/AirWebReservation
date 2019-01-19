package com.airline.bo;

import com.airline.dao.SeatDetailsDAO;

public class SeatBookBO {
	
	
	
	
	public boolean updateSeat(int flightSeat,String flightId,int passengerCount,String type) {
		
		
		
		
		System.out.println(passengerCount);
		
		System.out.println(flightId);
		
		System.out.println(flightSeat);
		
		System.out.println(type);
		
		int updatedSeatCount=flightSeat-passengerCount;
		
		SeatDetailsDAO seat=new SeatDetailsDAO();
		
		System.out.println(updatedSeatCount+"bo");
		
		boolean record=seat.seatUpdate(updatedSeatCount, flightId,type);
		
		System.out.println(record+"bo");
		
		
		return record;
	}

}
