package com.ustc.apriori;

import java.util.*;

public class countKItem {
    //data数组为原数组，list数组为k项集，support为最小支持度。
    //这个类主要是筛选符合置信度的k项集。
    static ArrayList<Integer> cMachine;//最终的频率计数器

    public static ArrayList<List<String>> caculate(ArrayList<List<String>> data, ArrayList<List<String>> list, int support) {
        ArrayList<List<String>> datalist = new ArrayList<List<String>>();//记录k项集符合>=最小置信度的项集
        ArrayList<Integer> countMachine = new ArrayList<Integer>();
        cMachine = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++) {
            int sum = 0;
            for (int raw = 0; raw < data.size(); raw++)//数据集第0行开始验证
            {
                int count = 0;
                for (int j = 0; j < list.get(i).size(); j++)//k项集的时候，计算k+1项集
                {
                    int n = liveUP(list.get(i).get(j), raw, data);
                    if (n == 1)
                        count += n;
                }
                if (count == list.get(i).size())
                    sum++;
            }
            if (sum >= support) {
                countMachine.add(sum);
                datalist.add(list.get(i));
            }


        }

        ArrayList<List<String>> List = new ArrayList<List<String>>();//记录k项集符合>=最小置信度的项集
        List = checkRight(datalist, countMachine);

        if (List.size() == 0) //直至符合置信度的项集为null
        {
            return List;
        }

        //下面打印输出k项集。
        System.out.printf("第 %d 级频数项集为:\n", list.get(0).size());
        System.out.println("       项集               " + "        频率   ");
        for (int i = 0; i < List.size(); i++) {
            for (int j = 0; j < List.get(i).size(); j++) {
                System.out.printf("%s   ", List.get(i).get(j));
            }

            System.out.print(cMachine.get(i));
            System.out.println();
        }

        return List;
    }

    public static ArrayList<List<String>> checkRight(ArrayList<List<String>> list, ArrayList<Integer> count)//验证数据项在数据集中是否重复：如a b 与b a 是重复的项集。
    {
        ArrayList<List<String>> temp = new ArrayList<List<String>>();
        for (int i = 0; i < list.size(); i++) {

            for (int j = i + 1; j < list.size(); j++) {
                int sum = 0;
                if (count.get(i) == count.get(j)) //支持度相等才检验。
                {

                    for (int x = 0; x < list.get(i).size(); x++) {
                        for (int y = 0; y < list.get(j).size(); y++) {
                            if (list.get(i).get(x) == list.get(j).get(y)) {
                                sum++;
                                break;
                            }
                        }
                    }
                    if (sum == list.get(i).size())
                        count.set(j, -1);//标为-1则表示要删除的。
                }
            }
        }

//		System.out.println(count);
        for (int i = 0; i < list.size(); i++) {

            if (count.get(i) != -1) {
                temp.add(list.get(i));
                cMachine.add(count.get(i));
            } else continue;
        }
        //System.out.println(temp);
        return temp;

    }

    public static int liveUP(String str, int raw, ArrayList<List<String>> data)//验证单个元素在数据集data第raw行中是否存在。
    {

        for (int i = 0; i < data.get(raw).size(); i++) {
            if (str.equals(data.get(raw).get(i)))
                return 1;
        }
        return 0;
    }

}
