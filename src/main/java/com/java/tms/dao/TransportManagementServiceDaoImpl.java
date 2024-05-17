package com.java.tms.dao;

import com.java.myexceptions.BookingNotFoundExceptionMain;
import com.java.myexceptions.VechileNotFoundException;
import com.java.tms.main.*;

public class TransportManagementServiceDaoImpl implements TransportManagementServiceDao {

    private final VehiclesInsertMain vehicleInsertMain = new VehiclesInsertMain();
    private final VehiclesUpdateMain vehiclesUpdateMain = new VehiclesUpdateMain();
    private final VehiclesDeleteMain vehiclesDeleteMain = new VehiclesDeleteMain();
    private final TripsScheduleMain tripsScheduleMain = new TripsScheduleMain();
    private final TripsCancelMain tripsCancelMain = new TripsCancelMain();
    private final BookingMain bookingMain = new BookingMain();
    private final BookingCancelMain bookingCancelMain = new BookingCancelMain();
    private final TripDriverAlloMain tripDriverAlloMain = new TripDriverAlloMain();
    private final TripDriverDealloMain tripDriverDealloMain = new TripDriverDealloMain();
    private final GetBookingsByPassengerMain getBookingsByPassengerMain = new GetBookingsByPassengerMain();
    private final GetBookingByTripMain getBookingByTripMain = new GetBookingByTripMain();
    private final GetAvailableDriversMain getAvailableDriversMain = new GetAvailableDriversMain();

    @Override
    public void addVehicle() {
        vehicleInsertMain.addVehicleLogic();
        System.out.println("Add Vehicle method called.");
        
    }

    @Override
    public void updateVehicle() throws VechileNotFoundException {
        vehiclesUpdateMain.updateVehicleLogic();
        System.out.println("Update Vehicle method called.");
    }

    @Override
    public void deleteVehicle() {
        vehiclesDeleteMain.deleteVehicleLogic();
        System.out.println("Delete Vehicle method called.");
    }

    @Override
    public void scheduleTrip() {
        tripsScheduleMain.scheduleTripsLogic();
        System.out.println("Schedule Trip method called.");
    }

    @Override
    public void cancelTrip() {
        tripsCancelMain.cancelTripsLogic();
        System.out.println("Cancel Trip method called.");
    }

    @Override
    public void bookTrip() {
        bookingMain.bookTripLogic();
        System.out.println("Book Trip method called.");
    }

    @Override
    public void cancelBooking() throws BookingNotFoundExceptionMain {
        bookingCancelMain.cancelBookingLogic();
        System.out.println("Cancel Booking method called.");
    }

    @Override
    public void allocateDriver() {
        tripDriverAlloMain.allocateDriverLogic();
        System.out.println("Allocate Driver method called.");
    }

    @Override
    public void deallocateDriver() {
        tripDriverDealloMain.deallocateDriverLogic();
        System.out.println("Deallocate Driver method called.");
    }

    @Override
    public void getBookingsByPassenger() {
        getBookingsByPassengerMain.getBookingsByPassengerLogic();
        System.out.println("Get Bookings By Passenger method called.");
    }

    @Override
    public void getBookingsByTrip() {
        getBookingByTripMain.getBookingsByTripLogic();
        System.out.println("Get Bookings By Trip method called.");
    }

    @Override
    public void getAvailableDrivers() {
        getAvailableDriversMain.getAvailableDriversLogic();
        System.out.println("Get Available Drivers method called.");
    }

}
