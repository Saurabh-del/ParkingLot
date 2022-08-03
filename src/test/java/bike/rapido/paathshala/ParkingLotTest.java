package bike.rapido.paathshala;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    ParkingLot parkingLot;
    Owner owner;
    SecurityPersonnel securityPersonnel;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        parkingLot = new ParkingLot(3);
        owner = new Owner();
        securityPersonnel = new SecurityPersonnel();
    }

    @Test
    void shouldParkTheCar() {

        Vehicle firstCar = new Vehicle();

        Boolean result = parkingLot.park(firstCar);

        assertEquals(true, result);
    }

    @Test
    void shouldUnparkTheCar() {

        Vehicle firstCar = new Vehicle();

        parkingLot.park(firstCar);
        Boolean unparkStatus = parkingLot.unpark(firstCar);

        assertEquals(true, unparkStatus);
    }

    @Test
    void shouldNotUnparkTheCarBeforeTheCarIsParked() {

        Vehicle firstCar = new Vehicle();

        Boolean unparkStatus = parkingLot.unpark(firstCar);

        assertEquals(false, unparkStatus);
    }

    @Test
    void shouldParkAgainAfterUnparking() {

        Vehicle firstCar = new Vehicle();

        parkingLot.park(firstCar);
        parkingLot.unpark(firstCar);
        Boolean parkStatus = parkingLot.park(firstCar);

        assertEquals(true, parkStatus);
    }


    @Test
    void shouldNotifyOnlyTheOwner() {  //PS 3  TC1

        parkingLot.addObserver(owner);
        parkingLot.park(new Vehicle());
        parkingLot.park(new Vehicle());
        parkingLot.park(new Vehicle());

        assertTrue(parkingLot.checkIfParkingLotFull());
    }

    @Test
    void shouldNotifyOnlyTheSecurityPersonnel() { //PS4  TC1

        parkingLot.addObserver(securityPersonnel);
        parkingLot.park(new Vehicle());
        parkingLot.park(new Vehicle());
        parkingLot.park(new Vehicle());

        assertTrue(parkingLot.checkIfParkingLotFull());
    }

}