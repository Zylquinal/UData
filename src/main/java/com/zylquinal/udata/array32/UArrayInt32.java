package com.zylquinal.udata.array32;

import com.zylquinal.udata.UArray32;

public class UArrayInt32 extends UArray32 {

    public UArrayInt32(int size) {
        super(4, size);
    }

    public void add(int value) {
        if (count + 1 >= size) {
            grow();
        }
        unsafe.putInt(address + count * bytes, value);
        count++;
    }

    public int get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return unsafe.getInt(address + index * bytes);
    }

    public void set(int index, int value) {
        setCheck(index);
        unsafe.putInt(address + index * bytes, value);
    }

    public int[] array() {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = get(i);
        }
        return array;
    }

}
