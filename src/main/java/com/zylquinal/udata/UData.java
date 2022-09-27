package com.zylquinal.udata;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public abstract class UData {

    protected static Unsafe unsafe;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    protected long address;
    protected long allocated;

    public UData(long size) {
        if (size == 0) {
            throw new IllegalArgumentException("Size cannot be 0");
        }
        this.address = unsafe.allocateMemory(size);
        this.allocated = size;
    }

    protected void reallocate(long bytes) {
        if (bytes <= allocated) {
            throw new RuntimeException("New size cannot be smaller or equal than current size");
        }
        address = unsafe.reallocateMemory(address, bytes);
        allocated = bytes;
    }

    public void free() {
        unsafe.freeMemory(address);
    }

    public long getAddress() {
        return address;
    }

    public long getAllocated() {
        return allocated;
    }

}
