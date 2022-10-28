package com.ustc.maven;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        int[] a = new int[100001];
        for (int i = 0; i < 10000;i ++){
            a[i] = (int)(Math.random()*10000);
        }
        System.out.println(Arrays.toString(a));
    }
}
