package bike.rapido.paathshala;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    ParkingLot parkingLot;
    Owner owner;
    SecurityPersonnel securityPersonnel;
    Attendant attendant;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        parkingLot = new ParkingLot(3, 1);
        owner = new Owner();
        securityPersonnel = new SecurityPersonnel();
        attendant = new Attendant(5);
    }

    @Test
    void shouldParkTheCar() {

        Vehicle firstCar = new Vehicle(1);

        Boolean result = parkingLot.park(firstCar);

        assertEquals(true, result);
    }

    @Test
    void shouldUnparkTheCar() {

        Vehicle firstCar = new Vehicle(1);

        parkingLot.park(firstCar);
        Boolean unparkStatus = parkingLot.unpark(firstCar);

        assertEquals(true, unparkStatus);
    }

    @Test
    void shouldNotUnparkTheCarBeforeTheCarIsParked() {

        Vehicle firstCar = new Vehicle(1);

        Boolean unparkStatus = parkingLot.unpark(firstCar);

        assertEquals(false, unparkStatus);
    }

    @Test
    void shouldParkAgainAfterUnparking() {

        Vehicle firstCar = new Vehicle(1);

        parkingLot.park(firstCar);
        parkingLot.unpark(firstCar);
        Boolean parkStatus = parkingLot.park(firstCar);

        assertEquals(true, parkStatus);
    }


    @Test
    void shouldNotifyOnlyTheOwner() {  //PS 3  TC1

        parkingLot.addObserver(owner);
        parkingLot.park(new Vehicle(1));
        parkingLot.park(new Vehicle(2));
        parkingLot.park(new Vehicle(3));

        assertTrue(parkingLot.checkIfParkingLotFull());
    }

    @Test
    void shouldNotNotifyTheOwnerWhenParkingLotNotFull() {  //PS 3  TC2

        parkingLot.addObserver(owner);
        parkingLot.park(new Vehicle(1));
        parkingLot.park(new Vehicle(2));

        assertFalse(parkingLot.checkIfParkingLotFull());
    }

    @Test
    void shouldNotifyOnlyTheSecurityPersonnel() { //PS4  TC1

        parkingLot.addObserver(securityPersonnel);
        parkingLot.park(new Vehicle(1));
        parkingLot.park(new Vehicle(2));
        parkingLot.park(new Vehicle(3));

        assertTrue(parkingLot.checkIfParkingLotFull());
    }

    @Test
    void shouldNotNotifyTheSecurityPersonnelWhenParkingLotNotFull() { //PS4  TC2

        parkingLot.addObserver(securityPersonnel);
        parkingLot.park(new Vehicle(1));

        assertFalse(parkingLot.checkIfParkingLotFull());
    }

    @Test
    void shouldTellThatParkingLotIsAvailable() { //PS4  TC2

        ParkingLot parkingLot1 = new ParkingLot(1, 111);
        attendant.addParkingLot(parkingLot1);
        ParkingLot parkingLot2 = new ParkingLot(1, 222);
        attendant.addParkingLot(parkingLot2);
        ParkingLot parkingLot3 = new ParkingLot(1, 333);
        attendant.addParkingLot(parkingLot3);
        ParkingLot parkingLot4 = new ParkingLot(1, 444);
        attendant.addParkingLot(parkingLot4);
        ParkingLot parkingLot5 = new ParkingLot(1, 555);
        attendant.addParkingLot(parkingLot5);

        parkingLot1.park(new Vehicle(1));
        parkingLot2.park(new Vehicle(2));
        parkingLot3.park(new Vehicle(3));
        parkingLot4.park(new Vehicle(4));

        assertTrue(attendant.isParkingLotAvailable());

    }
    @Test
    void shouldTellThatNoParkingLotIsAvailable() { //PS4  TC2

        ParkingLot parkingLot1 = new ParkingLot(1, 111);
        attendant.addParkingLot(parkingLot1);
        ParkingLot parkingLot2 = new ParkingLot(1, 222);
        attendant.addParkingLot(parkingLot2);
        ParkingLot parkingLot3 = new ParkingLot(1, 333);
        attendant.addParkingLot(parkingLot3);
        ParkingLot parkingLot4 = new ParkingLot(1, 444);
        attendant.addParkingLot(parkingLot4);
        ParkingLot parkingLot5 = new ParkingLot(1, 555);
        attendant.addParkingLot(parkingLot5);

        parkingLot1.park(new Vehicle(1));
        parkingLot2.park(new Vehicle(2));
        parkingLot3.park(new Vehicle(3));
        parkingLot4.park(new Vehicle(4));
        parkingLot5.park(new Vehicle(5));

        assertFalse(attendant.isParkingLotAvailable());
    }

    @Test
    void shouldUnparkTheCarFromItsParkingLot() {
        
    }

}