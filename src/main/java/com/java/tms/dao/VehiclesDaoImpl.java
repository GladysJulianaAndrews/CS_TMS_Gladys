package com.java.tms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.tms.model.Vehicles;
import com.java.tms.util.DBConnUtil;
import com.java.tms.util.DBPropertyUtil;
import com.java.myexceptions.VechileNotFoundException;

public class VehiclesDaoImpl implements VehiclesDao{

	Connection connection;
	PreparedStatement pst;
	private Vehicles vehicles;
	
	@Override
	public List<Vehicles> showVehiclesDao() throws ClassNotFoundException, SQLException {
		String connStr = DBPropertyUtil.connectionString("db");
		connection = DBConnUtil.getConnection(connStr);
		String cmd = "select * from Vehicles";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Vehicles> vehicleList = new ArrayList<Vehicles>();
		Vehicles vehicle = null;
		while(rs.next()) {
			vehicle = new Vehicles();
			vehicle.setVehicleid(rs.getInt("VehicleId"));
			vehicle.setModel(rs.getString("Model"));
			vehicle.setCapacity(rs.getDouble("Capacity"));
			vehicle.setType(rs.getString("Type"));
			vehicle.setStatus(rs.getString("Status"));
			vehicleList.add(vehicle);
		}
		return vehicleList;
	}
	
	
	
	@Override
	public Vehicles searchByVehicle(int vehicleId) throws ClassNotFoundException, SQLException,VechileNotFoundException {
	    String connStr = DBPropertyUtil.connectionString("db");
	    connection = DBConnUtil.getConnection(connStr);
	    String cmd = "SELECT * FROM Vehicles WHERE VehicleId=?";
	    pst = connection.prepareStatement(cmd);
	    pst.setInt(1, vehicleId);
	    ResultSet rs = pst.executeQuery();
	    if (rs.next()) {
	        Vehicles vehicle = new Vehicles();
	        vehicle.setVehicleid(rs.getInt("VehicleId"));
	        vehicle.setModel(rs.getString("Model"));
	        vehicle.setCapacity(rs.getDouble("Capacity"));
	        vehicle.setType(rs.getString("Type"));
	        vehicle.setStatus(rs.getString("Status"));
	        return vehicle;
	    } else {
            throw new VechileNotFoundException("Vehicle not found for vehicleId: " + vehicleId);
        }
    } 

	@Override
    public boolean insertVehicle(Vehicles vehicle) throws ClassNotFoundException, SQLException {
        String connStr = DBPropertyUtil.connectionString("db");
        connection = DBConnUtil.getConnection(connStr);
        String cmd = "insert into Vehicles (Model, Capacity, Type, Status) values (?, ?, ?, ?)";
        pst = connection.prepareStatement(cmd);
        pst.setString(1, vehicle.getModel());
        pst.setDouble(2, vehicle.getCapacity());
        pst.setString(3, vehicle.getType());
        pst.setString(4, vehicle.getStatus());
        int rowsAffected = pst.executeUpdate();
        return rowsAffected > 0;
    }

	 @Override
	    public boolean updateVehicle(Vehicles vehicle) throws ClassNotFoundException, SQLException {
	        String connStr = DBPropertyUtil.connectionString("db");
	        connection = DBConnUtil.getConnection(connStr);
	        String cmd = "update Vehicles set Model=?, Capacity=?, Type=?, Status=? where VehicleId=?";
	        pst = connection.prepareStatement(cmd);
	        pst.setString(1, vehicle.getModel());
	        pst.setDouble(2, vehicle.getCapacity());
	        pst.setString(3, vehicle.getType());
	        pst.setString(4, vehicle.getStatus());
	        pst.setInt(5, vehicle.getVehicleid());
	        int rowsAffected = pst.executeUpdate();
	        return rowsAffected > 0;
	    }
	 @Override
	    public boolean deleteVehicle(int vehicleId) throws ClassNotFoundException, SQLException {
	        String connStr = DBPropertyUtil.connectionString("db");
	        connection = DBConnUtil.getConnection(connStr);
	        String cmd = "delete from Vehicles where VehicleId=?";
	        pst = connection.prepareStatement(cmd);
	        pst.setInt(1, vehicleId);
	        int rowsAffected = pst.executeUpdate();
	        return rowsAffected > 0;
	    }
	 

}
	
	
	

