package com.codeinstructions.primes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public interface PrimeGenerator extends Iterable<Long> {
    default boolean hasNext() {
        return true;
    }

    long nextPrime();

    default List<Long> getPrimes(long max) {
        return stream()
                .takeWhile(prime -> prime < max)
                .toList();
    }

    default Stream<Long> stream() {
        return StreamSupport.stream(spliterator(), false);
    }

    @Override
    default Iterator<Long> iterator() {
        return new Iterator<Long>() {
            @Override
            public boolean hasNext() {
                return PrimeGenerator.this.hasNext();
            }

            @Override
            public Long next() {
                return nextPrime();
            }
        };
    }
}
