package com.huawei.bytecode.handler;

import com.huawei.bytecode.type.AttributeInfo;
import com.huawei.bytecode.type.ClassFile;
import com.huawei.bytecode.type.U2;

import java.nio.ByteBuffer;

/**
 * @author yunaipeng
 * @date 2022-07-02 00:49
 */
public class AttributeHandler implements BaseByteCodeHandler{
    @Override
    public int order() {
        return 8;
    }

    @Override
    public void read(ByteBuffer codeBuf, ClassFile classFile) throws Exception {
        U2 attributesCount = new U2(codeBuf);
        classFile.setAttributesCount(attributesCount);
        int attributesCountVal = attributesCount.toInt();
        AttributeInfo[] attributes = new AttributeInfo[attributesCountVal];
        for (int i = 0; i < attributesCountVal; i++) {
            attributes[i] = new AttributeInfo(codeBuf);
        }
        classFile.setAttributes(attributes);
    }
}
