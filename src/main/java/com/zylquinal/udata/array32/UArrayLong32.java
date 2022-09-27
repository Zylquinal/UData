package com.zylquinal.udata.array32;

import com.zylquinal.udata.UArray32;

public class UArrayLong32 extends UArray32 {

    public UArrayLong32(int size) {
        super(8, size);
    }

    public void add(long value) {
        if (count + 1 > size) {
            grow();
        }
        unsafe.putLong(address + count * bytes, value);
        count++;
    }

    public long get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return unsafe.getLong(address + index * bytes);
    }

    public void set(int index, long value) {
        setCheck(index);
        unsafe.putLong(address + index * bytes, value);
    }

    public long[] array() {
        long[] array = new long[size];
        for (int i = 0; i < size; i++) {
            array[i] = get(i);
        }
        return array;
    }

}
