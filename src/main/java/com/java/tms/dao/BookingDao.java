package com.java.tms.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.tms.model.Booking;


public interface BookingDao {
	boolean bookTrip(int tripId, int passengerId, String bookingDate) throws ClassNotFoundException, SQLException;
	boolean cancelBooking(int bookingId) throws ClassNotFoundException, SQLException;
	List<Booking> getBookingsByPassenger(int passengerId) throws ClassNotFoundException, SQLException;
	List<Booking> getBookingsByTrip(int tripId) throws ClassNotFoundException, SQLException;
}
