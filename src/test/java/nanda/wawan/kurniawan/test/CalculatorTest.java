package nanda.wawan.kurniawan.test;

import org.junit.jupiter.api.*;
import org.opentest4j.TestAbortedException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@DisplayName("Test for calculator class")
public class CalculatorTest {
    Calculator calculator = new Calculator();

    // method akan di running sekali sebelum semua method test dijalankan
    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before unit all");
    }

    // method akan di running sekali setelah semua method test dijalankan
    @AfterAll
    public static void afterAll() {
        System.out.println("After unit all");
    }

    // method akan di panggil sebelum setiap method test dijalankan
    @BeforeEach
    public void setUp() {
        System.out.println("Before unit test");
    }

    // method akan di panggil setelah setiap method test dijalankan
    @AfterEach
    public void tearDown() {
        System.out.println("After unit test");
    }

    // @Test digunakan untuk menandakan bahwa method ini method test
    // @DisplayName digunakan untuk melakukan alias pada nama function yang di test
    @Test
    @DisplayName("Test success condition for operation add")
    public void testAddSuccess() {
        int result = calculator.add(10, 10);
        assertEquals(20, result);
    }

    @Test
    @DisplayName("Test success condition for operation devide")
    public void testDevideSuccess() {
        int result = calculator.devide(100, 10);
        assertEquals(10, result);
    }

    @Test
    @DisplayName("Test error condition for operation devide")
    public void testDevideError() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.devide(10, 0);
        });
    }

    // @Disabled adalah method yang digunakan untuk melakukan skip terhadap method yang akan di test
    @Test
    @Disabled
    public void testComingSoon() {

    }

    @Test
    public void testAborted() {
        var profile = System.getenv("PROFILE");
        if (!"DEV".equals(profile)) {
            throw  new TestAbortedException("Test dibatalkan karena bukan DEV");
        }
    }

    @Test
    public void testAssumption() {
        assumeTrue("DEV".equals(System.getenv("PROFILE")));
    }
}
