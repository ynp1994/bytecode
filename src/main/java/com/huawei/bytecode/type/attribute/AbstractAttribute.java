package com.huawei.bytecode.type.attribute;

import com.huawei.bytecode.type.U2;
import com.huawei.bytecode.type.U4;

/**
 * @author yunaipeng
 * @date 2022-07-02 09:35
 */
public abstract class AbstractAttribute {
    protected U2 attributeNameIndex;
    protected U4 attributeLength;

    public U2 getAttributeNameIndex() {
        return attributeNameIndex;
    }

    public void setAttributeNameIndex(U2 attributeNameIndex) {
        this.attributeNameIndex = attributeNameIndex;
    }

    public U4 getAttributeLength() {
        return attributeLength;
    }

    public void setAttributeLength(U4 attributeLength) {
        this.attributeLength = attributeLength;
    }
}
