package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    ParkingLot parkingLot;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        parkingLot = new ParkingLot();
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
}