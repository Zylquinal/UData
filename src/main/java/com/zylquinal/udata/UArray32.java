package com.zylquinal.udata;

public abstract class UArray32 extends UData {

    protected final long bytes;
    protected int size;
    protected long count;

    public UArray32(long bytes, int size) {
        super(bytes * size);
        this.bytes = bytes;
        this.size = size;
    }

    protected void grow() {
        var newSize = size + (Math.round(Math.ceil(size * 0.5)));
        if (newSize > Integer.MAX_VALUE) {
            newSize = Integer.MAX_VALUE;
        }
        resize((int) newSize);
    }

    public void resize(int size) {
        super.reallocate(bytes * size);
        this.size = size;
    }

    public void setCheck(long index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index >= count) {
            count = index + 1;
        }
    }

    public int getSize() {
        return size;
    }

    public long getBytes() {
        return bytes;
    }

}
