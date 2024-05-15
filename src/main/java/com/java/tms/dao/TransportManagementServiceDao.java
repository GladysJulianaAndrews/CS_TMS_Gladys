package com.java.tms.dao;

public interface TransportManagementServiceDao {
    void addVehicle();
    void updateVehicle();
    void deleteVehicle();
    void scheduleTrip();
    void cancelTrip();
    void bookTrip();
    void cancelBooking();
    void allocateDriver();
    void deallocateDriver();
    void getBookingsByPassenger();
    void getBookingsByTrip();
    void getAvailableDrivers();
}
