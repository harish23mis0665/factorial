package com.example.factorial;

public class FactorialCalculator {
    
    /**
     * Calculate factorial of a given number using iterative approach
     * @param n - non-negative integer
     * @return factorial of n
     * @throws IllegalArgumentException if n is negative
     */
    public static long calculateIterative(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        
        if (n == 0 || n == 1) {
            return 1;
        }
        
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    /**
     * Calculate factorial using recursion
     * @param n - non-negative integer
     * @return factorial of n
     * @throws IllegalArgumentException if n is negative
     */
    public static long calculateRecursive(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        
        if (n == 0 || n == 1) {
            return 1;
        }
        
        return n * calculateRecursive(n - 1);
    }
    
    /**
     * Calculate factorial for multiple numbers
     */
    public static long[] calculateBatch(int[] numbers) {
        long[] results = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            results[i] = calculateIterative(numbers[i]);
        }
        return results;
    }
}