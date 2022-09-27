package com.zylquinal.udata.array32;

import com.zylquinal.udata.UArray32;

public class UArrayShort32 extends UArray32 {

    public UArrayShort32(int size) {
        super(2, size);
    }

    public void add(short value) {
        if (count + 1 > size) {
            grow();
        }
        unsafe.putShort(address + count * bytes, value);
        count++;
    }

    public short get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return unsafe.getShort(address + index * bytes);
    }
    
    public void set(int index, short value) {
        setCheck(index);
        unsafe.putShort(address + index * bytes, value);
    }
    
    public short[] array() {
        short[] array = new short[size];
        for (int i = 0; i < size; i++) {
            array[i] = get(i);
        }
        return array;
    }

}
