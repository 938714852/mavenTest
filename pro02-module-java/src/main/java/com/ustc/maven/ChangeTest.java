package com.ustc.maven;

import java.util.ArrayList;
import java.util.Arrays;

public class ChangeTest {
    public ArrayList ChangeInt(ArrayList a){
        a.add(1);
        System.out.println("方法中的a： " + a);
        return a;
    }

    public void ChangeInt2(int a){
        a =10;
    }

    public static void main(String[] args) {
        ArrayList<Integer> b = new ArrayList<Integer>();
        b.add(123);
        b.add(1234);
        System.out.println("未修改过的： " + b);
        ChangeTest changeTest = new ChangeTest();
        changeTest.ChangeInt(b);
        System.out.println("执行过change方法的b： " + b);
        int c = 2;
        changeTest.ChangeInt2(c);
        System.out.println("c : " + c);

    }
}
