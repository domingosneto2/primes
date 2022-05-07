package com.codeinstructions.primes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BitMapTest {
    @Test
    public void testBitMap() {
        BitMap bitMap = new BitMap(100);

        assertFalse(bitMap.get(0));

        bitMap.set(0, true);
        assertTrue(bitMap.get(0));
        for (int i = 1; i < 100; i++) {
            assertFalse(bitMap.get(i));
        }


    }
}
