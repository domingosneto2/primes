package com.codeinstructions.primes;

public class BasicPrimeTester implements PrimeTester {
    @Override
    public boolean isPrime(long number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Argument to isPrime must be a positive natural number");
        }

        if (number == 1) {
            return false;
        }

        if (number == 2) {
            return true;
        }

        if (number % 2 == 0) {
            return false;
        }

        long root = (long) Math.floor(Math.sqrt(number));
        for (int i = 3; i <= root; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
