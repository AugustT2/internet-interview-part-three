package com.oneby.suanfashuati;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/**
 * 题目描述
 * 有一个特殊的5键键盘，上面有a，ctrl-c，ctrl-x，ctrl-v，ctrl-a五个键。
 * <p>
 * a键在屏幕上输出一个字母a；
 * <p>
 * ctrl-c将当前选择的字母复制到剪贴板；
 * <p>
 * ctrl-x将当前选择的字母复制到剪贴板，并清空选择的字母；
 * <p>
 * ctrl-v将当前剪贴板里的字母输出到屏幕；
 * <p>
 * ctrl-a选择当前屏幕上的所有字母。
 * <p>
 * 注意：
 * <p>
 * 剪贴板初始为空，新的内容被复制到剪贴板时会覆盖原来的内容
 * 当屏幕上没有字母时，ctrl-a无效
 * 当没有选择字母时，ctrl-c和ctrl-x无效
 * 当有字母被选择时，a和ctrl-v这两个有输出功能的键会先清空选择的字母，再进行输出
 * 给定一系列键盘输入，输出最终屏幕上字母的数量。
 * <p>
 * 输入描述
 * 输入为一行，为简化解析，用数字1 2 3 4 5代表a，ctrl-c，ctrl-x，ctrl-v，ctrl-a五个键的输入，数字用空格分隔。
 * 输出描述
 * 输出一个数字，为最终屏幕上字母的数量。
 * 用例
 * 输入	1 1 1
 * 输出	3
 * 说明	连续键入3个a，故屏幕上字母的长度为3。
 * 输入  1 1 5 1 5 2 4 4
 * 输出	2
 * 说明
 * 输入两个a后ctrl-a选择这两个a，再输入a时选择的两个a先被清空，所以此时屏幕只有一个a，
 * <p>
 * 后续的ctrl-a，ctrl-c选择并复制了这一个a，最后两个ctrl-v在屏幕上输出两个a，
 * <p>
 * 故屏幕上字母的长度为2（第一个ctrl-v清空了屏幕上的那个a）。
 */
public class FiveKeyBoard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> inputList = new ArrayList<>();
        while (sc.hasNext()) {
            inputList.clear();
            String s = sc.nextLine();
            Object[] s1 = Arrays.stream(s.split(" ")).toArray();
            for (Object object : s1) {
                inputList.add(Integer.parseInt(object.toString()));
            }
//            System.out.println(inputList);
            int result = getInputresult(inputList);
            System.out.println(result);
        }
    }

    private static int getInputresult(List<Integer> inputList) {
        List<String> screen = new ArrayList<>();
        List<String> clipBoard = new ArrayList<>();
        boolean isSelected = false;
        for (Integer s : inputList) {
            switch (s) {
                case 1:
                    if (isSelected) screen.clear();
                    screen.add("a");
                    isSelected = false;
                    break;
                case 2:
                    if (isSelected) {
                        clipBoard.clear();
                        clipBoard.addAll(screen);
                    }
                    break;
                case 3:
                    if (isSelected) {
                        clipBoard.clear();
                        clipBoard.addAll(screen);
                        screen.clear();
                    }
                    isSelected = false;
                    break;
                case 4:
                    if (isSelected) screen.clear();
                    screen.addAll(clipBoard);
                    isSelected = false;
                    break;
                case 5:
                    isSelected = true;
                    break;
            }
        }
        return screen.size();
    }
}
