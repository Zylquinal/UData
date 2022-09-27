package com.zylquinal.udata;

import com.zylquinal.udata.array.*;
import org.junit.jupiter.api.Test;

public class DataTest {

    @Test
    public void longTest() {
        UArrayLong array = new UArrayLong(10);
        array.set(0, Long.MAX_VALUE);
        assert array.get(0) == Long.MAX_VALUE;

        array.add(Long.MIN_VALUE);
        assert array.get(1) == Long.MIN_VALUE;

        array.free();
    }

    @Test
    public void intTest() {
        UArrayInt array = new UArrayInt(10);
        array.set(0, Integer.MAX_VALUE);
        assert array.get(0) == Integer.MAX_VALUE;

        array.add(Integer.MIN_VALUE);
        assert array.get(1) == Integer.MIN_VALUE;

        array.free();
    }

    @Test
    public void byteTest() {
        UArrayByte array = new UArrayByte(10);
        array.set(0, Byte.MAX_VALUE);
        assert array.get(0) == Byte.MAX_VALUE;

        array.add(Byte.MIN_VALUE);
        assert array.get(1) == Byte.MIN_VALUE;

        array.free();
    }

    @Test
    public void floatTest() {
        UArrayFloat array = new UArrayFloat(10);
        array.set(0, Float.MAX_VALUE);
        assert array.get(0) == Float.MAX_VALUE;

        array.add(Float.MIN_VALUE);
        assert array.get(1) == Float.MIN_VALUE;

        array.free();
    }

    @Test
    public void doubleTest() {
        UArrayDouble array = new UArrayDouble(10);
        array.set(0, Double.MAX_VALUE);
        assert array.get(0) == Double.MAX_VALUE;

        array.add(Double.MIN_VALUE);
        assert array.get(1) == Double.MIN_VALUE;

        array.free();
    }

    @Test
    public void charTest() {
        UArrayChar array = new UArrayChar(10);
        array.set(0, Character.MAX_VALUE);
        assert array.get(0) == Character.MAX_VALUE;

        array.add(Character.MIN_VALUE);
        assert array.get(1) == Character.MIN_VALUE;

        array.free();
    }

    @Test
    public void shortTest() {
        UArrayShort array = new UArrayShort(10);
        array.set(0, Short.MAX_VALUE);
        assert array.get(0) == Short.MAX_VALUE;

        array.add(Short.MIN_VALUE);
        assert array.get(1) == Short.MIN_VALUE;

        array.free();
    }

    @Test
    public void growTest() {
        UArrayFloat array = new UArrayFloat(10);
        for (int i = 0; i < 100; i++) {
            array.add(i);
        }
        assert array.get(99) == 99;
        assert array.getSize() == 120;

        array.free();
    }

}
