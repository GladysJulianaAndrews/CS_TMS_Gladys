package com.java.tms.main;

import java.sql.SQLException;
import java.util.Scanner;
import com.java.tms.dao.BookingDao;
import com.java.tms.dao.BookingDaoImpl;

public class BookingMain {

    public static void main(String[] args) {
        BookingMain bookingMain = new BookingMain();
        bookingMain.bookTripLogic();
    }

    public void bookTripLogic() {
        Scanner sc = new Scanner(System.in);
        BookingDao dao = new BookingDaoImpl();

        System.out.println("Enter Trip ID: ");
        int tripId = sc.nextInt();
        System.out.println("Enter Passenger ID: ");
        int passengerId = sc.nextInt();
        sc.nextLine(); 
        System.out.println("Enter Booking Date (YYYY-MM-DD HH:MM:SS): ");
        String bookingDate = sc.nextLine();

        try {
            if (dao.bookTrip(tripId, passengerId, bookingDate)) {
                System.out.println("Trip booked successfully.");
            } else {
                System.out.println("Failed to book trip.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } 
    }
}
