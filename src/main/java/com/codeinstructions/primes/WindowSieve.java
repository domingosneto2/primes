package com.codeinstructions.primes;

import java.util.ArrayList;
import java.util.List;

public class WindowSieve {
    private final long min;
    private final long max;

    private final long windowMin;
    private final long windowMax;
    private final BitMap bitMap;

    public WindowSieve(long min, long max) {
        this.min = min;
        this.max = max;

        if (min % 2 == 0) {
            windowMin = min + 1;
        } else {
            windowMin = min;
        }

        if (max % 2 == 0) {
            windowMax = max - 1;
        } else {
            windowMax = max;
        }

        long windowSize = windowMax - windowMin;
        bitMap = new BitMap(windowSize / 2);
    }

    public void runSieve() {
        Sieve baseSieve = new Sieve((long)Math.sqrt(max - 1));
        baseSieve.runSieve();

        List<Long> primes  = baseSieve.getPrimes();
        runSieve(primes);
    }

    public void runSieve(List<Long> primes) {
        for (Long prime : primes) {
            if (prime == 2) {
                continue;
            }

            long start = prime * (min / prime);
            if (start < min) {
                start += prime;
            }
            if (start % 2 == 0) {
                start += prime;
            }

            if (start == prime) {
                start += prime * 2;
            }

            for (long i = start; i < max; i += prime * 2) {
                crossOut(i);
            }
        }
    }

    private void crossOut(long i) {
        long index = (i - windowMin) / 2;
        bitMap.set(index, true);
    }

    public boolean isPrime(long i) {
        if (i < 2) {
            return false;
        }
        if (i == 2) {
            return true;
        }
        if (i % 2 == 0) {
            return false;
        }

        long index = (i - windowMin) / 2;
        return !bitMap.get(index);
    }

    public List<Long> getPrimes() {
        List<Long> primes = new ArrayList<>();
        for (long i = min; i < max; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }
}
