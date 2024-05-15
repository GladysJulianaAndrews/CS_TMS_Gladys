package com.java.tms.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.java.tms.dao.BookingDao;
import com.java.tms.dao.BookingDaoImpl;
import com.java.tms.model.Booking;

public class GetBookingsByPassengerMain {

    public static void main(String[] args) {
        GetBookingsByPassengerMain getBookingsByPassengerMain = new GetBookingsByPassengerMain();
        getBookingsByPassengerMain.getBookingsByPassengerLogic();
    }

    public void getBookingsByPassengerLogic() {
        Scanner sc = new Scanner(System.in);
        BookingDao dao = new BookingDaoImpl();

        System.out.println("Enter Passenger ID: ");
        int passengerId = sc.nextInt();

        try {
            List<Booking> bookings = dao.getBookingsByPassenger(passengerId);
            for (Booking booking : bookings) {
                System.out.println(booking); 
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } 
    }
}
