package com.huawei.bytecode.type;

import com.huawei.bytecode.type.attribute.AttributeInfo;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * @author yunaipeng
 * @date 2022-06-29 22:53
 */
public class FieldInfo {

    private U2 accessFlags;
    private U2 nameIndex;
    private U2 descriptorIndex;
    private U2 attributesCount;
    private AttributeInfo[] attributes;

    public U2 getAccessFlags() {
        return accessFlags;
    }

    public void setAccessFlags(U2 accessFlags) {
        this.accessFlags = accessFlags;
    }

    public U2 getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(U2 nameIndex) {
        this.nameIndex = nameIndex;
    }

    public U2 getDescriptorIndex() {
        return descriptorIndex;
    }

    public void setDescriptorIndex(U2 descriptorIndex) {
        this.descriptorIndex = descriptorIndex;
    }

    public U2 getAttributesCount() {
        return attributesCount;
    }

    public void setAttributesCount(U2 attributesCount) {
        this.attributesCount = attributesCount;
    }

    public AttributeInfo[] getAttributes() {
        return attributes;
    }

    public void setAttributes(AttributeInfo[] attributes) {
        this.attributes = attributes;
    }
    public FieldInfo(ByteBuffer codeBuf) {
        accessFlags = new U2(codeBuf);
        nameIndex = new U2(codeBuf);
        descriptorIndex = new U2(codeBuf);
        attributesCount = new U2(codeBuf);
        attributes = new AttributeInfo[attributesCount.toInt()];
        for (int i = 0; i < attributesCount.toInt(); i++) {
            attributes[i] = new AttributeInfo(codeBuf);
        }
    }

    @Override
    public String toString() {
        return "FieldInfo{" +
                "accessFlags=" + accessFlags +
                ", nameIndex=" + nameIndex +
                ", descriptorIndex=" + descriptorIndex +
                ", attributesCount=" + attributesCount +
                ", attributes=" + Arrays.toString(attributes) +
                '}';
    }
}
