package com.huawei.bytecode.handler;

import com.huawei.bytecode.type.ClassFile;

import java.nio.ByteBuffer;

/**
 * @author yunaipeng
 * @date 2022-06-29 22:50
 */
public interface BaseByteCodeHandler {

    int order();

    void read(ByteBuffer codeBuf, ClassFile classFile) throws Exception;
}
