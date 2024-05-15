package com.java.tms.model;


public class Trips {

	private int tripid;
	private int vehicleid;
	private int routeid;
	private String departuredate;
	private String arrivaldate;
	private String status;
	private String triptype;
	private int maxpassengers;
	private int driverid;
	public int getTripid() {
		return tripid;
	}
	public void setTripid(int tripid) {
		this.tripid = tripid;
	}
	public int getVehicleid() {
		return vehicleid;
	}
	public void setVehicleid(int vehicleid) {
		this.vehicleid = vehicleid;
	}
	public int getRouteid() {
		return routeid;
	}
	public void setRouteid(int routeid) {
		this.routeid = routeid;
	}
	public String getDeparturedate() {
		return departuredate;
	}
	public void setDeparturedate(String departuredate) {
		this.departuredate = departuredate;
	}
	public String getArrivaldate() {
		return arrivaldate;
	}
	public void setArrivaldate(String arrivaldate) {
		this.arrivaldate = arrivaldate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTriptype() {
		return triptype;
	}
	public void setTriptype(String triptype) {
		this.triptype = triptype;
	}
	public int getMaxpassengers() {
		return maxpassengers;
	}
	public void setMaxpassengers(int maxpassengers) {
		this.maxpassengers = maxpassengers;
	}
	public int getDriverid() {
		return driverid;
	}
	public void setDriverid(int driverid) {
		this.driverid = driverid;
	}
	@Override
	public String toString() {
		return "Trips [tripid=" + tripid + ", vehicleid=" + vehicleid + ", routeid=" + routeid + ", departuredate="
				+ departuredate + ", arrivaldate=" + arrivaldate + ", status=" + status + ", triptype=" + triptype
				+ ", maxpassengers=" + maxpassengers + ", driverid=" + driverid + "]";
	}
	public Trips() {
		
	}
	public Trips(int tripid, int vehicleid, int routeid, String departuredate, String arrivaldate, String status,
			String triptype, int maxpassengers, int driverid) {
		super();
		this.tripid = tripid;
		this.vehicleid = vehicleid;
		this.routeid = routeid;
		this.departuredate = departuredate;
		this.arrivaldate = arrivaldate;
		this.status = status;
		this.triptype = triptype;
		this.maxpassengers = maxpassengers;
		this.driverid = driverid;
	}

	
	
	
	
}
