package com.java.tms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.java.tms.model.DriverList;
import com.java.tms.util.DBConnUtil;
import com.java.tms.util.DBPropertyUtil;
import com.mysql.cj.jdbc.Driver;

public class TripsDaoImpl implements TripsDao {

    Connection connection;
    PreparedStatement pst;

    @Override
    public boolean scheduleTrip(int vehicleId, int routeId, String departureDate, String arrivalDate) throws ClassNotFoundException, SQLException {
        String connStr = DBPropertyUtil.connectionString("db");
        connection = DBConnUtil.getConnection(connStr);
        String cmd = "INSERT INTO Trips (VehicleID, RouteID, DepartureDate, ArrivalDate, Status) VALUES (?, ?, ?, ?, 'Scheduled')";
        pst = connection.prepareStatement(cmd);
        pst.setInt(1, vehicleId);
        pst.setInt(2, routeId);
        pst.setString(3, departureDate);
        pst.setString(4, arrivalDate);
        int rowsAffected = pst.executeUpdate();
        return rowsAffected > 0;
    }
    @Override
    public boolean cancelTrip(int tripId) throws ClassNotFoundException, SQLException {
        String connStr = DBPropertyUtil.connectionString("db");
        connection = DBConnUtil.getConnection(connStr);
        String cmd = "DELETE FROM Trips WHERE TripID=?";
        pst = connection.prepareStatement(cmd);
        pst.setInt(1, tripId);
        int rowsAffected = pst.executeUpdate();
        return rowsAffected > 0;
    }


    @Override
    public boolean allocateDriver(int tripId, int driverId) throws ClassNotFoundException, SQLException {
        String connStr = DBPropertyUtil.connectionString("db");
        connection = DBConnUtil.getConnection(connStr);
        String cmd = "UPDATE Trips SET DriverId=? WHERE TripId=?";
        pst = connection.prepareStatement(cmd);
        pst.setInt(1, driverId);
        pst.setInt(2, tripId);
        int rowsAffected = pst.executeUpdate();
        return rowsAffected > 0;
    }
    @Override
    public boolean deallocateDriver(int tripId) throws ClassNotFoundException, SQLException {
        String connStr = DBPropertyUtil.connectionString("db");
        connection = DBConnUtil.getConnection(connStr);
        String cmd = "UPDATE Trips SET DriverId=NULL WHERE TripId=?";
        pst = connection.prepareStatement(cmd);
        pst.setInt(1, tripId);
        int rowsAffected = pst.executeUpdate();
        return rowsAffected > 0;
    }

    
        @Override
        public List<DriverList> getAvailableDrivers() {
            List<DriverList> availableDrivers = new ArrayList<>();
            List<Integer> usedDriverIds = new ArrayList<>();

            try (Connection connection = DBConnUtil.getConnection(DBPropertyUtil.connectionString("db"));
                 PreparedStatement pst = connection.prepareStatement("SELECT DISTINCT DriverId FROM Trips")) {
                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        usedDriverIds.add(rs.getInt("DriverId"));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            for (int driverId = 1; driverId <= 15; driverId++) {
                if (!usedDriverIds.contains(driverId)) {
                    availableDrivers.add(new DriverList(driverId, driverId));
                }
            }

            return availableDrivers;
        }
    }


