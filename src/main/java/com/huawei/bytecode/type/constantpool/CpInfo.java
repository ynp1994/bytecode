package com.huawei.bytecode.type.constantpool;

import com.huawei.bytecode.handler.ConstantInfoHandler;
import com.huawei.bytecode.type.U1;

/**
 * @author yunaipeng
 * @date 2022-06-29 22:54
 */
public abstract class CpInfo implements ConstantInfoHandler {

    private U1 tag;

    protected CpInfo(U1 tag) {
        this.tag = tag;
    }

    public static CpInfo newCpInfo(U1 tag) {
        return ConstantPoolInfosMapper.getInstance().get(tag);
    }

    @Override
    public String toString() {
        return "tag = "+tag.toHexString();
    }
}
