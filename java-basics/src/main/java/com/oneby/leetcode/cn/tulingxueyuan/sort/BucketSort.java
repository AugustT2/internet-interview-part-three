package com.oneby.leetcode.cn.tulingxueyuan.sort;

import java.util.ArrayList;

/**
 * @author Mark老师
 * 类说明：桶排序
 */
public class BucketSort {
    /**
     *
     * @param array
     * @param bucketCap 桶的容量，即每个桶所能放置多少个不同数值
     * @return
     */
    public static ArrayList<Integer> sort(ArrayList<Integer> array, int bucketCap) {
        if (array == null || array.size() < 2)
            return array;
        int max = array.get(0), min = array.get(0);
        // 找到最大值最小值
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max)
                max = array.get(i);
            if (array.get(i) < min)
                min = array.get(i);
        }
        /*获得桶的数量*/
        int bucketCount = (max - min) / bucketCap + 1;
        /*构建桶*/
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        ArrayList<Integer> resultArr = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        /*将原始数组中的数据分配到桶中*/
        for (int i = 0; i < array.size(); i++) {
            bucketArr.get((array.get(i) - min) / bucketCap).add(array.get(i));
        }
        /*看看桶中数据的分布*/
        for (int i = 0; i < bucketArr.size(); i++) {
            System.out.print("第"+i+"个桶包含数据：");
            PrintArray.printObject(bucketArr.get(i));
        }
        for (int i = 0; i < bucketCount; i++) {
            if (bucketCap == 1) {
                for (int j = 0; j < bucketArr.get(i).size(); j++)
                    resultArr.add(bucketArr.get(i).get(j));
            } else {
                if (bucketCount == 1)
                    bucketCap--;
                System.out.println("对第"+i+"桶中的数据再次用桶进行排序----");
                /*对桶中的数据再次用桶进行排序*/
                ArrayList<Integer> temp = sort(bucketArr.get(i), bucketCap);
                for (int j = 0; j < temp.size(); j++)
                    resultArr.add(temp.get(j));
            }
        }
        return resultArr;
    }

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(86);
        array.add(11);
        array.add(77);
        array.add(23);
        array.add(32);
        array.add(45);
        array.add(58);
        array.add(63);
        array.add(93);
        array.add(4);
        array.add(37);
        array.add(22);
        PrintArray.printObject(array);
        System.out.println("============================================");
        ArrayList<Integer> dest = BucketSort.sort(array,2);
        PrintArray.printObject(dest);
    }
}
