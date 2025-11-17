package com.oneby.leetcode.cn.tulingxueyuan.linklist;

/**
 * @author ：Mark老师
 * @description ：(LeetCode-142) 环形链表II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 * 注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * 说明：不允许修改给定的链表。
 * 进阶： * 你是否可以使用 O(1) 空间解决此题？
 */
public class LinkedListCycleII_142 {

    public ListNode detectCycle(ListNode head) {
        if (head == null)  return null;
        ListNode slowPtr = head, fastPtr = head;
        boolean loopExists = false;
        while (fastPtr.next != null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr){
                loopExists = true;
                break;
            }
        }
        if(loopExists) {//环存在
            slowPtr = head;
            while (slowPtr != fastPtr) {
                fastPtr = fastPtr.next;
                slowPtr = slowPtr.next;
            }
            return slowPtr;//返回环的开始结点
        }
        return null; //环不存在
    }

}
