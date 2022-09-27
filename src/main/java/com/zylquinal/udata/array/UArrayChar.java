package com.zylquinal.udata.array;

import com.zylquinal.udata.UArray;

public class UArrayChar extends UArray {

    public UArrayChar(long size) {
        super(2, size);
    }

    public void add(char value) {
        if (count + 1 > size) {
            grow();
        }
        unsafe.putChar(address + count * bytes, value);
        count++;
    }

    public char get(long index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return unsafe.getChar(address + index * bytes);
    }

    public void set(long index, char value) {
        setCheck(index);
        unsafe.putChar(address + index * bytes, value);
    }

}
