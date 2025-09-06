package com.oneby.suanfashuati;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class WordJielong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int n = sc.nextInt();

        String[] words = new String[n];
        for (int i = 0; i < n; i++) words[i] = sc.next();

        System.out.println(getResult(k, n, words));
    }

    public static String getResult(int k, int n, String[] words) {
        ArrayList<String> chain = new ArrayList<>();
        chain.add(words[k]);

        words[k] = null;

        HashMap<Character, LinkedList<String>> prefix = new HashMap<>();
        for (String word : words) {
            if (word != null) {
                char c = word.charAt(0);
                prefix.putIfAbsent(c, new LinkedList<>());
                prefix.get(c).add(word);
            }
        }

        for (Character c : prefix.keySet()) {
            prefix
                    .get(c)
                    .sort((a, b) -> a.length() != b.length() ? b.length() - a.length() : a.compareTo(b));
        }

        while (true) {
            String tail = chain.get(chain.size() - 1);
            char c = tail.charAt(tail.length() - 1);

            if (prefix.containsKey(c) && prefix.get(c).size() > 0) {
                chain.add(prefix.get(c).removeFirst());
            } else {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : chain) sb.append(s);
        return sb.toString();
    }
}
