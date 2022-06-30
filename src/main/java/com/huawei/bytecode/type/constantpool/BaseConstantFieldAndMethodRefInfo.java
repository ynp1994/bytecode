package com.huawei.bytecode.type.constantpool;

import com.huawei.bytecode.type.U1;
import com.huawei.bytecode.type.U2;

import java.nio.ByteBuffer;

/**
 * 字段
 *
 * @author yunaipeng
 * @date 2022-06-30 23:08
 */
public class BaseConstantFieldAndMethodRefInfo extends CpInfo {
    /**
     * 对常量池表的有效索引，必须指向ConstantClassInfo
     */
    private U2 classIndex;
    /**
     * 对常量池表的有效索引，必须指向ConstantNameAndType
     * 表示当前字段的名字和描述符
     */
    private U2 nameAndTypeIndex;

    public BaseConstantFieldAndMethodRefInfo(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuf) throws Exception {
        classIndex = new U2(codeBuf.get(), codeBuf.get());
        nameAndTypeIndex = new U2(codeBuf.get(), codeBuf.get());
    }
}
