package com.java.tms.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.java.tms.dao.BookingDao;
import com.java.tms.dao.BookingDaoImpl;
import com.java.tms.model.Booking;

public class GetBookingByTripMain {

    public static void main(String[] args) {
        GetBookingByTripMain getBookingByTripMain = new GetBookingByTripMain();
        getBookingByTripMain.getBookingsByTripLogic();
    }

    public void getBookingsByTripLogic() {
        Scanner sc = new Scanner(System.in);
        BookingDao dao = new BookingDaoImpl();

        System.out.println("Enter Trip ID: ");
        int tripId = sc.nextInt();

        try {
            List<Booking> bookings = dao.getBookingsByTrip(tripId);
            if (!bookings.isEmpty()) {
                System.out.println("Bookings for Trip ID " + tripId + ":");
                for (Booking booking : bookings) {
                    System.out.println(booking);
                }
            } else {
                System.out.println("No bookings found for Trip ID " + tripId);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } 
    }
}
