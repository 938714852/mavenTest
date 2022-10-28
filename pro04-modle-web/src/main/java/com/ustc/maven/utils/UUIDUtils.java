package com.ustc.maven.utils;

import java.util.UUID;

public class UUIDUtils {

    public static String get(){
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        System.out.println(get());
    }
}
