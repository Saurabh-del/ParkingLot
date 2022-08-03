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
    void shouldTellTheParkingLotIDThatIsAvailable() { //PS4  TC2

        ParkingLot parkingLot1 = new ParkingLot(1, 111);
        ParkingLot parkingLot2 = new ParkingLot(1, 222);
        ParkingLot parkingLot3 = new ParkingLot(1, 333);
        ParkingLot parkingLot4 = new ParkingLot(1, 444);
        ParkingLot parkingLot5 = new ParkingLot(1, 555);
        Vehicle car11 = new Vehicle(1);
        Vehicle car13 = new Vehicle(3);
        Vehicle car14 = new Vehicle(4);
        Vehicle car15 = new Vehicle(5);


        attendant.addParkingLot(parkingLot1);
        attendant.addParkingLot(parkingLot2);
        attendant.addParkingLot(parkingLot3);
        attendant.addParkingLot(parkingLot4);
        attendant.addParkingLot(parkingLot5);
        parkingLot1.park(car11);
        parkingLot3.park(car13);
        parkingLot4.park(car14);
        parkingLot5.park(car15);

        assertEquals(222, attendant.availableParkingLotNumber());
    }
    @Test
    void shouldTellNegativeOneWhenNoParkingLotIsAvailable() { //PS4  TC2

        ParkingLot parkingLot1 = new ParkingLot(1, 111);
        ParkingLot parkingLot2 = new ParkingLot(1, 222);
        ParkingLot parkingLot3 = new ParkingLot(1, 333);
        ParkingLot parkingLot4 = new ParkingLot(1, 444);
        ParkingLot parkingLot5 = new ParkingLot(1, 555);
        Vehicle car11 = new Vehicle(1);
        Vehicle car12 = new Vehicle(2);
        Vehicle car13 = new Vehicle(3);
        Vehicle car14 = new Vehicle(4);
        Vehicle car15 = new Vehicle(5);


        attendant.addParkingLot(parkingLot1);
        attendant.addParkingLot(parkingLot2);
        attendant.addParkingLot(parkingLot3);
        attendant.addParkingLot(parkingLot4);
        attendant.addParkingLot(parkingLot5);
        parkingLot1.park(car11);
        parkingLot2.park(car12);
        parkingLot3.park(car13);
        parkingLot4.park(car14);
        parkingLot5.park(car15);

        assertEquals(-1, attendant.availableParkingLotNumber());
    }

    @Test
    void shouldTellTheParkingLotToUnparkFrom() {
        ParkingLot parkingLot1 = new ParkingLot(1, 111);
        ParkingLot parkingLot2 = new ParkingLot(1, 222);
        ParkingLot parkingLot3 = new ParkingLot(1, 333);
        ParkingLot parkingLot4 = new ParkingLot(1, 444);
        ParkingLot parkingLot5 = new ParkingLot(1, 555);
        Vehicle car11 = new Vehicle(1);
        Vehicle car12 = new Vehicle(2);
        Vehicle car13 = new Vehicle(3);
        Vehicle car14 = new Vehicle(4);
        Vehicle car15 = new Vehicle(5);


        attendant.addParkingLot(parkingLot1);
        attendant.addParkingLot(parkingLot2);
        attendant.addParkingLot(parkingLot3);
        attendant.addParkingLot(parkingLot4);
        attendant.addParkingLot(parkingLot5);
        parkingLot1.park(car11);
        parkingLot2.park(car12);
        parkingLot3.park(car13);
        parkingLot4.park(car14);
        parkingLot5.park(car15);

        assertEquals(333, attendant.parkingLotNumberToUnparkFrom(car13));


    }

}