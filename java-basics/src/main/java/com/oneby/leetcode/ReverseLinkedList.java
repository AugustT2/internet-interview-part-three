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
    public ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        //define next to store current's next
        while (current != null) {
            //先保存current.next，以为后面这个指针就要没了
            ListNode next = current.next;
            // prev 向前移动时，需要吧之前的prev的值用掉才能覆盖；同时这里是指针重建，原来current.next的指针指向下一个，现在需要指向前一个
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        //创建一个“哑节点”（dummy node）作为链表的起始点，这样可以方便处理头节点的翻转。
        ListNode dummy = new ListNode(0, head);
        //初始化 prev指针指向哑节点，curr指针指向头节点。
        dummy.next = head;
        ListNode pre = dummy;
        while (pre != null) {
            ListNode cur = pre;
            //每次翻转前，从 curr开始向后遍历 k个节点，如果不足 k个，则停止。
            for (int i = 0; i < k; i++) {
                cur = cur.next;
                if (cur == null) {
                    return dummy.next;
                }
            }
            //注意for循环走完，cur为这一组的最后一个节点
            // 翻转当前组
            //node是当前组的第一个节点（即 pre.next）。
            ListNode node = pre.next;
            //nxt是下一组的第一个节点（即 cur.next）。
            ListNode nxt = cur.next;
            //断开当前组与下一组的连接，方便翻转。
            cur.next = null;
            //翻转当前组，并将 pre.next指向翻转后的头节点。
            pre.next = reverse(node);
            //将翻转后的组的尾部（即原来的头结点node）连接到下一组的头部。
            node.next = nxt;
            // 移动到下一组， pre永远指向整组的前一个
            pre = node;
        }
        return dummy.next;
    }

}
