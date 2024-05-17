package com.java.tms.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.myexceptions.VechileNotFoundException;
import com.java.tms.dao.VehiclesDao;
import com.java.tms.dao.VehiclesDaoImpl;
import com.java.tms.model.Vehicles;

public class VehiclesUpdateMain {

    public static void main(String[] args) throws VechileNotFoundException {
        VehiclesUpdateMain vehiclesUpdateMain = new VehiclesUpdateMain();
        vehiclesUpdateMain.updateVehicleLogic();
    }

    public void updateVehicleLogic() throws VechileNotFoundException {
        Scanner sc = new Scanner(System.in);
        VehiclesDao dao = new VehiclesDaoImpl();

        try {
            System.out.println("Enter Vehicle ID to update: ");
            int vehicleId = sc.nextInt();
            sc.nextLine(); 
            Vehicles vehicle = dao.searchByVehicle(vehicleId);
            
            if (vehicle != null) {
                System.out.println("Enter updated Model (or leave blank to keep current value): ");
                String model = sc.nextLine();
                
                System.out.println("Enter updated Capacity (or leave blank to keep current value): ");
                String capacityStr = sc.nextLine();
                Double capacity = null;
                if (!capacityStr.isEmpty()) {
                    capacity = Double.parseDouble(capacityStr);
                }
                
                System.out.println("Enter updated Type (or leave blank to keep current value): ");
                String type = sc.nextLine();
                
                System.out.println("Enter updated Status (or leave blank to keep current value): ");
                String status = sc.nextLine();
               
                if (!model.isEmpty()) {
                    vehicle.setModel(model);
                }
                if (capacity != null) {
                    vehicle.setCapacity(capacity);
                }
                if (!type.isEmpty()) {
                    vehicle.setType(type);
                }
                if (!status.isEmpty()) {
                    vehicle.setStatus(status);
                }
                
                
                if (dao.updateVehicle(vehicle)) {
                    System.out.println("Vehicle updated successfully.");
                } else {
                    System.out.println("Failed to update vehicle.");
                }
            } else {
                System.out.println("Vehicle not found.");
            }
        } catch (ClassNotFoundException | SQLException | NumberFormatException e) {
            e.printStackTrace();
        } 
    }
}
