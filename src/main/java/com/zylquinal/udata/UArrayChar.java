package com.zylquinal.udata;

public class UArrayChar implements UArray {

    private static final long BYTE = 2;

    private long size = 0;
    private long max_size;
    private long address;

    public UArrayChar(int size) {
        this.max_size = size;
        address = UData.unsafe.allocateMemory(size * BYTE);
    }

    public void add(char value) {
        if (size >= max_size) {
            throw new IndexOutOfBoundsException("Array is full");
        }
        UData.unsafe.putChar(address + size * BYTE, value);
        size++;
    }

    public char get(long index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return UData.unsafe.getChar(address + index * BYTE);
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
