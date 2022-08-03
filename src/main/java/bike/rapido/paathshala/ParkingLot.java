package bike.rapido.paathshala;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ParkingLot {

    int parkingLotSize;

    private List<ParkingLotObserver> parkingLotObserverList = new ArrayList<>();

    ParkingLot(int parkingLotSize){
        this.parkingLotSize = parkingLotSize;
    }

    public void addObserver(ParkingLotObserver parkingLotObserver) {
        this.parkingLotObserverList.add(parkingLotObserver);
    }

    HashSet<Vehicle> vehicles = new HashSet<>();
    public Boolean park(Vehicle vehicle) {
        if(checkIfParked(vehicle) || checkIfParkingLotFull())
            return false;

        vehicles.add(vehicle);
        if(checkIfParkingLotFull())
        {
            notifyWhenFull();
        }
        return true;
    }

    private void notifyWhenFull() {
        for(ParkingLotObserver parkingLotObserver : parkingLotObserverList)
            parkingLotObserver.notifyAvailability();
    }


    public Boolean unpark(Vehicle vehicle) {
        if(checkIfParked(vehicle)) {
            vehicles.remove(vehicle);
            return true;
        }
        return false;
    }

    public Boolean checkIfParked(Vehicle vehicle) {
        return vehicles.contains(vehicle);
    }

    public Boolean checkIfParkingLotFull() {
        if(vehicles.size() == parkingLotSize)
            return true;
        return false;
    }

}