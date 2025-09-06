package com.oneby.suanfashuati;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordEncrypty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(getResult(s));
    }

    public static String getResult(String s) {
        String[] words = s.split(" ");

        for (int i = 0; i < words.length; i++) {
            Matcher matcher = Pattern.compile("[aeiouAEIOU]").matcher(words[i]);
            if (matcher.find()) {
                words[i] = matcher.replaceAll("*");
            } else {
                char[] cArr = words[i].toCharArray();
                char tmp = cArr[0];
                cArr[0] = cArr[cArr.length - 1];
                cArr[cArr.length - 1] = tmp;
                words[i] = new String(cArr);
            }
        }

        return String.join(" ", words);
    }
}
