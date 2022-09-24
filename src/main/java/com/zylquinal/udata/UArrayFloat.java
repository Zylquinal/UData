package com.zylquinal.udata;

public class UArrayFloat implements UArray {

    private static final long BYTE = 4;

    private long size = 0;
    private long max_size;
    private long address;

    public UArrayFloat(int size) {
        this.max_size = size;
        address = UData.unsafe.allocateMemory(size * BYTE);
    }

    public void add(float value) {
        if (size >= max_size) {
            throw new IndexOutOfBoundsException("Array is full");
        }
        UData.unsafe.putFloat(address + size * BYTE, value);
        size++;
    }

    public float get(long index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return UData.unsafe.getFloat(address + index * BYTE);
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
