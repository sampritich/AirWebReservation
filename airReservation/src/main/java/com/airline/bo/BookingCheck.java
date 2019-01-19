package com.airline.bo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class BookingCheck {

	public boolean validateBookingReserve(Date flightDate) {

		// LocalDate currentDate = LocalDate.now(); // 2016-06-17

		boolean status = false;

		LocalDate futureDate = LocalDate.now().plusMonths(6);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		String afterSix = futureDate.format(formatter);

		System.out.println(futureDate + " 6 months today");

		System.out.println(afterSix + " 6 months actual");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String flight = sdf.format(flightDate);

		System.out.println(flight + "flightDate six");

		if (afterSix.equals(flight)) {

			System.out.println("allowed");

			status = true;

		}

		else {

			System.out.println("not allowed");

			status = false;

		}

		return status;

	}

	public boolean validatePrebooking(Date flight) {

		System.out.println(flight + "flight");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String flightDate = sdf.format(flight);

		System.out.println(flightDate + "in string");

		LocalDate threemonths = LocalDate.now().plusMonths(3);

		boolean status = false;

		System.out.println(threemonths + "three");

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		String afterThree = threemonths.format(formatter);

		System.out.println(afterThree + "actual");

		if (flightDate.equals(afterThree)) {

			System.out.println("allowed prebook");

			status = true;

		}

		else {

			System.out.println("not allowed prebook");

			status = false;

		}

		return status;

	}
	
	public boolean concessionCheck(Date date)
	{
		boolean status = false;

		LocalDate currentDate = LocalDate.now();
		
		LocalDate pastDate = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(date) );

		pastDate = pastDate.minusMonths(1);
		
		System.out.println(pastDate);
		
			

		if (currentDate.isBefore(pastDate)) {

			System.out.println("allowed");

			status = true;
			System.out.println(status);

		}

		else {

			System.out.println("not allowed");

			status = false;

		}

		
		return status;

	}
	
	public float giveConcession(float price)
	{
		price = (float) (price-(0.25*price));
		
		return price;
	}

}
