package bagian10.test;

import bagian10.Calculator;
import bagian10.test.generator.SimpleDisplayNameGenerator;
import org.junit.jupiter.api.*;
import org.opentest4j.TestAbortedException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@DisplayNameGeneration(SimpleDisplayNameGenerator.class)
// @DisplayName("Test for Calculator Class")
public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @BeforeAll
    public static void beforeAll() { // harus 'static'
        System.out.println("Before All");
    }

    @AfterAll
    public static void AfterAll() {
        System.out.println("After All");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Before each");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("After each");
    }

    @Test
    // @DisplayName("Test skenario sukses untuk method add(integer, integer)")
    public void testAddSuccess() {
        var result = calculator.add(10, 10);
        assertEquals(20, result);
//        if (result != 20) {
//            throw new RuntimeException("Test failed");
//        }
    }

    @Test
    public void testDivideSuccess() {
        var result = calculator.divide(100, 10);
        assertEquals(10, result);
    }

    @Test
    public void testDivideFailed() {
        assertThrows(IllegalArgumentException.class, () -> {
           // calculator.divide(10, 10); // error
            calculator.divide(10, 0);
        });
    }

    // Menonaktifkan test
    @Test
    @Disabled
    public void testComingSoon() {

    }

    // Membatalkan test
    @Test
    public void testAborted() { // tidak disarankan
        var profile = System.getenv("PROFILE");
        if (!"DEV".equals(profile)) {
            throw new TestAbortedException("Test dibatalkan karena bukan DEV");
        }

        // unit test untuk DEV
    }

    @Test
    public void testAssumptions() {
        assumeTrue("DEV".equals(System.getenv("PROFILE")));

        // unit test untuk DEV
    }
}
