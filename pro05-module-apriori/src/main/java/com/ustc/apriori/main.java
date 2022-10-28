package com.ustc.apriori;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class main {
    public static int minSupCount;//最小支持度
    public static ArrayList<String> dataItem;//一维数组,记录原始数据的每一行

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        System.out.print("请输入最小支持度(整数&按Enter结束)：");
        minSupCount = scan.nextInt();

        //创建包含数组的list,即可看成是二维数组
        //与普通的二位数组不同的是，它可以动态改变大小
        ArrayList<List<String>> list = new ArrayList<List<String>>();//源数据保存在这里

        File file = new File("pro05-module-apriori/src/file/input.txt");//文件保存在当前目录
        BufferedReader input = new BufferedReader(new FileReader(file));

        String string = null;
        String[] temp;

        if (file.isFile()) {
            while ((string = input.readLine()) != null) {
                temp = string.split(" ");//分割疾病

                dataItem = new ArrayList<String>();//用到再创建
                for (int i = 0; i < temp.length; i++) {
                    if (temp[i].length() > 2) //分割的前面的数字编号去掉
                        dataItem.add(temp[i]);
                }
                list.add(dataItem);
                //System.out.println(dataItem);
            }
        }
        input.close();//关闭文件
        ArrayList<List<String>> item = new ArrayList<List<String>>();//初始化第1项集,并把其改为List类型
        ArrayList<String> minItem1 = new ArrayList<String>();
        ArrayList<String> minItem2 = new ArrayList<String>();
        ArrayList<String> minItem3 = new ArrayList<String>();
        ArrayList<String> minItem4 = new ArrayList<String>();
        ArrayList<String> minItem5 = new ArrayList<String>();
        ArrayList<String> minItem6 = new ArrayList<String>();
        minItem1.add("Cardiacfailure");//初始化第1项集。
        minItem2.add("Myocardialinfarction");
        minItem3.add("uremia");
        minItem4.add("diabetes");
        minItem5.add("Renalfailure");
        minItem6.add("Other");

        item.add(minItem1);
        item.add(minItem2);
        item.add(minItem3);
        item.add(minItem4);
        item.add(minItem5);
        item.add(minItem6);


        ArrayList<List<String>> test = new ArrayList<List<String>>();
        ArrayList<String> oneItem = new ArrayList<String>();//初始化第1项集。
        oneItem = getOneItem.get();//得到1项集。

        //啊啊啊啊啊啊啊啊啊啊

        int count = 0;
        while (true) {
            //System.out.println(test);
            if (count == 0)
                countKItem.caculate(list, item, minSupCount);//第一项集
            else
                countKItem.caculate(list, test, minSupCount);

            if (count == 0)
                test = addKItem.changeKTo(item, oneItem);    //第一项集
            else
                test = addKItem.changeKTo(test, oneItem);
            if (test.size() == 0) break;
            count++;
            System.out.println();
        }
        System.out.println("完美结束Apriori算法！");
        //countKItem.caculate(list, item, minSupCount);


        //System.out.print(list);
        //打印输出看效果
//		for(int i=0;i<list.size();i++)
//		{
//			for(int j=0;j<list.get(i).size();j++)
//				System.out.print(list.get(i).get(j)+" ");
//			System.out.println();
//		}


    }
}
