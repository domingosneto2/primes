package com.codeinstructions.primes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasicPrimeTesterTest {
    @Test
    public void testIsPrime() {
        PrimeTester tester = new BasicPrimeTester();
        assertTrue(tester.isPrime(3));
        assertTrue(tester.isPrime(3));
        assertTrue(tester.isPrime(5));
        assertTrue(tester.isPrime(7));
        assertTrue(tester.isPrime(11));

        assertFalse(tester.isPrime(1));
        assertFalse(tester.isPrime(4));
        assertFalse(tester.isPrime(6));
        assertFalse(tester.isPrime(8));
        assertFalse(tester.isPrime(9));
        assertFalse(tester.isPrime(10));
    }
}
