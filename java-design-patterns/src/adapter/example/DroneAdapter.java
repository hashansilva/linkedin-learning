package adapter.example;

public class DroneAdapter implements Duck {
    Drone drone;

    public DroneAdapter(Drone drone) {
        this.drone = drone;
    }

    @Override
    public void quack() {
        this.drone.beep();
    }

    @Override
    public void fly() {
        this.drone.spinRotors();
        this.drone.takeOff();
    }
}
