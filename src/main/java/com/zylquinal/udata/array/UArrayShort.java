package com.zylquinal.udata.array;

import com.zylquinal.udata.UArray;

public class UArrayShort extends UArray {

    public UArrayShort(long size) {
        super(2, size);
    }

    public void add(short value) {
        if (count + 1 > size) {
            grow();
        }
        unsafe.putShort(address + count * bytes, value);
        count++;
    }

    public short get(long index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return unsafe.getShort(address + index * bytes);
    }

    public void set(long index, short value) {
        setCheck(index);
        unsafe.putShort(address + index * bytes, value);
    }

}
