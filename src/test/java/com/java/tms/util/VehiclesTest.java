package com.java.tms.util;

import static org.junit.Assert.*;

import org.junit.Test;
import com.java.tms.model.Vehicles;

public class VehiclesTest {

    @Test
    public void testToString() {
        Vehicles vehicle = new Vehicles(1, "Model X", 12.5, "Truck", "Available");
        String expected = "Vehicles [vehicleid=1, model=Model X, capacity=12.5, type=Truck, status=Available]";
        assertEquals(expected, vehicle.toString());
    }

    @Test
    public void testEquals() {
        Vehicles vehicle1 = new Vehicles(1, "Model X", 12.5, "Truck", "Available");
        Vehicles vehicle2 = new Vehicles(1, "Model X", 12.5, "Truck", "Available");
        Vehicles vehicle3 = new Vehicles(2, "Model Y", 15.0, "Van", "On Trip");
        Vehicles vehicle4 = null;
        String nonVehicle = "Not a Vehicle";
        assertTrue(vehicle1.equals(vehicle2));
        assertFalse(vehicle1.equals(vehicle3));
        assertTrue(vehicle1.equals(vehicle1));
        assertFalse(vehicle1.equals(vehicle4));
        assertFalse(vehicle1.equals(nonVehicle));
    }

    @Test
    public void testHashCode() {
        Vehicles vehicle1 = new Vehicles(1, "Model X", 12.5, "Truck", "Available");
        Vehicles vehicle2 = new Vehicles(1, "Model X", 12.5, "Truck", "Available");

        assertEquals(vehicle1.hashCode(), vehicle2.hashCode());
    }

    @Test
    public void testGettersAndSetters() {
        Vehicles vehicle = new Vehicles();
        vehicle.setVehicleid(1);
        vehicle.setModel("Model X");
        vehicle.setCapacity(12.5);
        vehicle.setType("Truck");
        vehicle.setStatus("Available");

        assertEquals(1, vehicle.getVehicleid());
        assertEquals("Model X", vehicle.getModel());
        assertEquals(12.5, vehicle.getCapacity(), 0.0);
        assertEquals("Truck", vehicle.getType());
        assertEquals("Available", vehicle.getStatus());
    }

    @Test
    public void testConstructors() {
        Vehicles vehicle = new Vehicles();
        assertNotNull(vehicle);

        Vehicles vehicle1 = new Vehicles(1, "Model X", 12.5, "Truck", "Available");
        assertEquals(1, vehicle1.getVehicleid());
        assertEquals("Model X", vehicle1.getModel());
        assertEquals(12.5, vehicle1.getCapacity(), 0.0);
        assertEquals("Truck", vehicle1.getType());
        assertEquals("Available", vehicle1.getStatus());
    }
}
