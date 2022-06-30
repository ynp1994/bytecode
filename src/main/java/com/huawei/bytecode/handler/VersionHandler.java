package com.huawei.bytecode.handler;

import com.huawei.bytecode.type.ClassFile;
import com.huawei.bytecode.type.U2;
import com.huawei.bytecode.type.U4;

import java.nio.ByteBuffer;

/**
 * @author yunaipeng
 * @date 2022-06-30 00:05
 */
public class VersionHandler implements BaseByteCodeHandler{
    @Override
    public int order() {
        return 1;
    }

    @Override
    public void read(ByteBuffer codeBuf, ClassFile classFile) throws Exception {
        U2 minorVersion = new U2(codeBuf.get(), codeBuf.get());
        U2 majorVersion = new U2(codeBuf.get(), codeBuf.get());
        classFile.setMinorVersion(minorVersion);
        classFile.setMajorVersion(majorVersion);
    }
}
