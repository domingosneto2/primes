package com.codeinstructions.primes;

import java.util.ArrayList;
import java.util.List;

public class Sieve {
    private final long max;
    private final BitMap bitMap;

    public Sieve(long max) {
        this.max = max;
        this.bitMap = new BitMap(max / 2);
    }

    public void runSieve() {
        for (long i = 3; i <= Math.sqrt(max); i += 2) {
            if (isPrime(i)) {
                for (long x = i * 3; x < max; x += i * 2) {
                    crossOut(x);
                }
            }
        }
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

        long index = (i - 3) / 2;
        return !bitMap.get(index);
    }

    private void crossOut(long i) {
        long index = (i - 3) / 2;
        bitMap.set(index, true);
    }

    public List<Long> getPrimes() {
        List<Long> primes = new ArrayList<>();
        for (long i = 2; i < max; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }
}
