package bike.rapido.paathshala;

import java.util.HashSet;

public class ParkingLot {

    HashSet<Vehicle> vehicles = new HashSet<>();
    public Boolean park(Vehicle vehicle) {
        if(checkIfParked(vehicle))
            return false;
        vehicles.add(vehicle);
        return true;
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
}