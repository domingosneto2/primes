package com.codeinstructions.primes;

public class BasicPrimeGenerator implements PrimeGenerator {
    private long lastPrime = 0;
    private final PrimeTester tester = new BasicPrimeTester();
    @Override
    public long nextPrime() {
        if (lastPrime == 0) {
            lastPrime = 2;
            return lastPrime;
        }

        do {
            lastPrime++;
        } while (!tester.isPrime(lastPrime));

        return lastPrime;
    }
}
