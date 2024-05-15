package com.java.tms.main;

import java.sql.SQLException;
import java.util.Scanner;
import com.java.tms.dao.VehiclesDao;
import com.java.tms.dao.VehiclesDaoImpl;

public class VehiclesDeleteMain {

    public static void main(String[] args) {
        VehiclesDeleteMain vehiclesDeleteMain = new VehiclesDeleteMain();
        vehiclesDeleteMain.deleteVehicleLogic();
    }

    public void deleteVehicleLogic() {
        Scanner sc = new Scanner(System.in);
        VehiclesDao dao = new VehiclesDaoImpl();
        
        try {
            System.out.println("Enter Vehicle ID to delete: ");
            int vehicleId = sc.nextInt();

            if (dao.deleteVehicle(vehicleId)) {
                System.out.println("Vehicle deleted successfully.");
            } else {
                System.out.println("Failed to delete vehicle.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } 
    }
}
