package com.huawei.bytecode.type.constantpool;

import com.huawei.bytecode.type.U1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static com.huawei.bytecode.constants.ConstantPoolTag.*;

/**
 * @author yunaipeng
 * @date 2022-06-30 23:46
 */
public class ConstantPoolInfosMapper {

    static {
        HashMap<U1, Supplier<CpInfo>> tmpMap = new HashMap<>();
        tmpMap.put(CONSTANT_UTF8_INFO.getTag(), () -> new ConstantUtf8Info(CONSTANT_UTF8_INFO.getTag()));
        tmpMap.put(CONSTANT_INTEGER.getTag(), () -> new ConstantIntegerInfo(CONSTANT_INTEGER.getTag()));
        tmpMap.put(CONSTANT_FLOAT.getTag(), () -> new ConstantFloatInfo(CONSTANT_FLOAT.getTag()));
        tmpMap.put(CONSTANT_LONG.getTag(), () -> new ConstantLongInfo(CONSTANT_LONG.getTag()));
        tmpMap.put(CONSTANT_DOUBLE.getTag(), () -> new ConstantDoubleInfo(CONSTANT_DOUBLE.getTag()));
        tmpMap.put(CONSTANT_CLASS.getTag(), () -> new ConstantClassInfo(CONSTANT_CLASS.getTag()));
        tmpMap.put(CONSTANT_STRING.getTag(), () -> new ConstantStringInfo(CONSTANT_STRING.getTag()));
        tmpMap.put(CONSTANT_FIELD_REF.getTag(), () -> new ConstantFieldRefInfo(CONSTANT_FIELD_REF.getTag()));
        tmpMap.put(CONSTANT_METHOD_REF.getTag(), () -> new ConstantMethodRefInfo(CONSTANT_METHOD_REF.getTag()));
        tmpMap.put(CONSTANT_NAME_AND_TYPE.getTag(), () -> new ConstantNameAndTypeInfo(CONSTANT_NAME_AND_TYPE.getTag()));
        tmpMap.put(CONSTANT_METHOD_HANDLE.getTag(), () -> new ConstantMethodHandleInfo(CONSTANT_METHOD_HANDLE.getTag()));
        tmpMap.put(CONSTANT_METHOD_TYPE.getTag(), () -> new ConstantMethodTypeInfo(CONSTANT_METHOD_TYPE.getTag()));
        tmpMap.put(CONSTANT_INVOKE_DYNAMIC.getTag(), () -> new ConstantInvokeDynamicInfo(CONSTANT_INVOKE_DYNAMIC.getTag()));
        AVAILABLE_CONSTANT_POOL_INFOS = Collections.unmodifiableMap(tmpMap);
    }

    private static final Map<U1, Supplier<CpInfo>> AVAILABLE_CONSTANT_POOL_INFOS;

    private ConstantPoolInfosMapper() {

    }

    public static ConstantPoolInfosMapper getInstance() {
        return new ConstantPoolInfosMapper();
    }

    public CpInfo get(U1 tag) {
        CpInfo cpInfo = AVAILABLE_CONSTANT_POOL_INFOS.get(tag).get();
        if (cpInfo == null) {
            throw new IllegalArgumentException("Illegal tag!");
        }
        return cpInfo;
    }

}
