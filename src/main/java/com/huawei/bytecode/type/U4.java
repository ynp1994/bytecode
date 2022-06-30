package com.huawei.bytecode.type;

import java.util.Arrays;

/**
 * @author yunaipeng
 * @date 2022-06-29 22:53
 */
public class U4 {
    private final byte[] value = new byte[4];

    public U4(byte b1, byte b2, byte b3, byte b4) {
        value[0] = b1;
        value[1] = b2;
        value[2] = b3;
        value[3] = b4;
    }

    public Integer toInt() {
        int a = (value[0] & 0xff) << 24;
        a |= (value[1] & 0xff) << 16;
        a |= (value[2] & 0xff) << 8;
        return a | (value[3] & 0xff);
    }

    public String toHexString() {
        char[] hexChar = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuilder hexStr = new StringBuilder();
        for (int i = 3; i >= 0; i--) {
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
        return "0x" + hexStr;
    }

    @Override
    public String toString() {
        return this.toHexString();
    }
}
