package com.oneby.leetcode.cn.tulingxueyuan.stackandqueue.DecodeString;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author ：Mark老师
 * @description ：(LeetCode-394) 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。
 * 注意 k 保证为正整数。
 * 示例 1：
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 */
public class DecodeString_394_UseList {

    int ptr;

    /*LeetCode官方解法*/
    public String decodeString(String s) {
        LinkedList<String> stk = new LinkedList<String>();
        ptr = 0;

        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {
                /*处理数字，使数字完整*/
                String digits = getDigits(s);
                stk.addLast(digits);
            } else if (Character.isLetter(cur) || cur == '[') {
                /*处理普通字符和“[”*/
                stk.addLast(String.valueOf(s.charAt(ptr++)));
            } else {
                /*遇见了“]”,处理相匹配的“[”之间的字符 */
                ++ptr;
                /*使用另一个list，将字符串进行组合*/
                LinkedList<String> sub = new LinkedList<String>();
                while (!"[".equals(stk.peekLast())) {
                    sub.addLast(stk.removeLast());
                }
                /*因为栈的特点，导致组合的字符串
                * 和原本的字符串相比是倒序的，
                * 需要反转一次*/
                Collections.reverse(sub);
                /* 左括号出栈*/
                stk.removeLast();
                /* 此时栈顶为当前 sub 对应的字符串应该出现的次数*/
                int repTime = Integer.parseInt(stk.removeLast());
                StringBuffer t = new StringBuffer();
                String o = getString(sub);
                // 构造字符串
                while (repTime-- > 0) {
                    t.append(o);
                }
                /* 构造好的字符串入栈*/
                stk.addLast(t.toString());
            }
        }

        return getString(stk);
    }

    public String getDigits(String s) {
        StringBuffer ret = new StringBuffer();
        while (Character.isDigit(s.charAt(ptr))) {
            ret.append(s.charAt(ptr++));
        }
        return ret.toString();
    }

    public String getString(LinkedList<String> v) {
        StringBuffer ret = new StringBuffer();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }


    public static void main(String[] args) {
        System.out.println(new DecodeString_394_UseList().decodeString("3[a2[c]]"));
    }
}
