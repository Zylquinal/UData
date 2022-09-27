package com.zylquinal.udata.array;

import com.zylquinal.udata.UArray;

import java.util.ArrayList;

public class UArrayLong extends UArray {

    public UArrayLong(long size) {
        super(8, size);
    }

    public void add(long value) {
        if (count + 1 > size) {
            grow();
        }
        unsafe.putLong(address + count * bytes, value);
        count++;
    }

    public long get(long index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return unsafe.getLong(address + index * bytes);
    }

    public void set(long index, long value) {
        setCheck(index);
        unsafe.putLong(address + index * bytes, value);
    }

}
