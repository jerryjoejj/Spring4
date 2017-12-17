package com.lma.reflect;

public class ClassLoderTest {

    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println("Current class loader:" + classLoader);
        System.out.println("Parent class loader:" + classLoader.getParent());
        System.out.println("Grandparent class loader:" + classLoader.getParent().getParent());
    }
}
