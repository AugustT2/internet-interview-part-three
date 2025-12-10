package com.oneby.leetcode.cn.tulingxueyuan.linklist;

/**
 * @author ：Mark老师
 * @description ：剑指Offer 22：链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。
 * 为了符合大多数人的习惯，本题从1开始计数，
 * 即链表的尾节点是倒数第1个节点。
 */
public class KthFromTail_Offer22 {

    /**
     *步骤图解
     * 链表: 1 -> 2 -> 3 -> 4 -> 5, k = 2
     *
     * 步骤1: fast先走2步
     * slow: 1
     * fast: 1 → 2 → 3
     *
     * 步骤2: 同时移动
     * slow: 1 → 2 → 3 → 4
     * fast: 3 → 4 → 5 → null
     *
     * 结束: slow指向4，即倒数第2个节点
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        // 快指针先走k步
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null;  // 如果链表长度小于k，返回null
            }
            fast = fast.next;
        }

        // 快慢指针同时前进，直到快指针到达末尾
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;  // 慢指针指向倒数第k个节点
    }

    //这个没有上面这个好理解
    public static ListNode kthNodeFromEnd(ListNode head , int kthNode){
        if ( kthNode <= 0 || head == null) return null;
        ListNode pTemp = head, pKthNode = null;
        /*pTemp(沿着链表)移动了k-1次*/
        for(int count =1; count< kthNode;count++) {
            if (pTemp != null)
                pTemp = pTemp.next;
        }

        while(pTemp != null) {
            if (pKthNode == null)
                pKthNode = head;
            else
                pKthNode = pKthNode.next;
            pTemp = pTemp.next;
        }
        if(pKthNode != null)
            return pKthNode;
        return null;
    }

    public static void main(String[] args) {
        ListNode test = new ListNode(6);
        test.setNext(new ListNode(0))
                .setNext(new ListNode(11))
                .setNext(new ListNode(8))
                .setNext(new ListNode(9))
                .setNext(new ListNode(5))
                .setNext(new ListNode(4))
                .setNext(new ListNode(1));
        System.out.println(kthNodeFromEnd(test,11));

    }

}
