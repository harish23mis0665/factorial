package com.example.factorial;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTimeout;

public class FactorialCalculatorPerformanceTest {
    
    @RepeatedTest(10)
    void iterativePerformanceTest() {
        assertTimeout(java.time.Duration.ofMillis(1), 
                     () -> FactorialCalculator.calculateIterative(20));
    }
    
    @Test
    void recursivePerformanceTest() {
        // Recursive should be slower for larger numbers
        assertTimeout(java.time.Duration.ofMillis(10), 
                     () -> FactorialCalculator.calculateRecursive(15));
    }
}