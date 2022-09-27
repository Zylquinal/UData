package com.zylquinal.udata.array32;

import com.zylquinal.udata.UArray32;
import com.zylquinal.udata.UData;

public class UArrayFloat32 extends UArray32 {

    public UArrayFloat32(int size) {
        super(4, size);
    }

    public void add(float value) {
        if (count + 1 >= size) {
            grow();
        }
        UData.unsafe.putFloat(address + count * bytes, value);
        count++;
    }

    public float get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return unsafe.getFloat(address + index * bytes);
    }

    public void set(int index, float value) {
        setCheck(index);
        unsafe.putFloat(address + index * bytes, value);
    }

    public float[] array() {
        float[] array = new float[size];
        for (int i = 0; i < size; i++) {
            array[i] = get(i);
        }
        return array;
    }

}
