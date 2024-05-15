package com.java.tms.main;

import java.sql.SQLException;
import java.util.Scanner;
import com.java.tms.dao.BookingDao;
import com.java.tms.dao.BookingDaoImpl;

public class BookingCancelMain {

    public static void main(String[] args) {
        BookingCancelMain bookingCancelMain = new BookingCancelMain();
        bookingCancelMain.cancelBookingLogic();
    }

    public void cancelBookingLogic() {
        Scanner sc = new Scanner(System.in);
        BookingDao bookingsDao = new BookingDaoImpl();

        System.out.println("Enter Booking ID to cancel: ");
        int bookingId = sc.nextInt();

        try {
            if (bookingsDao.cancelBooking(bookingId)) {
                System.out.println("Booking cancelled successfully.");
            } else {
                System.out.println("Failed to cancel booking.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } 
    }
}
