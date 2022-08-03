package bike.rapido.paathshala;

import java.util.ArrayList;
import java.util.List;

public class Attendant {

    int noOfParkingLots;

    List<ParkingLot> parkingLotList;

    Attendant(int noOfParkingLots) {
        this.noOfParkingLots = noOfParkingLots;
        parkingLotList = new ArrayList<>(5);
    }

    void addParkingLot(ParkingLot parkingLot) {
        parkingLotList.add(parkingLot);
    }


    int availableParkingLotNumber() {
        for(ParkingLot parkingLot : parkingLotList)
            if(!parkingLot.checkIfParkingLotFull())
                return parkingLot.parkingLotID;
        return -1;
    }

    int parkingLotNumberToUnparkFrom(Vehicle vehicleToSearch) {
        for(ParkingLot parkingLot : parkingLotList) {
            for(Vehicle vehicle: parkingLot.vehicles){
                if(vehicle.vehicleID == vehicleToSearch.vehicleID)
                    return parkingLot.parkingLotID;
            }
        }
        return -1;
    }
}
