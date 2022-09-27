package com.zylquinal.udata.array;

import com.zylquinal.udata.UArray;

public class UArrayInt extends UArray {

    public UArrayInt(long size) {
        super(4, size);
    }

    public void add(int value) {
        if (count + 1 > size) {
            grow();
        }
        unsafe.putInt(address + count * bytes, value);
        count++;
    }

    public int get(long index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return unsafe.getInt(address + index * bytes);
    }

    public void set(long index, int value) {
        setCheck(index);
        unsafe.putInt(address + index * bytes, value);
    }

}
