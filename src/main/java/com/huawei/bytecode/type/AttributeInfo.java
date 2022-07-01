package com.huawei.bytecode.type;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * @author yunaipeng
 * @date 2022-06-29 22:54
 */
public class AttributeInfo {

    private U2 attributeNameIndex;
    private U4 attributeLength;
    private U1[] info;

    public AttributeInfo(ByteBuffer codeBuf) {
        attributeNameIndex = new U2(codeBuf);
        attributeLength = new U4(codeBuf);
        info = new U1[attributeLength.toInt()];
        for (int i = 0; i < attributeLength.toInt(); i++) {
            info[i] = new U1(codeBuf);
        }
    }

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

    public U1[] getInfo() {
        return info;
    }

    public void setInfo(U1[] info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "AttributeInfo{" +
                "attributeNameIndex=" + attributeNameIndex +
                ", attributeLength=" + attributeLength +
                ", info=" + Arrays.toString(info) +
                '}';
    }
}
