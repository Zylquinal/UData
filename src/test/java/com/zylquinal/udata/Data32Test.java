package com.zylquinal.udata;

import com.zylquinal.udata.array32.*;
import org.junit.jupiter.api.Test;

public class Data32Test {

    @Test
    public void longCheck() {
        UArrayLong32 array = new UArrayLong32(10);
        array.set(0, Long.MAX_VALUE);
        assert array.get(0) == Long.MAX_VALUE;
        
        array.add(Long.MIN_VALUE);
        assert array.get(1) == Long.MIN_VALUE;

        array.free();
    }

    @Test
    public void shortCheck() {
        UArrayShort32 array = new UArrayShort32(10);
        array.set(0, Short.MAX_VALUE);
        assert array.get(0) == Short.MAX_VALUE;
        
        array.add(Short.MIN_VALUE);
        assert array.get(1) == Short.MIN_VALUE;

        array.free();
    }
    
    @Test
    public void intCheck() {
        UArrayInt32 array = new UArrayInt32(10);
        array.set(0, Integer.MAX_VALUE);
        assert array.get(0) == Integer.MAX_VALUE;
        
        array.add(Integer.MIN_VALUE);
        assert array.get(1) == Integer.MIN_VALUE;

        array.free();
    }

    @Test
    public void floatCheck() {
        UArrayFloat32 array = new UArrayFloat32(10);
        array.set(0, Float.MAX_VALUE);
        assert array.get(0) == Float.MAX_VALUE;
        
        array.add(Float.MIN_VALUE);
        assert array.get(1) == Float.MIN_VALUE;

        array.free();
    }

    @Test
    public void doubleCheck() {
        UArrayDouble32 array = new UArrayDouble32(10);
        array.set(0, Double.MAX_VALUE);
        assert array.get(0) == Double.MAX_VALUE;
        
        array.add(Double.MIN_VALUE);
        assert array.get(1) == Double.MIN_VALUE;

        array.free();
    }

    @Test
    public void byteCheck() {
        UArrayByte32 array = new UArrayByte32(10);
        array.set(0, Byte.MAX_VALUE);
        assert array.get(0) == Byte.MAX_VALUE;
        
        array.add(Byte.MIN_VALUE);
        assert array.get(1) == Byte.MIN_VALUE;

        array.free();
    }

    @Test
    public void growTest() {
        UArrayInt32 array = new UArrayInt32(10);
        for (int i = 0; i < 100; i++) {
            array.add(i);
        }
        assert array.get(99) == 99;
        assert array.getSize() == 120;

        array.free();
    }

}
