package com.huawei.bytecode.type.attribute;

import com.huawei.bytecode.type.U1;
import com.huawei.bytecode.type.U2;
import com.huawei.bytecode.type.U4;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * @author yunaipeng
 * @date 2022-06-29 22:54
 */
public class AttributeInfo extends AbstractAttribute {
    private byte[] info;

    public AttributeInfo(ByteBuffer codeBuf) {
        attributeNameIndex = new U2(codeBuf);
        attributeLength = new U4(codeBuf);
        info = new byte[attributeLength.toInt()];
        codeBuf.get(info, 0, attributeLength.toInt());
    }

    public byte[] getInfo() {
        return info;
    }

    public void setInfo(byte[] info) {
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
