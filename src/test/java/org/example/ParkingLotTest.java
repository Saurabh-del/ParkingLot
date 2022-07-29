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
    void shouldParkTheCar(){

        Vehicle firstCar = new Vehicle();

        Boolean result = parkingLot.park(firstCar);

        assertEquals(true, result);

        System.out.println("testing");
    }
}