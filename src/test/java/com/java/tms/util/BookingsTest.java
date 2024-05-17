package com.java.tms.util;


import static org.junit.Assert.*;

import org.junit.Test;
import com.java.tms.model.Booking;

public class BookingsTest {

 @Test
 public void testToString() {
     Booking booking = new Booking(1, 1, 1, "2024-05-17", "Confirmed");
     String expected = "Booking [bookingid=1, tripid=1, passengerid=1, bookingdate=2024-05-17, status=Confirmed]";
     assertEquals(expected, booking.toString());
 }

 @Test
 public void testEquals() {
     Booking booking1 = new Booking(1, 1, 1, "2024-05-17", "Confirmed");
     Booking booking2 = new Booking(1, 1, 1, "2024-05-17", "Confirmed");
     Booking booking3 = new Booking(2, 1, 1, "2024-05-17", "Confirmed");
     Booking booking4 = null;
     String nonBooking = "Not a Booking";

     assertTrue(booking1.equals(booking2));
     assertFalse(booking1.equals(booking3));
     assertTrue(booking1.equals(booking1));
     assertFalse(booking1.equals(booking4));
     assertFalse(booking1.equals(nonBooking));
 }

 @Test
 public void testHashCode() {
     Booking booking1 = new Booking(1, 1, 1, "2024-05-17", "Confirmed");
     Booking booking2 = new Booking(1, 1, 1, "2024-05-17", "Confirmed");

     assertEquals(booking1.hashCode(), booking2.hashCode());
 }

 @Test
 public void testGettersAndSetters() {
     Booking booking = new Booking();
     booking.setBookingid(1);
     booking.setTripid(2);
     booking.setPassengerid(3);
     booking.setBookingdate("2024-05-18");
     booking.setStatus("Cancelled");

     assertEquals(1, booking.getBookingid());
     assertEquals(2, booking.getTripid());
     assertEquals(3, booking.getPassengerid());
     assertEquals("2024-05-18", booking.getBookingdate());
     assertEquals("Cancelled", booking.getStatus());
 }

 @Test
 public void testConstructors() {
     Booking booking1 = new Booking();
     assertNotNull(booking1);

     Booking booking2 = new Booking(1, 2, 3, "2024-05-18", "Cancelled");
     assertEquals(1, booking2.getBookingid());
     assertEquals(2, booking2.getTripid());
     assertEquals(3, booking2.getPassengerid());
     assertEquals("2024-05-18", booking2.getBookingdate());
     assertEquals("Cancelled", booking2.getStatus());
 }
}
