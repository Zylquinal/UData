package com.zylquinal.udata.array32;

import com.zylquinal.udata.UArray32;

public class UArrayChar32 extends UArray32 {

    public UArrayChar32(int size) {
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

    public char[] array() {
        char[] array = new char[size];
        for (int i = 0; i < size; i++) {
            array[i] = get(i);
        }
        return array;
    }

}
