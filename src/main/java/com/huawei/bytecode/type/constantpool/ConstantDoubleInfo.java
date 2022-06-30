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
public class ConstantDoubleInfo extends ConstantLongInfo {

    public ConstantDoubleInfo(U1 tag) {
        super(tag);
    }

}
