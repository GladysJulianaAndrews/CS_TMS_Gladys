package com.java.tms.main;

import java.sql.SQLException;
import java.util.Scanner;
import com.java.tms.dao.TripsDao;
import com.java.tms.dao.TripsDaoImpl;

public class TripsScheduleMain {

    public static void main(String[] args) {
        TripsScheduleMain tripsScheduleMain = new TripsScheduleMain();
        tripsScheduleMain.scheduleTripsLogic();
    }

    public void scheduleTripsLogic() {
        Scanner sc = new Scanner(System.in);
        TripsDao dao = new TripsDaoImpl();

        System.out.println("Enter Trip Details:");
        System.out.println("Vehicle ID: ");
        int vehicleId = sc.nextInt();
        System.out.println("Route ID: ");
        int routeId = sc.nextInt();
        sc.nextLine(); // Consume newline
        System.out.println("Departure Date (YYYY-MM-DD HH:MM:SS): ");
        String departureDateTime = sc.nextLine();
        System.out.println("Arrival Date (YYYY-MM-DD HH:MM:SS): ");
        String arrivalDateTime = sc.nextLine();

        try {
            if (dao.scheduleTrip(vehicleId, routeId, departureDateTime, arrivalDateTime)) {
                System.out.println("Trip scheduled successfully.");
            } else {
                System.out.println("Failed to schedule trip.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } 
    }
}
