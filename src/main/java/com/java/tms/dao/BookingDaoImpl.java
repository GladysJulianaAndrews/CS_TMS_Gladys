package com.java.tms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.myexceptions.BookingNotFoundExceptionMain;
import com.java.tms.model.Booking;
import com.java.tms.util.DBConnUtil;
import com.java.tms.util.DBPropertyUtil;

public class BookingDaoImpl implements BookingDao {

    Connection connection;
    PreparedStatement pst;

    @Override
    public boolean bookTrip(int tripId, int passengerId, String bookingDate) throws ClassNotFoundException, SQLException {
        String connStr = DBPropertyUtil.connectionString("db");
        connection = DBConnUtil.getConnection(connStr);
        String cmd = "INSERT INTO Bookings (TripID, PassengerID, BookingDate, Status) VALUES (?, ?, ?, 'Confirmed')";
        pst = connection.prepareStatement(cmd);
        pst.setInt(1, tripId);
        pst.setInt(2, passengerId);
        pst.setString(3, bookingDate);
        int rowsAffected = pst.executeUpdate();
        return rowsAffected > 0;
    }

    @Override
    public boolean cancelBooking(int bookingId) throws ClassNotFoundException, SQLException, BookingNotFoundExceptionMain {
        String connStr = DBPropertyUtil.connectionString("db");
        connection = DBConnUtil.getConnection(connStr);
        String cmd = "UPDATE Bookings SET Status='Cancelled' WHERE BookingID=?";
        pst = connection.prepareStatement(cmd);
        pst.setInt(1, bookingId);
        int rowsAffected = pst.executeUpdate();
        if (rowsAffected == 0) { 
            throw new BookingNotFoundExceptionMain("Booking not found for bookingId: " + bookingId);
        }
        
        return true;
    }

    @Override
    public List<Booking> getBookingsByPassenger(int passengerId) throws ClassNotFoundException, SQLException {
        List<Booking> bookings = new ArrayList<>();
        String connStr = DBPropertyUtil.connectionString("db");
        try (Connection connection = DBConnUtil.getConnection(connStr);
             PreparedStatement pst = connection.prepareStatement("SELECT * FROM Bookings WHERE PassengerID=?")) {
            pst.setInt(1, passengerId);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Booking booking = new Booking();
                    booking.setBookingid(rs.getInt("BookingID"));
                    booking.setTripid(rs.getInt("TripID"));
                    booking.setPassengerid(rs.getInt("PassengerId")); 
                    booking.setBookingdate(rs.getString("BookingDate"));
                    booking.setStatus(rs.getString("Status"));
                    bookings.add(booking);
                }
            }
        }
        return bookings;
    }

    
    @Override
    public List<Booking> getBookingsByTrip(int tripId) throws ClassNotFoundException, SQLException {
        List<Booking> bookings = new ArrayList<>();
        String connStr = DBPropertyUtil.connectionString("db");
        try (Connection connection = DBConnUtil.getConnection(connStr);
             PreparedStatement pst = connection.prepareStatement("SELECT * FROM Bookings WHERE TripID=?")) {
            pst.setInt(1, tripId);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Booking booking = new Booking();
                    booking.setBookingid(rs.getInt("BookingID"));
                    booking.setTripid(rs.getInt("TripID"));
                    booking.setPassengerid(rs.getInt("PassengerID"));
                    booking.setBookingdate(rs.getString("BookingDate"));
                    booking.setStatus(rs.getString("Status"));
                    bookings.add(booking);
                }
            }
        }
        return bookings;
    }

} 
