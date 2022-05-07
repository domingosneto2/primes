package com.codeinstructions.primes;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WindowSieveTest {
    @Test
    public void testWindowSieve() {
        WindowSieve windowSieve = new WindowSieve(100, 200);
        windowSieve.runSieve();

        List<Long> primes = windowSieve.getPrimes();

        PrimeGenerator primeGenerator = new BasicPrimeGenerator();
        List<Long> expected = primeGenerator.stream()
                .dropWhile(p -> p < 100)
                .takeWhile(p -> p < 200)
                .toList();

        assertEquals(expected, primes);

    }
}
