package com.oneby.suanfashuati;

import java.util.Scanner;

public class WordWeight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] arr = sc.nextLine().split(" ");

        double sum = 0;
        for (String s : arr) {
            sum += s.length();
        }

        /**
         * "%.2f" 是格式化字符串，表示将数字格式化为浮点数，并保留2位小数
         * % 表示格式化的开始
         * .2 表示保留2位小数
         * f 表示浮点数格式
         */
        System.out.println(String.format("%.2f", sum / arr.length).toString());
    }
}
