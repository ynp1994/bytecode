package com.huawei.bytecode.test;

import java.util.EventListener;

/**
 * @author yunaipeng
 * @date 2022-06-29 23:55
 */
public class HelloWorld implements EventListener {
    private static String helloWorld = "Hello, World";

    public static void main(String[] args) {
        System.out.println(helloWorld);
    }
}
