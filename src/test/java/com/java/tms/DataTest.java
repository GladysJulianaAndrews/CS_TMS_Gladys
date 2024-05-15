import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.example.transport.dao.TransportDao;
import com.example.transport.model.Driver;
import com.example.transport.model.Vehicle;
import com.example.transport.service.TransportService;
import com.example.transport.service.TransportServiceImpl;

public class TransportServiceTest {

    private TransportService transportService;
    private TransportDao transportDaoMock;

    @Before
    public void setUp() {
        transportDaoMock = mock(TransportDao.class);
        transportService = new TransportServiceImpl(transportDaoMock);
    }

    @Test
    public void testDriverMappingToVehicle_Success() throws SQLException {
        // Arrange
        int driverId = 1;
        int vehicleId = 1;
        Driver driver = new Driver(driverId, "John Doe");
        Vehicle vehicle = new Vehicle(vehicleId, "Toyota Camry", "SUV");

        // Stubbing behavior for DAO method
        when(transportDaoMock.getDriver(driverId)).thenReturn(driver);
        when(transportDaoMock.getVehicle(vehicleId)).thenReturn(vehicle);
        when(transportDaoMock.mapDriverToVehicle(driverId, vehicleId)).thenReturn(true);

        // Act
        boolean result = transportService.mapDriverToVehicle(driverId, vehicleId);

        // Assert
        assertTrue(result);
    }
}
