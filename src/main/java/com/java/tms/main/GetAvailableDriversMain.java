package com.java.tms.main;

import java.util.List;
import com.java.tms.dao.TripsDao;
import com.java.tms.dao.TripsDaoImpl;
import com.java.tms.model.DriverList;

public class GetAvailableDriversMain {
    
    public static void main(String[] args) {
        GetAvailableDriversMain availableDriversMain = new GetAvailableDriversMain();
        availableDriversMain.getAvailableDriversLogic();
    }

    public void getAvailableDriversLogic() {
        TripsDao dao = new TripsDaoImpl();

        try {
            List<DriverList> availableDrivers = dao.getAvailableDrivers();
            if (!availableDrivers.isEmpty()) {
                System.out.println("Available Drivers:");
                for (DriverList driver : availableDrivers) {
                    System.out.println("Driver ID: " + driver.getDriverid());
                }
            } else {
                System.out.println("No available drivers found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
