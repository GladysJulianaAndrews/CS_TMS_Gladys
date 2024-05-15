package com.java.tms.main;

import com.java.tms.dao.VehiclesDao;
import com.java.tms.dao.VehiclesDaoImpl;
import com.java.tms.model.Vehicles;

import java.sql.SQLException;
import java.util.Scanner;

public class VehiclesInsertMain {

    public static void main(String[] args) {
        VehiclesInsertMain vehiclesInsertMain = new VehiclesInsertMain();
        vehiclesInsertMain.addVehicleLogic();
    }

    public void addVehicleLogic() {
        Scanner sc = new Scanner(System.in);
        VehiclesDao dao = new VehiclesDaoImpl();

        System.out.println("Enter Vehicle Details:");
        System.out.println("Model: ");
        String model = sc.nextLine();
        System.out.println("Capacity: ");
        double capacity = sc.nextDouble();
        sc.nextLine();
        System.out.println("Type (Truck, Van, Bus): ");
        String type = sc.nextLine();
        System.out.println("Status (Available, On Trip, Maintenance): ");
        String status = sc.nextLine();

        Vehicles vehicle = new Vehicles(0, model, capacity, type, status);

        try {
            if (dao.insertVehicle(vehicle)) {
                System.out.println("Vehicle inserted successfully.");
            } else {
                System.out.println("Failed to insert vehicle.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } 
    }
}
