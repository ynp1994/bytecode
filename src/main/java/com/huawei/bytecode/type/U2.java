package com.huawei.bytecode.type;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * @author yunaipeng
 * @date 2022-06-29 22:50
 */
public class U2 {
    private final byte[] value = new byte[2];

    public U2(byte b1, byte b2) {
        value[0] = b1;
        value[1] = b2;
    }

    public U2(ByteBuffer codeBuf) {
        value[0] = codeBuf.get();
        value[1] = codeBuf.get();
    }

    public int toInt() {
        return ((value[0] & 0xFF) << 8) | (value[1] & 0xFF);
    }

    public String toHexString() {
        char[] hexChar = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuilder hexStr = new StringBuilder();
        for (int i = 1; i >= 0; i--) {
            int v = value[i] & 0xff;
            while (v > 0) {
                int c = v % 16;
                v = v >>> 4;
                hexStr.insert(0, hexChar[c]);
            }
            if (((hexStr.length() & 0x01) == 1)) {
                hexStr.insert(0, '0');
            }
        }
        return "0x" + (hexStr.length() == 0 ? "00" : hexStr.toString());
    }

    @Override
    public String toString() {
        return this.toHexString();
    }
}
