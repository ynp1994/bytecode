package com.huawei.bytecode.handler;

import com.huawei.bytecode.type.ClassFile;
import com.huawei.bytecode.type.U2;
import com.huawei.bytecode.type.U4;

import java.nio.ByteBuffer;

/**
 * @author yunaipeng
 * @date 2022-06-29 23:27
 */
public class AccessFlagsHandler implements BaseByteCodeHandler{

    @Override
    public int order() {
        return 3;
    }

    @Override
    public void read(ByteBuffer codeBuf, ClassFile classFile) throws Exception {
        U2 accessFlags = new U2(codeBuf);
        classFile.setAccessFlags(accessFlags);
    }
}
