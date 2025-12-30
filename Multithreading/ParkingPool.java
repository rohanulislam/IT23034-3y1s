import java.util.LinkedList;
import java.util.Queue;

public class ParkingPool {

    private Queue<RegistrarParking> parkingQueue = new LinkedList<>();

    public synchronized void addCar(RegistrarParking parking) {
        parkingQueue.add(parking);
        System.out.println("Car added to parking queue. ID: " + parking.getParkingId());
        notifyAll();
    }

    public synchronized RegistrarParking getCar() {
        while (parkingQueue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return parkingQueue.poll();
    }
}
