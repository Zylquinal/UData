package com.zylquinal.udata.array;

import com.zylquinal.udata.UArray;

public class UArrayDouble extends UArray {

    public UArrayDouble(long size) {
        super(8, size);
    }

    public void add(double value) {
        if (count + 1 > size) {
            grow();
        }
        unsafe.putDouble(address + count * bytes, value);
        count++;
    }

    public double get(long index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return unsafe.getDouble(address + index * bytes);
    }

    public void set(long index, double value) {
        setCheck(index);
        unsafe.putDouble(address + index * bytes, value);
    }

}
