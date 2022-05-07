package com.codeinstructions.primes;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SieveTest {
    @Test
    public void testSieve() {
        Sieve sieve = new Sieve(100);
        sieve.runSieve();
        PrimeGenerator generator = new BasicPrimeGenerator();

        List<Long> expected = generator.getPrimes(100);
        List<Long> sieveResults = sieve.getPrimes();

        assertEquals(expected, sieveResults);
    }
}
