package com.oneby.leetcode.cn.tulingxueyuan.sort;

/**
 * @author Mark老师
 * 类说明：快速排序
 */
public class QuickSort2 {

    public int[] sortArray(int[] nums) {
        return sort(nums,0,nums.length-1);
    }

    public static int[] sort(int[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end)
            return null;
        if(end-start < 15) {
            insertSort(array,start,end);
        }else{
            /*数据分割成独立的两部分时，从哪儿分区的指示器*/
            int zoneIndex = partition(array, start, end);
            if (zoneIndex > start)
                sort(array, start, zoneIndex - 1);
            if (zoneIndex < end)
                sort(array, zoneIndex + 1, end);
            System.out.println("本轮排序后的数组");
            PrintArray.printIndex(array,start,end);
            System.out.println("--------------------");

        }
        return array;
    }
    /**
     * 快速排序分区方法
     */
    public static int partition(int[] array, int start, int end) {
        /*只有一个元素时，无需再分区*/
        if(start == end) return start;
        /*随机选取一个基准数*/
        int pivot = (int) (start + Math.random() * (end - start + 1));
        /*zoneIndex是分区指示器，初始值为分区头元素下标减一*/
        int zoneIndex = start - 1;
        System.out.println("开始下标："+start+",结束下标:"+end+",基准数下标："
                +pivot+",元素值:"+array[pivot]+"，分区指示器下标："+zoneIndex);
        /*将基准数和分区尾元素交换位置*/
        swap(array, pivot, end);
        for (int i = start; i <= end; i++){
            /*当前元素小于等于基准数*/
            if (array[i] <= array[end]) {
                /*首先分区指示器累加*/
                zoneIndex++;
                /*当前元素在分区指示器的右边时，交换当前元素和分区指示器元素*/
                if (i > zoneIndex)
                    swap(array, i, zoneIndex);
            }
            System.out.println("分区指示器："+zoneIndex+",遍历指示器:"+i);
            PrintArray.printIndex(array,start,end);
        }
        System.out.println("---------------");
        return zoneIndex;
    }

    private static void insertSort(int[] nums, int start, int end){
        int currentValue;/*当前待排序数据，该元素之前的元素均已被排序过*/
        for (int i = start; i <= end-1; i++) {
            int preIndex = i;/*已被排序数据的索引*/
            currentValue = nums[preIndex + 1];
            System.out.println("待排序元素索引:" + (i + 1) + "，值为：" + currentValue +
                    ",已被排序数据的索引:" + preIndex);

            /*在已被排序过数据中倒序寻找合适的位置，如果当前待排序数据比比较的元素要小，
            将比较的元素元素后移一位*/
            while (preIndex >= 0 && currentValue < nums[preIndex]) {
                //将当前元素后移一位
                nums[preIndex + 1] = nums[preIndex];
                preIndex--;
                PrintArray.print(nums);
            }
            /*while循环结束时，说明已经找到了当前待排序数据的合适位置，插入*/
            nums[preIndex + 1] = currentValue;
        }
    }

    /**
     * 交换数组内两个元素
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        PrintArray.print(PrintArray.SRC);
        System.out.println("============================================");
        int[] dest = new QuickSort2().sortArray(PrintArray.SRC);
        PrintArray.print(dest);
    }
}
