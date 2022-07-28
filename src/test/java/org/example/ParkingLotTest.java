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
    void shouldParkTheVehicle(){

        Vehicle vehicle = new Vehicle();

        Boolean result = parkingLot.park(vehicle);

        assertEquals(true, result);
    }
}