package com.huawei.bytecode.handler;

import com.huawei.bytecode.type.ClassFile;
import com.huawei.bytecode.type.MethodInfo;
import com.huawei.bytecode.type.U2;

import java.nio.ByteBuffer;

/**
 * @author yunaipeng
 * @date 2022-07-02 00:39
 */
public class MethodHandler implements BaseByteCodeHandler{
    @Override
    public int order() {
        return 7;
    }

    @Override
    public void read(ByteBuffer codeBuf, ClassFile classFile) throws Exception {
        U2 methodsCount = new U2(codeBuf);
        classFile.setMethodsCount(methodsCount);
        int methodsCountVal = methodsCount.toInt();
        MethodInfo[] methods = new MethodInfo[methodsCountVal];
        for (int i = 0; i < methodsCountVal; i++) {
            methods[i] = new MethodInfo(codeBuf);
        }
        classFile.setMethods(methods);
    }
}
