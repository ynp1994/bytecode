package com.huawei.bytecode.type.constantpool;

import com.huawei.bytecode.type.U1;
import com.huawei.bytecode.type.U2;

import java.nio.ByteBuffer;

/**
 * 用于表示类或接口
 * @author yunaipeng
 * @date 2022-06-30 23:08
 */
public class ConstantStringInfo extends CpInfo{
    /**
     * 必须指向常量池表的一个有效索引，且必须指向ConstantUtf8Info
     */
    private U2 stringIndex;

    public ConstantStringInfo(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuf) throws Exception {
        stringIndex = new U2(codeBuf.get(), codeBuf.get());
    }
}
