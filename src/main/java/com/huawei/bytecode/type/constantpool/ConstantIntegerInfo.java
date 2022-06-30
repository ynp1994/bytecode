package com.huawei.bytecode.type.constantpool;

import com.huawei.bytecode.type.U1;
import com.huawei.bytecode.type.U2;
import com.huawei.bytecode.type.U4;

import java.nio.ByteBuffer;

/**
 * 用于表示类或接口
 *
 * @author yunaipeng
 * @date 2022-06-30 23:08
 */
public class ConstantIntegerInfo extends CpInfo {
    /**
     * 数值常量
     */
    private U4 bytes;

    public ConstantIntegerInfo(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuf) throws Exception {
        bytes = new U4(codeBuf.get(), codeBuf.get(), codeBuf.get(), codeBuf.get());
    }
}
