package com.oneby.leetcode.cn.tulingxueyuan.linklist;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Mark老师
 * @description ：(LeetCode-234) 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。
 * 如果是，返回 true ；否则，返回 false 。
 */
public class PalindromeLinkedList_234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // 1. 使用快慢指针找到中点，快的速度是慢点两倍，快的跑到最后一个节点的时候，slow刚刚好是一半也就是中点
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        /*如果链表是奇数个结点，把正中的归到左边*/
        if (fast != null) {
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    /*反转链表*/
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    /**
     * 数组 + 双指针,简单
     */
    public boolean isPalindrome2(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode current = head;

        // 将链表值存入数组
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }

        // 双指针判断回文
        int left = 0, right = list.size() - 1;
        while (left < right) {
            if (!list.get(left).equals(list.get(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
