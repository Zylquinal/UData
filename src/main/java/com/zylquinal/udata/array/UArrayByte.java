package com.zylquinal.udata.array;

import com.zylquinal.udata.UArray;

public class UArrayByte extends UArray {

    public UArrayByte(long size) {
        super(1, size);
    }

    public void add(byte value) {
        if (count + 1 > size) {
            grow();
        }
        unsafe.putByte(address + count * bytes, value);
        count++;
    }

    public byte get(long index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return unsafe.getByte(address + index * bytes);
    }

    public void set(long index, byte value) {
        setCheck(index);
        unsafe.putByte(address + index * bytes, value);
    }

}
