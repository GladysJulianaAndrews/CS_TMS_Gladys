package com.java.tms.dao;

import com.java.myexceptions.BookingNotFoundExceptionMain;
import com.java.myexceptions.VechileNotFoundException;

public interface TransportManagementServiceDao {
    void addVehicle();
    void updateVehicle() throws VechileNotFoundException;
    void deleteVehicle();
    void scheduleTrip();
    void cancelTrip();
    void bookTrip();
    void cancelBooking() throws BookingNotFoundExceptionMain;
    void allocateDriver();
    void deallocateDriver();
    void getBookingsByPassenger();
    void getBookingsByTrip();
    void getAvailableDrivers();
}
