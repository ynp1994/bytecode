package com.huawei.bytecode.constants;

import com.huawei.bytecode.type.U1;

/**
 * @author yunaipeng
 * @date 2022-06-30 00:15
 */
public enum ConstantPoolTag {
    /**
     * utf8
     */
    CONSTANT_UTF8_INFO(0x01),

    CONSTANT_INTEGER(0x03),
    CONSTANT_FLOAT(0x04),
    CONSTANT_LONG(0x05),
    CONSTANT_DOUBLE(0x06),
    CONSTANT_CLASS(0x07),
    CONSTANT_STRING(0x08),
    CONSTANT_FIELD_REF(0x09),
    CONSTANT_METHOD_REF(0x0A),
    CONSTANT_INTERFACE_METHOD_REF(0x0B),
    CONSTANT_NAME_AND_TYPE(0x0C),
    CONSTANT_METHOD_HANDLE(0x0F),
    CONSTANT_METHOD_TYPE(0x10),
    CONSTANT_INVOKE_DYNAMIC(0x12);

    private byte tag;

    ConstantPoolTag(int tag) {
        this.tag = (byte) tag;
    }

    public U1 getTag() {
        return new U1(tag);
    }
}
