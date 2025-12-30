public class ParkingAgent extends Thread {

    private ParkingPool pool;

    public ParkingAgent(String name, ParkingPool pool) {
        super(name);
        this.pool = pool;
    }

    @Override
    public void run() {
        while (true) {
            RegistrarParking car = pool.getCar();
            System.out.println(getName() + " parked car ID: " + car.getParkingId());

            try {
                Thread.sleep(1000); // simulate parking time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
