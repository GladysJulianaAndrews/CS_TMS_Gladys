package com.java.tms.main;

import java.sql.SQLException;
import java.util.Scanner;
import com.java.tms.dao.TripsDao;
import com.java.tms.dao.TripsDaoImpl;

public class TripDriverDealloMain {

    public static void main(String[] args) {
        TripDriverDealloMain tripDriverDealloMain = new TripDriverDealloMain();
        tripDriverDealloMain.deallocateDriverLogic();
    }

    public void deallocateDriverLogic() {
        Scanner sc = new Scanner(System.in);
        TripsDao dao = new TripsDaoImpl();
        
        System.out.println("Enter Trip ID: ");
        int tripId = sc.nextInt();

        try {
            if (dao.deallocateDriver(tripId)) {
                System.out.println("Driver deallocated successfully.");
            } else {
                System.out.println("Failed to deallocate driver.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } 
    }
}
