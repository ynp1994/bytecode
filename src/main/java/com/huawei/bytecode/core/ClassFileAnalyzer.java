package com.huawei.bytecode.core;

import com.huawei.bytecode.handler.*;
import com.huawei.bytecode.type.ClassFile;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author yunaipeng
 * @date 2022-06-29 23:25
 */
public class ClassFileAnalyzer {
    private static final List<BaseByteCodeHandler> handlers = new ArrayList<>();

    static{
        handlers.add(new MagicHandler());
        handlers.add(new VersionHandler());
        handlers.add(new ConstantPoolHandler());
        handlers.add(new AccessFlagsHandler());
        handlers.add(new ThisAndSuperClassHandler());
        handlers.sort(Comparator.comparingInt(BaseByteCodeHandler::order));
    }

    public ClassFile analysis(ByteBuffer codeBuf) throws Exception {
        codeBuf.position(0);
        ClassFile classFile = new ClassFile();
        for (BaseByteCodeHandler handler : handlers) {
            handler.read(codeBuf, classFile);
        }
        return classFile;
    }
}
