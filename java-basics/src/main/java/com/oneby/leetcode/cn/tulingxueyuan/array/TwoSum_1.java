package com.oneby.leetcode.cn.tulingxueyuan.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：Mark老师
 * @description ：(LeetCode-1)两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，
 * 请你在该数组中找出和为目标值 target 的那两个整数，
 * 并返回它们的数组下标。 你可以假设每种输入只会对应一个答案。
 * 但是，数组中同一个元素在答案里不能重复出现。
 */
public class TwoSum_1 {

    /*暴力穷举，复杂度O(n^2)*/
    public int[] normal(int[] nums, int target) {
        //if (nums.length<2) return new int[0];
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target) {
                    result[0] = i;
                    result[1] =j;
                    return result;
                }
            }
        }
        return result;
    }

    /*用一个哈希表，存储每个数对应的下标,时间复杂度是O(n)*/
    public int[] fastWithMap(int[] nums, int target) {
        /*key为元素值，value为每个元素对应的下标*/
        Map<Integer,Integer> storeNums = new HashMap<>(nums.length,1);
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            int another = target - nums[i];
            Integer anotherIndex = storeNums.get(another);
            if(null!=anotherIndex){
                result[0] = anotherIndex ;
                result[1] = i;
                break;
            }else{
                storeNums.put(nums[i],i);
            }
        }
        return result;
    }

    /*用一个哈希表，存储每个数对应的下标,时间复杂度是O(n)*/
    public int[] fastWithMap2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int anotherIndex = map.get(nums[i]);
                result[0] = anotherIndex ;
                result[1] = i;
                break;
            } else {
                map.put(target - nums[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4,6,13,8,7,9};
        int[] result = new TwoSum_1().fastWithMap(nums,20);
        for(int e:result){
            System.out.println(e);
        }
        int[] nums2 = {3,2,4};
        int[] result2 = new TwoSum_1().fastWithMap(nums2,6);
        for(int e:result2){
            System.out.println(e);
        }
    }

}
