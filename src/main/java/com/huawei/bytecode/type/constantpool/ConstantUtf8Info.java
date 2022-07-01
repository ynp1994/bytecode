package com.huawei.bytecode.type.constantpool;

import com.huawei.bytecode.type.U1;
import com.huawei.bytecode.type.U2;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author yunaipeng
 * @date 2022-06-30 23:01
 */
public class ConstantUtf8Info extends CpInfo {

    private U2 length;

    private byte[] bytes;

    public ConstantUtf8Info(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuf) throws Exception {
        length = new U2(codeBuf.get(), codeBuf.get());
        bytes = new byte[length.toInt()];
        codeBuf.get(bytes, 0, length.toInt());
    }

    @Override
    public String toString() {
        return "{ "+super.toString()
                + ", length = "
                + length.toInt()
                + ", str = "
                + new String(bytes, StandardCharsets.UTF_8) +" }";
    }
}
