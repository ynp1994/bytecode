package com.huawei.bytecode.handler;

import com.huawei.bytecode.type.ClassFile;
import com.huawei.bytecode.type.U2;

import java.nio.ByteBuffer;

/**
 * @author yunaipeng
 * @date 2022-07-01 00:43
 */
public class ThisAndSuperClassHandler implements BaseByteCodeHandler{
    @Override
    public int order() {
        return 4;
    }

    @Override
    public void read(ByteBuffer codeBuf, ClassFile classFile) throws Exception {
        U2 thisClass = new U2(codeBuf.get(), codeBuf.get());
        U2 superClass = new U2(codeBuf.get(), codeBuf.get());
        classFile.setThisClass(thisClass);
        classFile.setSuperClass(superClass);
    }
}
