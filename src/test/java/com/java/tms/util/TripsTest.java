package com.java.tms.util;

import static org.junit.Assert.*;

import org.junit.Test;
import com.java.tms.model.Trips;

public class TripsTest {

    @Test
    public void testToString() {
        Trips trip = new Trips(1, 101, 202, "2024-05-10", "2024-05-11", "Scheduled", "Regular", 50, 301);
        String expected = "Trips [tripid=1, vehicleid=101, routeid=202, departuredate=2024-05-10, arrivaldate=2024-05-11, status=Scheduled, triptype=Regular, maxpassengers=50, driverid=301]";
        assertEquals(expected, trip.toString());
    }

    @Test
    public void testEquals() {
        Trips trip1 = new Trips(1, 101, 202, "2024-05-10", "2024-05-11", "Scheduled", "Regular", 50, 301);
        Trips trip2 = new Trips(1, 101, 202, "2024-05-10", "2024-05-11", "Scheduled", "Regular", 50, 301);
        Trips trip3 = new Trips(2, 102, 203, "2024-05-12", "2024-05-13", "Completed", "Express", 30, 302);
        Trips trip4 = null;
        String nonTrip = "Not a Trip";
        assertTrue(trip1.equals(trip2));
        assertFalse(trip1.equals(trip3));
        assertTrue(trip1.equals(trip1));
        assertFalse(trip1.equals(trip4));
        assertFalse(trip1.equals(nonTrip));
    }

    @Test
    public void testHashCode() {
        Trips trip1 = new Trips(1, 101, 202, "2024-05-10", "2024-05-11", "Scheduled", "Regular", 50, 301);
        Trips trip2 = new Trips(1, 101, 202, "2024-05-10", "2024-05-11", "Scheduled", "Regular", 50, 301);

        assertEquals(trip1.hashCode(), trip2.hashCode());
    }

    @Test
    public void testGettersAndSetters() {
        Trips trip = new Trips();
        trip.setTripid(1);
        trip.setVehicleid(101);
        trip.setRouteid(202);
        trip.setDeparturedate("2024-05-10");
        trip.setArrivaldate("2024-05-11");
        trip.setStatus("Scheduled");
        trip.setTriptype("Regular");
        trip.setMaxpassengers(50);
        trip.setDriverid(301);

        assertEquals(1, trip.getTripid());
        assertEquals(101, trip.getVehicleid());
        assertEquals(202, trip.getRouteid());
        assertEquals("2024-05-10", trip.getDeparturedate());
        assertEquals("2024-05-11", trip.getArrivaldate());
        assertEquals("Scheduled", trip.getStatus());
        assertEquals("Regular", trip.getTriptype());
        assertEquals(50, trip.getMaxpassengers());
        assertEquals(301, trip.getDriverid());
    }

    @Test
    public void testConstructors() {
        Trips trip = new Trips();
        assertNotNull(trip);

        Trips trip1 = new Trips(1, 101, 202, "2024-05-10", "2024-05-11", "Scheduled", "Regular", 50, 301);
        assertEquals(1, trip1.getTripid());
        assertEquals(101, trip1.getVehicleid());
        assertEquals(202, trip1.getRouteid());
        assertEquals("2024-05-10", trip1.getDeparturedate());
        assertEquals("2024-05-11", trip1.getArrivaldate());
        assertEquals("Scheduled", trip1.getStatus());
        assertEquals("Regular", trip1.getTriptype());
        assertEquals(50, trip1.getMaxpassengers());
        assertEquals(301, trip1.getDriverid());
    }
}
