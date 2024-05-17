	package com.java.tms.main;

	import java.sql.SQLException;
	import java.util.Scanner;

    import com.java.myexceptions.VechileNotFoundException;
    import com.java.tms.dao.VehiclesDao;
	import com.java.tms.dao.VehiclesDaoImpl;
	import com.java.tms.model.Vehicles;

public class VehiclesSearchMain {



	    public static void main(String[] args) throws VechileNotFoundException {
	        Scanner sc = new Scanner(System.in);
	        VehiclesDao dao = new VehiclesDaoImpl();
	        
	        System.out.println("Enter Vehicle ID to search: ");
	        int vehicleId = sc.nextInt();

	        try {
	            Vehicles vehicle = dao.searchByVehicle(vehicleId);
	            if (vehicle != null) {
	                System.out.println("Vehicle found:");
	                System.out.println(vehicle);
	            } else {
	                System.out.println("Vehicle not found.");
	            }
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

