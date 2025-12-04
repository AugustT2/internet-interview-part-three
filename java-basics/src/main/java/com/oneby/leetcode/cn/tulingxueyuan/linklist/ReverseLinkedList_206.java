package com.oneby.leetcode.cn.tulingxueyuan.linklist;

/**
 * @author ：Mark老师
 * @description ：(LeetCode-206)链表反转
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */

/**
 * 这个题目本身没有什么特别难的地方，主要是要注意，在我们遍历链表的时候，在对每一个节点处理的过程中，因为要将当前结点的next 指针改为指向前一个节点。
 * 但这是单链表，节点是没有引用其前一个节点的，因此我们必须事先存储其前一个节点。所以，这个本质上来说，还是一种双指针的运用。
 */
public class ReverseLinkedList_206 {

    public ListNode reverseList(ListNode head) {
        ListNode preNode = null;
        ListNode currNode = head;
        while(currNode != null){
            /*因为下面要把currNode的next改为指向preNode
            * 为了不丢失本来的结点指向，所以所以需要事先保存一下*/
            ListNode next = currNode.next;
            currNode.next = preNode;
            /*移动双指针*/
            preNode = currNode;
            currNode = next;
        }
        return preNode;
    }



}
