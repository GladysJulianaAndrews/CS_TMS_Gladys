package com.java.tms.model;

public class Booking {

	private int bookingid;
	private int tripid;
	private int passengerid;
	private String bookingdate;
	private String status;
	public int getBookingid() {
		return bookingid;
	}
	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}
	public int getTripid() {
		return tripid;
	}
	public void setTripid(int tripid) {
		this.tripid = tripid;
	}
	public int getPassengerid() {
		return passengerid;
	}
	public void setPassengerid(int passengerid) {
		this.passengerid = passengerid;
	}
	public String getBookingdate() {
		return bookingdate;
	}
	public void setBookingdate(String bookingdate) {
		this.bookingdate = bookingdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Booking [bookingid=" + bookingid + ", tripid=" + tripid + ", passengerid=" + passengerid
				+ ", bookingdate=" + bookingdate + ", status=" + status + "]";
	}
	public Booking() {
		
	}
	public Booking(int bookingid, int tripid, int passengerid, String bookingdate, String status) {
		this.bookingid = bookingid;
		this.tripid = tripid;
		this.passengerid = passengerid;
		this.bookingdate = bookingdate;
		this.status = status;
	}
	
		
	
	
	
	
}
