package bike.rapido.paathshala;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ParkingLot {

    int parkingLotSize;
    int parkingLotID;

    private List<ParkingLotObserver> parkingLotObserverList = new ArrayList<>();

    HashSet<Vehicle> vehicles = new HashSet<>();

    ParkingLot(int parkingLotSize, int parkingLotID) {
        this.parkingLotSize = parkingLotSize;
        this.parkingLotID = parkingLotID;
    }

    public void addObserver(ParkingLotObserver parkingLotObserver) {
        this.parkingLotObserverList.add(parkingLotObserver);
    }


    public Boolean park(Vehicle vehicle) {
        if (checkIfParked(vehicle) || checkIfParkingLotFull())
            return false;
        vehicles.add(vehicle);
        if (checkIfParkingLotFull()) {
            notifyWhenFull();
        }
        return true;
    }

    public Boolean unpark(Vehicle vehicle) {
        if (checkIfParked(vehicle)) {
            if (checkIfParkingLotFull()) {
                vehicles.remove(vehicle);
                notifyWhenEmpty();
            } else {
                vehicles.remove(vehicle);
            }
            return true;
        }
        return false;
    }

    private void notifyWhenFull() {
        for (ParkingLotObserver parkingLotObserver : parkingLotObserverList)
            parkingLotObserver.notifyAvailability();
    }

    private void notifyWhenEmpty() {
        for (ParkingLotObserver parkingLotObserver : parkingLotObserverList)
            parkingLotObserver.notifyUnavailability();
    }

    public Boolean checkIfParked(Vehicle vehicle) {
        return vehicles.contains(vehicle);
    }

    public Boolean checkIfParkingLotFull() {
        if (vehicles.size() == parkingLotSize)
            return true;
        return false;
    }
    public Boolean checkIfParkingLotHasSpaceAvailable() {
        if (vehicles.size() != parkingLotSize)
            return true;
        return false;
    }

}