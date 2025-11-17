package com.oneby.leetcode.cn.tulingxueyuan.search;

/**
 * @author ：Mark老师
 * @description ：(LeetCode-704) 二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 */
public class BinSearch_704 {

    /*循环实现*/
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while(start<=end) {
            int mid=(start+end)/2;
            if(target>nums[mid]) {
                start=mid+1;
            }else if(target<nums[mid]) {
                end=mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    /*递归实现*/
    public int searchWithRecursive(int[] nums, int target) {
        return searchNums(nums,0,nums.length - 1,target);
    }

    private int searchNums(int[] arr,int start,int end,int key){
        int mid=(start+end)/2; //每次折半比较
        if(start<=end) {
            if(key>arr[mid]) {
                return searchNums(arr,mid+1,end,key);
            }else if(key<arr[mid]) {
                return searchNums(arr,start,mid-1,key);
            }else {
                return mid;
            }
        }else {
            return -1;
        }
    }
}
