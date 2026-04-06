package com.example.factorial;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(OrderAnnotation.class)
class FactorialCalculatorTest {
    
    private FactorialCalculator calculator;
    
    @BeforeEach
    void setUp() {
        calculator = new FactorialCalculator();
    }
    
    @Test
    @Order(1)
    @DisplayName("Test factorial of 0")
    void testFactorialOfZero() {
        assertEquals(1, FactorialCalculator.calculateIterative(0));
        assertEquals(1, FactorialCalculator.calculateRecursive(0));
    }
    
    @Test
    @Order(2)
    @DisplayName("Test factorial of 1")
    void testFactorialOfOne() {
        assertEquals(1, FactorialCalculator.calculateIterative(1));
        assertEquals(1, FactorialCalculator.calculateRecursive(1));
    }
    
    @ParameterizedTest
    @Order(3)
    @DisplayName("Test factorial for positive numbers")
    @MethodSource("provideFactorialData")
    void testFactorialPositiveNumbers(int input, long expected) {
        assertEquals(expected, FactorialCalculator.calculateIterative(input));
        assertEquals(expected, FactorialCalculator.calculateRecursive(input));
    }
    
    private static Stream<Arguments> provideFactorialData() {
        return Stream.of(
            Arguments.of(5, 120),
            Arguments.of(6, 720),
            Arguments.of(10, 3628800)
        );
    }
    
    @ParameterizedTest
    @Order(4)
    @DisplayName("Test factorial batch calculation")
    @ValueSource(ints = {2, 3, 4, 5})
    void testBatchCalculation(int testNumber) {
        int[] inputs = {1, 2, 3, 4, 5};
        long[] expected = {1, 2, 6, 24, 120};
        long[] results = FactorialCalculator.calculateBatch(inputs);
        
        assertArrayEquals(expected, results);
    }
    
    @Test
    @Order(5)
    @DisplayName("Test negative number throws exception")
    void testNegativeNumber() {
        assertThrows(IllegalArgumentException.class, 
                    () -> FactorialCalculator.calculateIterative(-1));
        assertThrows(IllegalArgumentException.class, 
                    () -> FactorialCalculator.calculateRecursive(-1));
    }
}