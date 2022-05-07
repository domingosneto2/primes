package com.codeinstructions.primes;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SievePrimeGeneratorTest {
    @Test
    public void testSievePrimeGenerator() {
        long max = 1_000;
        long windowSize = 100;

        System.out.println(Instant.now());
        PrimeGenerator sievePrimeGenerator = new SievePrimeGenerator(max, windowSize);
        List<Long> primes = sievePrimeGenerator.stream().toList();

        System.out.println(Instant.now());
        System.out.println("Number of primes: " + primes.size());

        PrimeGenerator basicPrimeGenerator = new BasicPrimeGenerator();
        List<Long> expected = basicPrimeGenerator.getPrimes(max);
        System.out.println(Instant.now());

        assertEquals(expected, primes);
    }

    @Test
    public void testPrimeCount() {
        long max = 1_000_000L;
        long windowSize = 10_000;

        HashMap<Long, Long> gapCounts = new HashMap<>();
        AtomicLong lastPrime = new AtomicLong(0);


        System.out.println(Instant.now());
        PrimeGenerator sievePrimeGenerator = new SievePrimeGenerator(max, windowSize);
        sievePrimeGenerator.stream().forEachOrdered(
                prime -> {
                    if (lastPrime.get() != 0L) {
                        long gap = prime - lastPrime.get();
                        gapCounts.compute(gap, (k, v) -> v == null ? 1 : v + 1L);
                    }
                    lastPrime.set(prime);
                }
        );

        System.out.println(Instant.now());

        Set<Long> gaps = new TreeSet<>(gapCounts.keySet());

        for (Long gap : gaps) {
            System.out.println(gap + " : " + gapCounts.get(gap));
        }

        System.out.println(Instant.now());
    }
}
