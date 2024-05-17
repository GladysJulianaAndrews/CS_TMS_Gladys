package com.java.tms.util;


import static org.junit.Assert.*;
import org.junit.Test;

import com.java.tms.model.DriverList;

public class DriverListTest {
	
	@Test
    public void testEquals() {
        DriverList driverList1 = new DriverList(1, 2);
        DriverList driverList2 = new DriverList(1, 2);
        DriverList driverList3 = new DriverList(2, 3);

        assertTrue(driverList1.equals(driverList2));
        assertFalse(driverList1.equals(driverList3)); 
        assertFalse(driverList1.equals(null)); 
        assertFalse(driverList1.equals(new Object())); 
        assertTrue(driverList1.equals(driverList1)); 
    }
	
    @Test
    public void testToString() {
        DriverList driverList = new DriverList(1, 2);
        String expected = "DriverList [Driverid=1, Tripid=2]";
        assertEquals(expected, driverList.toString());
    }

    @Test
    public void testEqualsAndHashCode() {
        DriverList driverList1 = new DriverList(1, 2);
        DriverList driverList2 = new DriverList(1, 2);
        DriverList driverList3 = new DriverList(2, 3);

        assertTrue(driverList1.equals(driverList2));
        assertFalse(driverList1.equals(driverList3));

       
        assertEquals(driverList1.hashCode(), driverList2.hashCode());
        assertNotEquals(driverList1.hashCode(), driverList3.hashCode());
    }

    @Test
    public void testGettersAndSetters() {
        DriverList driverList = new DriverList();
        driverList.setDriverid(1);
        driverList.setTripid(2);

        assertEquals(1, driverList.getDriverid());
        assertEquals(2, driverList.getTripid());
    }

    @Test
    public void testConstructors() {
        DriverList driverList = new DriverList();
        assertNotNull(driverList);

        DriverList paramDriverList = new DriverList(1, 2);
        assertEquals(1, paramDriverList.getDriverid());
        assertEquals(2, paramDriverList.getTripid());
    }
}
