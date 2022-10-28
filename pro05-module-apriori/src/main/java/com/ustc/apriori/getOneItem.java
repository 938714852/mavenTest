package com.ustc.apriori;

import java.util.*;

public class getOneItem {
    //得到数据的一项集
    public static ArrayList<String> get() {
        ArrayList<String> list = new ArrayList<String>();//初始化第1项集。
        list.add("Cardiacfailure");
        list.add("Myocardialinfarction");
        list.add("uremia");
        list.add("diabetes");
        list.add("Renalfailure");
        list.add("Other");
        return list;
    }
}
