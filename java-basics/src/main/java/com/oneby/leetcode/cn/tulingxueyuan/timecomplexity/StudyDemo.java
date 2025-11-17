package com.oneby.leetcode.cn.tulingxueyuan.timecomplexity;

/**
 * @author ：Mark老师
 * @description：时间复杂度分析
 */
public class StudyDemo {

    int cal3(int n) {
        int sum_1 = 0;
        for (int p = 1; p < 100; ++p) {
            sum_1 = sum_1 + p;
        }
        int sum_2 = 0;
        for (int q = 1; q < n; ++q) {
            sum_2 = sum_2 + q;
        }
        int sum_3 = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                sum_3 = sum_3 + i * j;
            }
        }
        return sum_1 + sum_2 + sum_3;
    }

    int complexCal(int n) {
        int ret = 0;
        for (int i = 1; i < n; ++i) {
            ret = ret + f(i);
        }
        return ret;
    }

    int f(int n) {
        int sum = 0;
        int i = 1;
        for (; i < n; ++i) {
            sum = sum + i;
        }
        return sum;
    }

    int mnCal(int m, int n) {
        int sum_1 = 0;
        int i = 1;
        for (; i < m; ++i) {
            sum_1 = sum_1 + i;
        }
        int sum_2 = 0;
        int j = 1;
        for (; j < n; ++j) {
            sum_2 = sum_2 + j;
        }
        return sum_1 + sum_2;
    }


}
