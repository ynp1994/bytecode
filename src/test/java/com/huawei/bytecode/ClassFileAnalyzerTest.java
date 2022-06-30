package com.huawei.bytecode;

import com.huawei.bytecode.core.ClassFileAnalyzer;
import com.huawei.bytecode.type.ClassFile;
import com.huawei.bytecode.type.constantpool.ConstantClassInfo;
import com.huawei.bytecode.type.constantpool.CpInfo;
import com.huawei.bytecode.util.ClassAccessFlagUtils;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.file.Files;

/**
 * @author yunaipeng
 * @date 2022-06-29 23:45
 */
public class ClassFileAnalyzerTest {

    private ClassFileAnalyzer classFileAnalyzer = new ClassFileAnalyzer();

    @Test
    public void test() throws Exception {
        ByteBuffer codeBuf = readFile("/Users/yunaipeng/IdeaProjects/bytecode/target/test-classes/com/huawei/bytecode/test/HelloWorld.class");
        ClassFile classFile = classFileAnalyzer.analysis(codeBuf);
        String flag = ClassAccessFlagUtils.toClassAccessFlagsString(classFile.getAccessFlags());
        CpInfo[] constantPool = classFile.getConstantPool();
        ConstantClassInfo thisClass = (ConstantClassInfo) constantPool[classFile.getThisClass().toInt()];
        System.out.println("thisClass = " + constantPool[thisClass.getNameIndex().toInt()]);
        ConstantClassInfo superClass = (ConstantClassInfo) constantPool[classFile.getSuperClass().toInt()];
        System.out.println("superClass = " + constantPool[superClass.getNameIndex().toInt()]);
        System.out.println("flag = " + flag);
        System.out.println("classFile = " + classFile);
    }

    public static ByteBuffer readFile(String classFilePath) throws Exception {
        File file = new File(classFilePath);
        if (!file.exists()) {
            throw new Exception("file not exist");
        }
        byte[] byteCodeBuf = new byte[4096];
        try (InputStream in = Files.newInputStream(file.toPath())) {
            int length = in.read(byteCodeBuf);
            if (length < 1) {
                throw new Exception("not read byte code.");
            }
            return ByteBuffer.wrap(byteCodeBuf, 0, length).asReadOnlyBuffer();
        }
    }
}
