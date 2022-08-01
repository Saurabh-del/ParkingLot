package bike.rapido.paathshala;

import java.util.HashSet;

public class ParkingLot {

    int parkingLotSize;

    ParkingLot(int parkingLotSize){
        this.parkingLotSize = parkingLotSize;
    }


    HashSet<Vehicle> vehicles = new HashSet<>();
    public Boolean park(Vehicle vehicle) {
        if(checkIfParked(vehicle) || checkIfParkingLotFull())
            return false;

        vehicles.add(vehicle);
        if(checkIfParkingLotFull())
        {
            Person owner = new Person();
            Person securityPersonnel = new Person();

            owner.notifyPerson();
            securityPersonnel.notifyPerson();
        }
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

    public Boolean checkIfParkingLotFull() {
        if(vehicles.size() == parkingLotSize)
            return true;
        return false;
    }

}