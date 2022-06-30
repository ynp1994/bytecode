package com.huawei.bytecode.handler;

import java.nio.ByteBuffer;

/**
 * @author yunaipeng
 * @date 2022-06-30 22:58
 */
public interface ConstantInfoHandler {

    /**
     * read
     * @param codeBuf codeBuf
     * @throws Exception Exception
     */
    void read(ByteBuffer codeBuf) throws Exception;
}
