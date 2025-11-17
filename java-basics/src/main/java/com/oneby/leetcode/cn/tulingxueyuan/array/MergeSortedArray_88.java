package com.oneby.leetcode.cn.tulingxueyuan.array;


import java.util.Arrays;

/**
 * @author ：Mark老师
 * @description ：(LeetCode-88) 合并两个有序数组
 * 给你两个按 非递减顺序 排列的整数数组nums1 和 nums2，另有两个整数 m 和 n ，
 * 分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 */
public class MergeSortedArray_88 {

    /*数组合并在一起后，再进行排序,时间复杂度来为O((m+n)log(m+n))，空间复杂度为：O(log(m+n))*/
    public static void mergeNormal(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i< n; ++i) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    /*双指针处理,时间复杂度来为O(m+n)，空间复杂度为：O(m+n)*/
    public static void mergeFast(int[] nums1, int m, int[] nums2, int n) {
        int k = m+n;
        int[] temp = new int[k];
        for(int index = 0,nums1Index = 0,nums2Index = 0; index < k; index++){
            if(nums1Index >= m){/*nums1数组已经取完，完全取nums2数组的值即可*/
                temp[index] = nums2[nums2Index++];
            }else if(nums2Index >= n){/*nums2数组已经取完，完全取nums1数组的值即可*/
                temp[index] = nums1[nums1Index++];
            }else  if(nums1[nums1Index] < nums2[nums2Index]){
                /*nums1数组的元素值小于nums2数组，取nums1数组的值*/
                temp[index] = nums1[nums1Index++];
            }else{/*nums2数组的元素值小于等于nums1左边数组，取nums2数组的值*/
                temp[index] = nums2[nums2Index++];
            }
        }
        for(int i = 0; i < k; i++){
            nums1[i] = temp[i];
        }
    }

    /*双指针逆序处理，时间复杂度来为O(m+n)，空间复杂度为O(1)*/
    public static void mergeFastLessSpace(int[] nums1, int m, int[] nums2, int n) {
        int k = m+n;
        for(int index = k-1,nums1Index = m-1,nums2Index = n-1;
            index >= 0;
            index--){
            if(nums1Index < 0){/*nums1已经取完，完全取nums2的值即可*/
                nums1[index] = nums2[nums2Index--];
            }else if(nums2Index < 0){/*nums2已经取完，完全取nums1的值即可*/
                break;
            }else  if(nums1[nums1Index] > nums2[nums2Index]){/*nums1的元素值大于nums2，取nums1值*/
                nums1[index] = nums1[nums1Index--];
            }else{/*nums2的元素值大于等于nums1，取nums2的值*/
                nums1[index] = nums2[nums2Index--];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1  = {1,2,3,0,0,0};
        int[] nums2  = {2,5,6};
        int m=3,n=3;
        mergeFastLessSpace(nums1,m,nums2,n);
        for(int e:nums1){
            System.out.print(e);
        }
        System.out.println("");

        int[] nums3  = {1};
        int[] nums4  = {0};
        m=1;
        n=0;
        mergeFastLessSpace(nums3,m,nums4,n);
        for(int e:nums3){
            System.out.print(e);
        }
        System.out.println("");

        int[] nums5  = {0};
        int[] nums6  = {1};
        m=0;
        n=1;
        mergeFastLessSpace(nums5,m,nums6,n);
        for(int e:nums5){
            System.out.print(e);
        }
        System.out.println("");

    }

}
