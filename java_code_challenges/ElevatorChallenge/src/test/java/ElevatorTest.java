import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ElevatorTest {

    private final ByteArrayOutputStream printOut =
            new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(printOut));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    public void callElevator() throws InterruptedException {
        Elevator elevator = new Elevator();
        elevator.setProcessingTime(10);

        elevator.callElevator(0, 4);
        elevator.start();
        assertEquals(4, elevator.getCurrentFloor());

        elevator.callElevator(0, 5);
        elevator.start();
        assertEquals(5, elevator.getCurrentFloor());

        elevator.callElevator(1, 5);
        elevator.start();
        assertEquals(5, elevator.getCurrentFloor());

        elevator.callElevator(4, 10);
        elevator.start();
        assertEquals(10, elevator.getCurrentFloor());

        elevator.callElevator(10, 7);
        elevator.start();
        assertEquals(7, elevator.getCurrentFloor());
    }

    @Test
    public void callElevator_invalidStart() {
        Elevator elevator = new Elevator();

        elevator.callElevator(-3, 8);

        assertEquals(0, elevator.getCurrentFloor());
    }

    @Test
    public void callElevator_invalidDestination() {
        Elevator elevator = new Elevator();

        elevator.callElevator(0, 14);
        assertEquals(0, elevator.getCurrentFloor());
    }

    @Test
    public void callElevator_sameStartAndDestination() {
        Elevator elevator = new Elevator();

        elevator.callElevator(5, 5);
        assertEquals(0, elevator.getCurrentFloor());
    }

    @Test
    public void startElevator() throws InterruptedException {
        Elevator elevator = new Elevator();
        elevator.setProcessingTime(10);

        elevator.callElevator(0, 4);
        elevator.callElevator(0, 5);
        elevator.callElevator(1, 5);
        elevator.callElevator(4, 6);
        elevator.callElevator(-3, 8);
        elevator.callElevator(0, 18);
        elevator.callElevator(8, 4);
        elevator.callElevator(10, 2);

        elevator.start();

        assertEquals(Map.of(), elevator.getRequestedPathsMap());
        assertFalse(Arrays
                .asList(elevator.getCurrentFloorDestinations())
                .contains(Boolean.TRUE));
    }
}