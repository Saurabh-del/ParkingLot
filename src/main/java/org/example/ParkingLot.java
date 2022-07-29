package org.example;

public class ParkingLot {

    public Boolean park(Vehicle vehicle) {
        if (!vehicle.isParked) {
            vehicle.isParked = true;
            return true;
        }
        return false;
    }

    public Boolean unpark(Vehicle vehicle) {
        if (vehicle.isParked) {
            vehicle.isParked = false;
            return true;
        }
        return false;
    }
}