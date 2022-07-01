package com.huawei.bytecode.handler;

import com.huawei.bytecode.type.ClassFile;
import com.huawei.bytecode.type.FieldInfo;
import com.huawei.bytecode.type.U2;

import java.nio.ByteBuffer;

/**
 * @author yunaipeng
 * @date 2022-07-01 23:42
 */
public class FieldHandler implements BaseByteCodeHandler{
    @Override
    public int order() {
        return 6;
    }

    @Override
    public void read(ByteBuffer codeBuf, ClassFile classFile) throws Exception {
        U2 fieldCount = new U2(codeBuf);
        classFile.setFieldsCount(fieldCount);
        int fieldCountVal = fieldCount.toInt();
        FieldInfo[] fields = new FieldInfo[fieldCountVal];
        for (int i = 0; i < fieldCountVal; i++) {
            fields[i] = new FieldInfo(codeBuf);
        }
        classFile.setFields(fields);
    }
}
