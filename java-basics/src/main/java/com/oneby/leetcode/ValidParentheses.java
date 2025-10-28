package com.oneby.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.HashMap;

public class ValidParentheses {
    public boolean isValid(String s) {
        // 使用HashMap存储括号的对应关系
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        // 使用栈来存储遇到的左括号
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 如果是右括号
            if (map.containsKey(c)) {
                // 如果栈为空或者栈顶元素不匹配当前右括号对应的左括号
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            }
            // 如果是左括号
            else {
                stack.push(c);
            }
        }

        // 最后检查栈是否为空
        return stack.isEmpty();
    }

    // 测试代码
    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();

        String[] testCases = {
                "()",        // true
                "()[]{}",    // true
                "(]",        // false
                "([)]",      // false
                "{[]}",      // true
                "]",         // false
                "(",         // false
                ""           // true
        };

        for (String test : testCases) {
            System.out.println("\"" + test + "\" -> " + solution.isValid(test));
        }
    }

    //不用Map实现
    public boolean isValid2(String s) {
        Deque<Character> stk = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stk.push(c);
            } else if (stk.isEmpty() || !match(stk.pop(), c)) {
                return false;
            }
        }
        return stk.isEmpty();
    }

    private boolean match(char l, char r) {
        return (l == '(' && r == ')') || (l == '{' && r == '}') || (l == '[' && r == ']');
    }
}
