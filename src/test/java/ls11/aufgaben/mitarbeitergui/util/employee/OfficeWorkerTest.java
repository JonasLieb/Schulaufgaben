package ls11.aufgaben.mitarbeitergui.util.employee;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OfficeWorkerTest {
    private OfficeWorker owGood;
    private OfficeWorker owBad;

    @BeforeAll
    public void bevoreALl() {
        owGood = null;
        owBad = null;
    }

    @Test
    public void testIDTooLow() {
        int id = 300;
        assertThrows(IllegalArgumentException.class, () -> new OfficeWorker("Testarbeiter", id, 5000));
    }

    @Test
    public void testIDTooHigh() {
        int id = 10000;
        assertThrows(IllegalArgumentException.class, () -> new OfficeWorker("Testarbeiter", id, 5000));
    }

    @Test
    public void testNameEmpty() {
        String name = "";
        assertThrows(IllegalArgumentException.class, () -> new OfficeWorker(name, 3101, 5000));
    }

    @Test
    public void testNegativeWage() {
        double wage = -100;
        assertThrows(IllegalArgumentException.class, () -> new OfficeWorker("Testarbeiter", 3101, wage));
    }

    @Test
    public void testTooLowWage() {
        double wage = 299;
        assertThrows(IllegalArgumentException.class, () -> new OfficeWorker("Testarbeiter", 3101, wage));
    }

    @Test
    public void testValidWage() {
        double wage = 301;
        assertDoesNotThrow(() -> new OfficeWorker("Testarbeiter", 3101, wage));
    }

    @AfterAll
    public void afterAll() {

    }

}
