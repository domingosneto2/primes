package com.codeinstructions.primes;

import java.util.*;
import java.util.stream.Stream;

public class SievePrimeGenerator implements PrimeGenerator {

    private long max;
    private int currentPrime;
    private Sieve baseSieve;
    private WindowSieve windowSieve;
    private long windowSize;
    private long windowStart;
    private long windowEnd;
    private List<Long> baseSievePrimes;
    private List<Long> currentPrimes;

    public SievePrimeGenerator(long max, long windowSize) {
        this.max = max;
        this.windowSize = windowSize;
    }

    @Override
    public boolean hasNext() {
        return more();
    }

    private boolean hasBuffer() {
        return currentPrimes != null && currentPrime < currentPrimes.size();
    }

    private boolean replenishBuffer() {
        if (baseSievePrimes == null) {
            // Initialize stuff
            this.windowStart = 3;
            this.windowEnd = (long)Math.sqrt(max - 1) + 1;
            baseSieve = new Sieve(windowEnd);
            baseSieve.runSieve();
            baseSievePrimes = baseSieve.getPrimes();
            currentPrimes = baseSievePrimes;
            currentPrime = 0;
        } else if (currentPrime == currentPrimes.size()) {
            if (windowEnd == max) {
                return false;
            }
            windowStart = windowEnd;
            windowEnd = windowStart + windowSize;

            if (windowEnd > max) {
                windowEnd = max;
            }
            WindowSieve windowSieve = new WindowSieve(windowStart, windowEnd);
            windowSieve.runSieve(baseSievePrimes);
            currentPrimes = windowSieve.getPrimes();
            currentPrime = 0;
        }
        return true;
    }

    private boolean more() {
        while (!hasBuffer()) {
            if (!replenishBuffer()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public long nextPrime() {
        if (!more()) {
            throw new IllegalStateException("Calling next() after end of stream");
        }
        long prime = currentPrimes.get(currentPrime);
        currentPrime++;
        return prime;
    }
}
