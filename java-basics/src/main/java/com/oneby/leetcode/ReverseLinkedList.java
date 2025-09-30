package com.oneby.leetcode;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/**
 * 三指针实现，prev， cur， next后移，同时current.next = prev；
 * 使用三个指针（prev, current, next）逐个反转节点指向。
 *
 * while循环里面就是一个更改指针方向的代码和3各变量赋值的代码
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        //define next to store current's next
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
