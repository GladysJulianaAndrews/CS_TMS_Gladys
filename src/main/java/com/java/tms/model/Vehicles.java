package com.java.tms.model;

import java.util.Objects;

public class Vehicles {

	private int vehicleid;
	private String model;
	private double capacity;
	private String type;
	private String status;
	public int getVehicleid() {
		return vehicleid;
	}
	public void setVehicleid(int vehicleid) {
		this.vehicleid = vehicleid;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getCapacity() {
		return capacity;
	}
	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	@Override
	public String toString() {
		return "Vehicles [vehicleid=" + vehicleid + ", model=" + model + ", capacity=" + capacity + ", type=" + type
				+ ", status=" + status + "]";
	}
	
	
	public Vehicles() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Vehicles(int vehicleid, String model, double capacity, String type, String status) {
		this.vehicleid = vehicleid;
		this.model = model;
		this.capacity = capacity;
		this.type = type;
		this.status = status;
	}
	
	    @Override
	    public int hashCode() {
	        return Objects.hash(vehicleid, model, capacity, type, status);
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null || getClass() != obj.getClass()) {
	            return false;
	        }
	        Vehicles vehicle = (Vehicles) obj;
	        return vehicleid == vehicle.vehicleid &&
	               Double.compare(vehicle.capacity, capacity) == 0 &&
	               Objects.equals(model, vehicle.model) &&
	               Objects.equals(type, vehicle.type) &&
	               Objects.equals(status, vehicle.status);
	    }
	}

	 
	 
	

