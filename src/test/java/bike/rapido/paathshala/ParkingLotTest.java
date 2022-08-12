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

        Vehicle firstCar = new Vehicle(1);
        Vehicle secondCar = new Vehicle(2);
        Vehicle thirdCar = new Vehicle(3);

        parkingLot.addObserver(owner);
        parkingLot.park(firstCar);
        parkingLot.park(secondCar);
        parkingLot.park(thirdCar);
        Boolean parkingLotSpaceStatus = parkingLot.checkIfParkingLotFull();

        assertTrue(parkingLotSpaceStatus);
    }

    @Test
    void shouldNotNotifyTheOwnerWhenParkingLotIsNotFull() {  //PS 3  TC2

        Vehicle firstCar = new Vehicle(1);
        Vehicle secondCar = new Vehicle(2);

        parkingLot.addObserver(owner);
        parkingLot.park(firstCar);
        parkingLot.park(secondCar);
        Boolean parkingLotSpaceStatus = parkingLot.checkIfParkingLotFull();

        assertFalse(parkingLotSpaceStatus);
    }

    @Test
    void shouldNotifyOnlyTheSecurityPersonnel() { //PS4  TC1

        Vehicle firstCar = new Vehicle(1);
        Vehicle secondCar = new Vehicle(2);
        Vehicle thirdCar = new Vehicle(3);

        parkingLot.addObserver(securityPersonnel);
        parkingLot.park(firstCar);
        parkingLot.park(secondCar);
        parkingLot.park(thirdCar);
        Boolean parkingLotSpaceStatus = parkingLot.checkIfParkingLotFull();

        assertTrue(parkingLotSpaceStatus);
    }

    @Test
    void shouldNotNotifyTheSecurityPersonnelWhenParkingLotIsNotFull() { //PS4  TC2

        Vehicle firstCar = new Vehicle(1);

        parkingLot.addObserver(securityPersonnel);
        parkingLot.park(firstCar);
        Boolean parkingLotSpaceStatus = parkingLot.checkIfParkingLotFull();

        assertFalse(parkingLotSpaceStatus);
    }

    @Test
    void shouldTellTheParkingLotIDThatIsAvailable() { //PS6 TC1

        ParkingLot parkingLot1 = new ParkingLot(1, 111);
        ParkingLot parkingLot2 = new ParkingLot(1, 222);
        ParkingLot parkingLot3 = new ParkingLot(1, 333);
        ParkingLot parkingLot4 = new ParkingLot(1, 444);
        ParkingLot parkingLot5 = new ParkingLot(1, 555);
        Vehicle car11 = new Vehicle(1);
        Vehicle car13 = new Vehicle(3);
        Vehicle car14 = new Vehicle(4);
        Vehicle car15 = new Vehicle(5);

        attendant.assignParkingLot(parkingLot1);
        attendant.assignParkingLot(parkingLot2);
        attendant.assignParkingLot(parkingLot3);
        attendant.assignParkingLot(parkingLot4);
        attendant.assignParkingLot(parkingLot5);
        parkingLot1.park(car11);
        parkingLot3.park(car13);
        parkingLot4.park(car14);
        parkingLot5.park(car15);
        int parkingLotNumber = attendant.availableParkingLotNumber();

        assertEquals(222, parkingLotNumber);
    }

    @Test
    void shouldTellNegativeOneWhenNoParkingLotIsAvailable() { //PS6 TC2

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

        attendant.assignParkingLot(parkingLot1);
        attendant.assignParkingLot(parkingLot2);
        attendant.assignParkingLot(parkingLot3);
        attendant.assignParkingLot(parkingLot4);
        attendant.assignParkingLot(parkingLot5);
        parkingLot1.park(car11);
        parkingLot2.park(car12);
        parkingLot3.park(car13);
        parkingLot4.park(car14);
        parkingLot5.park(car15);
        int parkingLotNumber = attendant.availableParkingLotNumber();

        assertEquals(-1, parkingLotNumber);
    }

    @Test
    void shouldTellTheParkingLotIDToUnparkFrom() { //PS7 TC1
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


        attendant.assignParkingLot(parkingLot1);
        attendant.assignParkingLot(parkingLot2);
        attendant.assignParkingLot(parkingLot3);
        attendant.assignParkingLot(parkingLot4);
        attendant.assignParkingLot(parkingLot5);
        parkingLot1.park(car11);
        parkingLot2.park(car12);
        parkingLot3.park(car13);
        parkingLot4.park(car14);
        parkingLot5.park(car15);
        int parkingLotNumber = attendant.parkingLotNumberToUnparkFrom(car13);

        assertEquals(333, parkingLotNumber);
    }

    @Test
    void shoudlTellNegative1WhenTheCarIsNotParkedAndIsAttemptedToUnpark() { //PS7 TC2
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
        Vehicle car16 = new Vehicle(6);


        attendant.assignParkingLot(parkingLot1);
        attendant.assignParkingLot(parkingLot2);
        attendant.assignParkingLot(parkingLot3);
        attendant.assignParkingLot(parkingLot4);
        attendant.assignParkingLot(parkingLot5);
        parkingLot1.park(car11);
        parkingLot2.park(car12);
        parkingLot3.park(car13);
        parkingLot4.park(car14);
        parkingLot5.park(car15);
        int parkingLotNumber = attendant.parkingLotNumberToUnparkFrom(car16);

        assertEquals(-1, parkingLotNumber);
    }

}