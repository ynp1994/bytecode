package com.huawei.bytecode.type.constantpool;

import com.huawei.bytecode.type.U1;
import com.huawei.bytecode.type.U4;

import java.nio.ByteBuffer;

/**
 * 用于表示类或接口
 *
 * @author yunaipeng
 * @date 2022-06-30 23:08
 */
public class ConstantLongInfo extends CpInfo {
    /**
     * 高四位
     */
    private U4 highBytes;
    /**
     * 低四位
     */
    private U4 lowBytes;

    public ConstantLongInfo(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuf) throws Exception {
        highBytes = new U4(codeBuf.get(), codeBuf.get(), codeBuf.get(), codeBuf.get());
        lowBytes = new U4(codeBuf.get(), codeBuf.get(), codeBuf.get(), codeBuf.get());
    }
}
