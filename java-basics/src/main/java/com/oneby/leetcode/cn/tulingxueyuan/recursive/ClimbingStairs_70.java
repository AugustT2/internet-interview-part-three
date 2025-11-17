package com.oneby.leetcode.cn.tulingxueyuan.recursive;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：Mark老师
 * @description ：(LeetCode-70) 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * * 注意：给定 n 是一个正整数。
 */
public class ClimbingStairs_70 {

    /*递归的解法*/
    public int climbStairsWithRecursive(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        return climbStairsWithRecursive(n-1)+climbStairsWithRecursive(n-2);
    }

    private Map<Integer,Integer> storeMap = new HashMap<>();
    /*递归的解法,用HashMap存储中间计算结果*/
    public int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(null != storeMap.get(n))
            return storeMap.get(n);
        else{
            int result = climbStairs(n-1)+climbStairs(n-2);
            storeMap.put(n,result);
            return  result;
        }
    }

    /*循环的解法，自底向上累加*/
    public int climbStairsNoRecursive(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        int result = 0;
        int pre = 2;
        int prePre = 1;
        for (int i = 3; i <= n; ++i) {
            result = pre + prePre;
            prePre = pre;
            pre = result;
        }
        return result;
    }

}
