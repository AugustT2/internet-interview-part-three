package com.oneby.suanfashuati;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * A={2,4,8},B={1,3,7},R=1
 */

public class ABR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        //方法一，用正则表达式
        /*Matcher m = Pattern.compile("A=\\{(.+)},B=\\{(.+)},R=(.+)").matcher(s);


        if (m.matches()) {
            int[] A = Arrays.stream(m.group(1).split(",")).mapToInt(Integer::parseInt).toArray();
            int[] B = Arrays.stream(m.group(2).split(",")).mapToInt(Integer::parseInt).toArray();
            Integer R = Integer.parseInt(m.group(3));*/

        //方法二，使用substring
        int aStart = input.indexOf("{") + 1;
        int aEnd = input.indexOf("}");
        String a = input.substring(aStart, aEnd);
        int bStart = aEnd + 5;
        int bEnd = input.lastIndexOf("}");
        String b = input.substring(bStart, bEnd);
        String c = input.substring(input.length() -1);
//        System.out.println(a + "----" +  b + "-----" + c);
        int[] A = Arrays.stream(a.split(",")).mapToInt(Integer::parseInt).toArray();
        int[] B = Arrays.stream(b.split(",")).mapToInt(Integer::parseInt).toArray();
        int R = Integer.parseInt(c);

        System.out.println(getResult2(A, B, R));
    }


    public static String getResult(int[] A, int[] B, Integer R) {
        StringBuilder sb = new StringBuilder();

        for (int a : A) {
            int cnt = 0;
            for (int b : B) {
                if (b < a) continue;
                if (b - a <= R || cnt == 0) {
                    sb.append("(").append(a).append(",").append(b).append(")");
                    cnt++;
                } else {
                    break;
                }
            }
        }

        return sb.toString();
    }

    public static String getResult2(int[] A, int[] B, Integer R) {
        StringBuilder sb = new StringBuilder();
        for (int a : A) {
            int cnt = 0;
            for (int b : B) {
                if(b < a) continue;
                if(b-a <= R || cnt == 0) {
                    sb.append("(").append(a).append(",").append(b).append(")");
                    cnt++;
                } else {
                    break;
                }
            }
        }
        return sb.toString();
    }
}
