import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.function.Supplier;
import java.util.stream.*;
import java.util.*;


@DisplayName("A special test case")
@TestMethodOrder(OrderAnnotation.class)
public class MainTest {
    @BeforeAll
    static void globalSetup() {
        System.out.println("!!! Global setup !!!");
    }

    @BeforeEach
    void setup() {
        System.out.println("+++ Setup before each test +++");
    }

    @AfterAll
    static void globalReleaseResources() {
        System.out.println("!!! Global release resources !!!");
    }

    @AfterEach
    void releaseResources() {
        System.out.println("=== Release resources after test ===");
    }

    @Test
    @Order(10)
    @DisplayName("@ SUM @")
    void additionTest() {
        System.out.println("--- additionTest ---");
        Assertions.assertEquals(4, Calculator.addition(2, 2));
    }

    @Test
    @Order(20)
    @DisplayName("@ SUB @")
    void subtractionTest() {
        System.out.println("--- subtractionTest ---");
        Assertions.assertEquals(5, Calculator.subtraction(15, 10));
    }

    @Test
    @Order(30)
    @DisplayName("@ MUL @")
    void multiplicationTest() {
        System.out.println("--- multiplicationTest ---");
        Assertions.assertEquals(12, 
                                Calculator.multiplication(3, 4), 
                                "My message! Multiplication are failed!");
    }

    @Test
    @Order(40)
    @RepeatedTest(3)
    @DisplayName("@ DIV @")
    void divisionTest() {
        System.out.println("--- divisionTest ---");
        Supplier<String> message = () -> "My message! DivisionTest are failed!";
        Assertions.assertEquals(2, Calculator.division(10, 5), message);
    }

    @Test
    @Order(50)
    @Disabled
    void someDisabledTest() {
        // This test will not be run
    }

    @ParameterizedTest
    @Order(60)
    @ValueSource(ints = {-1, -2, -3})
    void negativeTest(Integer a) {
        assertTrue(Calculator.isNegative(a));
    }

    @ParameterizedTest
    @Order(70)
    @MethodSource("positiveTestParams")
    void positiveTest(Integer a) {
        assertTrue(Calculator.isPositive(a));
    }

    static Stream<Integer> positiveTestParams() {
        return Stream.of(1, 2, 3);
    }
    
    @ParameterizedTest
    @Order(80)
    @MethodSource("additionTestParams")
    void additionTestWithParams(Integer result, Integer a, Integer b) {
        Assertions.assertEquals(result, Calculator.addition(a, b));
    }

    static Stream<Arguments> additionTestParams() {
        return Stream.of(
            // result, a, b
            arguments(3, 1, 2),
            arguments(5, 2, 3),
            arguments(10, 3, 7)
        );
    }
}
