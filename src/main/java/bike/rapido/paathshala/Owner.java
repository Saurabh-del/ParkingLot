package bike.rapido.paathshala;

public class Owner implements ParkingLotObserver {


    @Override
    public void notifyAvailability() {
    }

    @Override
    public void notifyUnavailability() {
        System.out.println("OWNER ITS AVAILABLEEEE");
    }

}
