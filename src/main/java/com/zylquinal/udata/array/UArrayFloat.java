package com.zylquinal.udata.array;

import com.zylquinal.udata.UArray;

public class UArrayFloat extends UArray {

    public UArrayFloat(long size) {
        super(4, size);
    }

    public void add(float value) {
        if (count + 1 > size) {
            grow();
        }
        unsafe.putFloat(address + count * bytes, value);
        count++;
    }

    public float get(long index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return unsafe.getFloat(address + index * bytes);
    }

    public void set(long index, float value) {
        setCheck(index);
        unsafe.putFloat(address + index * bytes, value);
    }

}
