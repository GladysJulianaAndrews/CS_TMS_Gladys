package com.java.tms.main;

import java.sql.SQLException;
import java.util.Scanner;
import com.java.tms.dao.TripsDao;
import com.java.tms.dao.TripsDaoImpl;

public class TripsCancelMain {

    public static void main(String[] args) {
        TripsCancelMain tripsCancelMain = new TripsCancelMain();
        tripsCancelMain.cancelTripsLogic();
    }

    public void cancelTripsLogic() {
        Scanner sc = new Scanner(System.in);
        TripsDao dao = new TripsDaoImpl();

        System.out.println("Enter Trip ID to cancel: ");
        int tripId = sc.nextInt();

        try {
            if (dao.cancelTrip(tripId)) {
                System.out.println("Trip canceled successfully.");
            } else {
                System.out.println("Failed to cancel trip.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } 
    }
}
