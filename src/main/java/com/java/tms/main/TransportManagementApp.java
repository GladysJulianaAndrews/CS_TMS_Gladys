package com.java.tms.main;


import com.java.tms.dao.TransportManagementServiceDao;
import com.java.tms.dao.TransportManagementServiceDaoImpl;

import java.util.Scanner;

public class TransportManagementApp {

    public static void main(String[] args) {
        TransportManagementServiceDao service = new TransportManagementServiceDaoImpl();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        do {
            System.out.println("Choose an operation:");
            System.out.println("1. Add Vehicle");
            System.out.println("2. Update Vehicle");
            System.out.println("3. Delete Vehicle");
            System.out.println("4. Schedule Trip");
            System.out.println("5. Cancel Trip");
            System.out.println("6. Book Trip");
            System.out.println("7. Cancel Booking");
            System.out.println("8. Allocate Driver");
            System.out.println("9. Deallocate Driver");
            System.out.println("10. Get Bookings By Passenger");
            System.out.println("11. Get Bookings By Trip");
            System.out.println("12. Get Available Drivers");
            System.out.println("13. Exit");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); 
            } catch (java.util.NoSuchElementException e) {
                exit = true;
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); 
                continue;
            }

            switch (choice) {
                case 1:
                    service.addVehicle();
                    break;
                case 2:
                    service.updateVehicle();
                    break;
                case 3:
                    service.deleteVehicle();
                    break;
                case 4:
                    service.scheduleTrip();
                    break;
                case 5:
                    service.cancelTrip();
                    break;
                case 6:
                    service.bookTrip();
                    break;
                case 7:
                    service.cancelBooking();
                    break;
                case 8:
                    service.allocateDriver();
                    break;
                case 9:
                    service.deallocateDriver();
                    break;
                case 10:
                    service.getBookingsByPassenger();
                    break;
                case 11:
                    service.getBookingsByTrip();
                    break;
                case 12:
                    service.getAvailableDrivers();
                    break;
                case 13:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 13.");
                    break;
            }
        } while (!exit);

        scanner.close();
        System.out.println("Exiting Transport Management Application.");
    }
}