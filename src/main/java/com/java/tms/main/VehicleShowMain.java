package com.java.tms.main;

import java.sql.SQLException;
import java.util.List;


import com.java.tms.dao.VehiclesDao;
import com.java.tms.dao.VehiclesDaoImpl;
import com.java.tms.model.Vehicles;

public class VehicleShowMain {

	public static void main(String[] args) {
		VehiclesDao dao = new VehiclesDaoImpl();
		try {
			List<Vehicles> vehicleList = dao.showVehiclesDao();
			for (Vehicles vehicles : vehicleList) {
				System.out.println(vehicles);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
