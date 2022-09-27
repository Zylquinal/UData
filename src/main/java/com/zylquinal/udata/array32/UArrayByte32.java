package com.zylquinal.udata.array32;

import com.zylquinal.udata.UArray32;
import com.zylquinal.udata.UData;

public class UArrayByte32 extends UArray32 {

    public UArrayByte32(int size) {
        super(1, size);
    }

    public void add(byte value) {
        if (count + 1  > size) {
            grow();
        }
        unsafe.putByte(address + count * bytes, value);
        count++;
    }

    public void set(int index, byte value) {
        setCheck(index);
        UData.unsafe.putByte(address + index * bytes, value);
    }

    public byte get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return UData.unsafe.getByte(address + index * bytes);
    }

    public byte[] array() {
        byte[] array = new byte[size];
        for (int i = 0; i < size; i++) {
            array[i] = get(i);
        }
        return array;
    }

}
