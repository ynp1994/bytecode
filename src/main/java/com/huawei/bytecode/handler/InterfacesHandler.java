package com.huawei.bytecode.handler;

import com.huawei.bytecode.type.ClassFile;
import com.huawei.bytecode.type.U2;

import java.nio.ByteBuffer;

/**
 * @author yunaipeng
 * @date 2022-07-01 23:19
 */
public class InterfacesHandler implements BaseByteCodeHandler{
    @Override
    public int order() {
        return 5;
    }

    @Override
    public void read(ByteBuffer codeBuf, ClassFile classFile) throws Exception {
        U2 interfaceCount = new U2(codeBuf.get(), codeBuf.get());
        classFile.setInterfacesCount(interfaceCount);
        int interfacesCountVal = interfaceCount.toInt();
        U2[] interfaces = new U2[interfacesCountVal];
        for (int i = 0; i < interfacesCountVal; i++) {
            interfaces[i] = new U2(codeBuf.get(), codeBuf.get());
        }
        classFile.setInterfaces(interfaces);
    }
}
