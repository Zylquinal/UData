package com.zylquinal.udata.array32;

import com.zylquinal.udata.UArray32;

public class UArrayDouble32 extends UArray32 {

    public UArrayDouble32(int size) {
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

    public double[] array() {
        double[] array = new double[size];
        for (int i = 0; i < size; i++) {
            array[i] = get(i);
        }
        return array;
    }

}
