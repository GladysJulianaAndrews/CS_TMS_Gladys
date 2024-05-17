package com.java.tms.dao;

import java.sql.SQLException;
import java.util.List;
import com.java.tms.model.Vehicles;
import com.java.myexceptions.VechileNotFoundException;


public interface VehiclesDao {

	List<Vehicles> showVehiclesDao() throws ClassNotFoundException, SQLException;
	Vehicles searchByVehicle(int vehicleid) throws ClassNotFoundException, SQLException,VechileNotFoundException;
	boolean insertVehicle(Vehicles vehicle) throws ClassNotFoundException, SQLException;
	boolean updateVehicle(Vehicles vehicle) throws ClassNotFoundException, SQLException;
	boolean deleteVehicle(int vehicleId) throws ClassNotFoundException, SQLException;

}
	

