package com.oneby.leetcode.cn.tulingxueyuan.linklist;

import java.util.HashSet;

/**
 * @author ：Mark老师
 * @description ：(LeetCode-141) 环形链表
 * 给定个链表，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 * 注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 * 进阶：你能用 O(1)内存解决此问题吗？
 */
//Floyd环判定算法
public class LinkedListCycle_141 {

    public boolean hasCycle(ListNode head) {
        if (head == null)  return false;
        ListNode slowPtr = head, fastPtr = head;
        while (fastPtr.next != null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr)
                return true;
        }
        return false;
    }

    //用hash表来解决  ---hashSet
    public static boolean isCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode current = head;  // 使用临时变量，避免修改原head
        while(current != null) {
            if(hashSet.contains(current)) {
                return true;
            } else {
                hashSet.add(current);
                current = current.next;
            }
        }
        return false;
    }

    //更简洁 add方法在元素已存在时返回false
    public boolean isCycleList(ListNode head) {
        HashSet<ListNode> visited = new HashSet<>();
        ListNode current = head;

        while (current != null) {
            //源码中：If this set already contains the element, the call leaves the set unchanged and returns false.
            if (!visited.add(current)) {  // add方法在元素已存在时返回false
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public static void main(String[] args) {
        // 测试有环链表
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node2; // 形成环：1->2->3->2

        System.out.println(isCycle(node1)); // 应该返回true

        // 测试无环链表
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);

        System.out.println(isCycle(list)); // 应该返回false

        // 测试自环（单个节点指向自己）
        ListNode selfLoop = new ListNode(1);
        selfLoop.next = selfLoop;

        System.out.println(isCycle(selfLoop)); // 应该返回true
    }
}
