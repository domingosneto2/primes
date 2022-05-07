package com.codeinstructions.primes;

public class BitMap {
    private final long[] bitMap;
    private final long size;

    public BitMap(long size) {
        this.size = size;
        int numWords = (int)Math.ceil(size / 64d);

        this.bitMap = new long[numWords];
    }

    public boolean get(long index) {
        int word = (int)(index / 64L);
        long bit = (index % 64L);

        return (this.bitMap[word] & (1L << bit)) != 0;
    }

    public void set(long index, boolean value) {
        int word = (int)(index / 64);
        long bit = (index % 64);

        if (value) {
            this.bitMap[word] |= 1L << bit;
        } else {
            this.bitMap[word] &= ~(1L << bit);
        }
    }
}
