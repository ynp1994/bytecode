package com.huawei.bytecode.type.constantpool;

import com.huawei.bytecode.type.U1;
import com.huawei.bytecode.type.U2;

import java.nio.ByteBuffer;

/**
 * 用于表示类或接口
 * @author yunaipeng
 * @date 2022-06-30 23:08
 */
public class ConstantClassInfo extends CpInfo{
    /**
     * 必须指向常量池表的一个有效索引，且必须指向ConstantUtf8Info
     */
    private U2 nameIndex;

    public ConstantClassInfo(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuf) throws Exception {
        nameIndex = new U2(codeBuf.get(), codeBuf.get());
    }

    public U2 getNameIndex() {
        return nameIndex;
    }

    @Override
    public String toString() {
        return "ConstantClassInfo{" +
                "nameIndex=" + nameIndex +
                '}';
    }
}
