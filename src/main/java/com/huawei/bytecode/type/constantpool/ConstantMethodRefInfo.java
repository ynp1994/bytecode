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
public class ConstantMethodRefInfo extends BaseConstantFieldAndMethodRefInfo {
    public ConstantMethodRefInfo(U1 tag) {
        super(tag);
    }
}
