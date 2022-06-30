package com.huawei.bytecode.handler;

import com.huawei.bytecode.type.ClassFile;
import com.huawei.bytecode.type.U1;
import com.huawei.bytecode.type.U2;
import com.huawei.bytecode.type.constantpool.CpInfo;

import java.nio.ByteBuffer;

/**
 * @author yunaipeng
 * @date 2022-07-01 00:19
 */
public class ConstantPoolHandler implements BaseByteCodeHandler {
    @Override
    public int order() {
        return 2;
    }

    @Override
    public void read(ByteBuffer codeBuf, ClassFile classFile) throws Exception {
        U2 constantPoolCount = new U2(codeBuf.get(), codeBuf.get());
        classFile.setConstantPoolCount(constantPoolCount);
        CpInfo[] cpInfos = new CpInfo[constantPoolCount.toInt()];
        classFile.setConstantPool(cpInfos);
        for (int i = 1; i < constantPoolCount.toInt(); i++) {
            U1 tag = new U1(codeBuf.get());
            CpInfo cpInfo = CpInfo.newCpInfo(tag);
            cpInfo.read(codeBuf);
            cpInfos[i] = cpInfo;
        }
    }
}
