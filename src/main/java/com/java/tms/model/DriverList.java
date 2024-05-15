package com.java.tms.model;

public class DriverList {

	private int Driverid;
	private int Tripid;
	public int getDriverid() {
		return Driverid;
	}
	public void setDriverid(int driverid) {
		Driverid = driverid;
	}
	public int getTripid() {
		return Tripid;
	}
	public void setTripid(int tripid) {
		Tripid = tripid;
	}
	@Override
	public String toString() {
		return "DriverList [Driverid=" + Driverid + ", Tripid=" + Tripid + "]";
	}
	public DriverList() {
		
	}
	public DriverList(int driverid, int tripid) {
		
		Driverid = driverid;
		Tripid = tripid;
	}
	
	
}
