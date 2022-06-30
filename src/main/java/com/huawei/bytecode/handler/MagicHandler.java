package com.huawei.bytecode.handler;

import com.huawei.bytecode.type.ClassFile;
import com.huawei.bytecode.type.U4;

import java.nio.ByteBuffer;

/**
 * @author yunaipeng
 * @date 2022-06-29 23:27
 */
public class MagicHandler implements BaseByteCodeHandler{

    private static final String MAGIC_NUMBER = "0xCAFEBABE";

    @Override
    public int order() {
        return 0;
    }

    @Override
    public void read(ByteBuffer codeBuf, ClassFile classFile) throws Exception {
        U4 magic = new U4(codeBuf.get(), codeBuf.get(), codeBuf.get(), codeBuf.get());
        if (!MAGIC_NUMBER.equals(magic.toHexString())) {
            throw new Exception("The file is not a class file.");
        }
        classFile.setMagic(magic);
    }
}
