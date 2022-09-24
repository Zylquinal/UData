package com.zylquinal.udata;

public class UArrayInt implements UArray {

    private static final long BYTE = 4;

    private long size = 0;
    private long max_size;
    private long address;

    public UArrayInt(int size) {
        this.max_size = size;
        address = UData.unsafe.allocateMemory(size * BYTE);
    }

    public void add(int value) {
        if (size >= max_size) {
            throw new IndexOutOfBoundsException("Array is full");
        }
        UData.unsafe.putInt(address + size * BYTE, value);
        size++;
    }

    public int get(long index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return UData.unsafe.getInt(address + index * BYTE);
    }

    public int[] array() {
        int[] array = new int[(int) size];
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
