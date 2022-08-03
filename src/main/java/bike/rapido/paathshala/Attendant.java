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


    Boolean isParkingLotAvailable() {
        for(ParkingLot parkingLot : parkingLotList)
            if(!parkingLot.checkIfParkingLotFull())
                return true;
        return false;
    }
}
