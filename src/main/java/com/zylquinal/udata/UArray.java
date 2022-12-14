package com.zylquinal.udata;

public abstract class UArray extends UData {

    protected final long bytes;
    protected long size;
    protected long count;

    public UArray(long bytes, long size) {
        super(bytes * size);
        this.bytes = bytes;
        this.size = size;
    }

    public void grow() {
        var newSize = size + (Math.round(Math.ceil(size * 0.5)));
        if (newSize < 0) { // overflow check
            newSize = Long.MAX_VALUE;
        }
        resize(newSize);
    }

    public void resize(long size) {
        super.reallocate(this.bytes * size);
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

    public long getSize() {
        return size;
    }

    public long getBytes() {
        return bytes;
    }

}
