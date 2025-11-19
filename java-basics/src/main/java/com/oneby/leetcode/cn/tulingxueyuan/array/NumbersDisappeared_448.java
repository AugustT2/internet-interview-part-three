package com.oneby.leetcode.cn.tulingxueyuan.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Mark老师
 * @description ：(LeetCode-448)找到所有数组中消失的数字
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
 * 请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 */
public class NumbersDisappeared_448 {

    /**
     * 遍历数组，将每个数字 nums[i]对应的索引位置 (nums[i]-1)处的元素标记为负数， (nums[i]-1)就是nums[i]索引，比较为负数代表对应的索引出现了
     *
     * 再次遍历数组，如果某个位置 i的元素为正数，说明数字 i+1没有出现过
     *
     * 注意：在标记过程中要取绝对值，因为可能已经被标记过
     * @param nums
     * @return
     *
     * 想象有一个教室，有8个座位（对应数字1-8），每个座位上都贴着一个号码牌。
     * 让每个数字去"坐"到自己对应的座位上，然后把那个座位的号码牌翻到背面（变成负数）
     * 我们的数组 [4, 3, 2, 7, 8, 2, 3, 1]就是来"坐座位"的数字顺序。 比如4，对应正确的位置应该是索引3，只需要把所有3的值比较为负数，就代表索引3的应
     * 有数字4出现过，遍历完没有负数的索引就是缺的数字，值即使索引+1
     */
    public static List<Integer> findMissingNum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i])- 1;
            if(nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                list.add(i++);
            }
        }
        return list;
    }

    /*利用数组nums来记录数字是否出现过，把数字变为负数*/
    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            //if (num < 0 ) num = -num;
            int index = Math.abs(num) - 1 ;
            if( nums[index] >0 ) nums[index] = -nums[index];
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                ret.add(i + 1);
            }
        }
        return ret;
    }

    /*利用数组nums来记录数字是否出现过，对数字+n*/
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x =  (num - 1) % n ;/*对n取模来还原出它本来的值*/
            nums[x] += n;
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] temp = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(temp));
    }

}
