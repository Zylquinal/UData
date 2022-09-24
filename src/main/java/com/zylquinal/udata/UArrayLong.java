package com.zylquinal.udata;

public class UArrayLong implements UArray {

    private static final long BYTE = 8;

    private long size = 0;
    private long max_size;
    private long address;

    public UArrayLong(int size) {
        this.max_size = size;
        address = UData.unsafe.allocateMemory(size * BYTE);
    }

    public void add(long value) {
        if (size >= max_size) {
            throw new IndexOutOfBoundsException("Array is full");
        }
        UData.unsafe.putLong(address + size * BYTE, value);
        size++;
    }

    public long get(long index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return UData.unsafe.getLong(address + index * BYTE);
    }

    public long[] array() {
        long[] array = new long[(int) size];
        for (long i = 0; i < size; i++) {
            array[(int) i] = get(i);
        }
        return array;
    }

    @Override
    public void resize(long size) {
        if (size < max_size) {
            throw new RuntimeException("New size cannot be smaller than current size");
        }
        address = UData.unsafe.reallocateMemory(address, size * BYTE);
        max_size = size;
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public void free() {
        UData.unsafe.freeMemory(address);
    }

}
