package adapter.example;

public class DuckSimulator {
    public static void main(String[] args) {
        Drone drone = new SuperDrone();
        Duck droneAdapter = new DroneAdapter(drone);
        testDuck(droneAdapter);
    }

    private static void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }
}
