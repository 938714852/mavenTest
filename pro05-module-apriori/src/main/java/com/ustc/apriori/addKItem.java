package com.ustc.apriori;

import java.util.*;

public class addKItem {
    //list为K项集，support为最小置信度,返回的dataList为K+1项集。

    public static ArrayList<String> temp;
    static ArrayList<List<String>> dataList;

    public static ArrayList<List<String>> changeKTo(ArrayList<List<String>> list, ArrayList<String> oneItem) {


        dataList = new ArrayList<List<String>>();

        ArrayList<Integer> count = new ArrayList<Integer>();//计算k+1项集的支持度
        for (int i = 0; i < list.size(); i++) {
            temp = new ArrayList<String>();
            for (int j = 0; j < list.get(i).size(); j++)//把k项集的第i行元素复制过来。
                temp.add(list.get(i).get(j));
            //System.out.println(temp);

            for (int x = 0; x < oneItem.size(); x++)//K+1项集生成。
            {
                int flag = 0;
                flag = check(oneItem.get(x), temp);
                //System.out.println(flag);
                ArrayList<String> temp1 = new ArrayList<String>();
                if (flag == 1) {
                    temp.add(oneItem.get(x));
                    for (int y = 0; y < temp.size(); y++)
                        temp1.add(temp.get(y));
                    dataList.add(temp1);//不能直接add(temp)，引用同一对象会覆盖。
                    //System.out.println(temp1);
                    temp.remove(temp.size() - 1);
                }
            }

        }

        //System.out.println(dataList);

        return dataList;
    }

    public static int check(String string, ArrayList<String> item)//元素不重复加入
    {

        for (int i = 0; i < item.size(); i++) {
            if (string.equals(item.get(i)))
                return 0;
        }
        return 1;

    }

}

