package com.codeinstructions.primes;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicPrimeGeneratorTest {
    @Test
    public void testPrimeGenerator() {
        PrimeGenerator generator = new BasicPrimeGenerator();

        List<Long> primes = new ArrayList<>();
        long prime = generator.nextPrime();
        while (prime < 100) {
            primes.add(prime);
            prime = generator.nextPrime();
        }

        long[] expected = new long[] {
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
                43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97
        };

        assertEquals(Arrays.stream(expected).boxed().toList(), primes);
    }
}
