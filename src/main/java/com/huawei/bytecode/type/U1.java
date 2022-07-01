package com.huawei.bytecode.type;

import java.nio.ByteBuffer;

/**
 * @author yunaipeng
 * @date 2022-06-30 00:10
 */
public class U1{

    private final byte value;

    public U1(byte value) {
        this.value = value;
    }

    public U1(ByteBuffer codeBuf) {
        this.value = codeBuf.get();
    }

    public int toInt() {
        return value & 0xFF;
    }

    public String toHexString() {
        char[] hexChar = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuilder hexStr = new StringBuilder();
        int v = value & 0xff;
        while (v > 0) {
            int c = v % 16;
            v = v >>> 4;
            hexStr.insert(0, hexChar[c]);
        }
        if (((hexStr.length() & 0x01) == 1)) {
            hexStr.insert(0, '0');
        }
        return "0x" + (hexStr.length() == 0 ? "00" : hexStr.toString());
    }

    @Override
    public String toString() {
        return this.toHexString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        U1 u1 = (U1) o;
        return toInt() == u1.toInt();
    }

    @Override
    public int hashCode() {
        return toInt();
    }
}
