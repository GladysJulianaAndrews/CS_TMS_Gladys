package com.java.tms.main;

import java.sql.SQLException;
import java.util.Scanner;
import com.java.tms.dao.TripsDao;
import com.java.tms.dao.TripsDaoImpl;

public class TripDriverAlloMain {

    public static void main(String[] args) {
        TripDriverAlloMain tripDriverAlloMain = new TripDriverAlloMain();
        tripDriverAlloMain.allocateDriverLogic();
    }

    public void allocateDriverLogic() {
        Scanner sc = new Scanner(System.in);
        TripsDao dao = new TripsDaoImpl();

        System.out.println("Enter Trip ID: ");
        int tripId = sc.nextInt();
        System.out.println("Enter Driver ID: ");
        int driverId = sc.nextInt();

        try {
            if (dao.allocateDriver(tripId, driverId)) {
                System.out.println("Driver allocated successfully.");
            } else {
                System.out.println("Failed to allocate driver.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } 
    }
}
