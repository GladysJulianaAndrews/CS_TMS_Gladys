package com.java.tms.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.tms.model.DriverList;



public interface TripsDao {
	 boolean scheduleTrip(int vehicleid, int routeid, String departuredate, String arrivaldate) throws ClassNotFoundException, SQLException;
	 boolean cancelTrip(int tripId) throws ClassNotFoundException, SQLException;
	 boolean allocateDriver(int tripId, int driverId) throws ClassNotFoundException, SQLException;
	 boolean deallocateDriver(int tripId) throws ClassNotFoundException, SQLException;
	 List<DriverList> getAvailableDrivers();
	
}
