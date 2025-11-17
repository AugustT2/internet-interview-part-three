package com.oneby.leetcode.cn.tulingxueyuan.array;

/**
 * @author ：Mark老师
 * @description ：剑指Offer 53题目二：0～n-1中缺失的数字
 * 0～n-1中缺失的数字。
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，
 * 并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * 比如 [0,1,2,3,5,6,7,8]，这个数组长度为9-1，n为9，
 * 每个数字都在0~8之间，找到数组中缺失的4。
 */
public class MissNumber_offer53II {

    public static int missNumber(int[] nums){
        if (nums == null||nums.length==0) return -1;
        int startIndex = 0;
        int endIndex = nums.length-1;
        while(startIndex<=endIndex){
            int mid = (startIndex+endIndex) >> 1;
            if(nums[mid] != mid){
                if(mid == 0 || nums[mid-1] == mid - 1){
                    return mid;
                }else{
                    /*下一轮查找只需要查找左半边*/
                    endIndex = mid - 1;
                }
            }else{
                /*下一轮查找只需要查找右半边*/
                startIndex = mid + 1;
            }
        }

        /*处理一些边界条件，比如边界值测试(数组中只有一个数字0)*/
        if(startIndex == nums.length) return nums.length;

        /*其他情况返回 -1*/
        return -1;
    }

    public static void main(String[] args) {
        int[] test1 = {0,1,2,3,5,6,7,8};
        int[] test2 = {1,2,3,4,5,6,7,8};
        int[] test3 = {0,1,2,3,4,5,6,7};
        int[] test4 = {0};
        int[] test5 = {};
        System.out.println(missNumber(test1));
        System.out.println(missNumber(test2));
        System.out.println(missNumber(test3));
        System.out.println(missNumber(test4));
        System.out.println(missNumber(test5));



    }

}
