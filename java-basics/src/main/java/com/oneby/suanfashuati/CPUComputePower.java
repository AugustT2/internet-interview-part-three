package com.oneby.suanfashuati;

import java.util.HashSet;
import java.util.Scanner;

public class CPUComputePower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 可能有多组测试数据
        while (sc.hasNext()) {
            int l1 = sc.nextInt();
            int l2 = sc.nextInt();

            int sumA = 0;
            int[] A = new int[l1];
            for (int i = 0; i < l1; i++) {
                int a = sc.nextInt();
                sumA += a;
                A[i] = a;
            }

            int sumB = 0;
            HashSet<Integer> setB = new HashSet<>();
            for (int i = 0; i < l2; i++) {
                int b = sc.nextInt();
                sumB += b;
                setB.add(b);
            }

            // 由于本题必然存在解，因此sumA-sumB的结果肯定可以整除2，如果不能整除则half_diff为小数，
            // 而half_diff = a - b，其中a,b都是整数，因此不可能存在half_diff是小数的情况
            int half_diff = (sumA - sumB) / 2;

            // 记录用于交换的最小的a
            int minA = Integer.MAX_VALUE;
            String ans = "";

            for (int a : A) {
                int b = a - half_diff;

                if (setB.contains(b)) {
                    if (a < minA) {
                        minA = a;
                        ans = a + " " + b;
                    }
                }
            }

            System.out.println(ans);
        }
    }
}
