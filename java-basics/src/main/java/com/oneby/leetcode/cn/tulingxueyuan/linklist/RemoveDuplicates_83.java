package com.oneby.leetcode.cn.tulingxueyuan.linklist;

/**
 * @author ：Mark老师
 * @description ：(LeetCode-83) 删除排序链表中的重复元素
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，
 * 请你删除所有重复的元素，使每个元素 只出现一次 。
 * 返回同样按升序排列的结果链表。
 */
public class RemoveDuplicates_83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode currentNode = head;
        while(null != currentNode.next){
            if(currentNode.next.val == currentNode.val){
                currentNode.next = currentNode.next.next;
            }else {
                currentNode = currentNode.next;
            }
        }
        return head;
    }

    /*递归处理,在本质上其实就是将链表压栈后倒序处理了*/
    public ListNode deleteDuplicatesRecursive(ListNode head) {
        if(head == null || head.next == null) return head;
        head.next = deleteDuplicatesRecursive(head.next);
        return head.val == head.next.val ? head.next : head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(5)))));
        RemoveDuplicates_83 removeDuplicates83 = new RemoveDuplicates_83();
        ListNode result = removeDuplicates83.deleteDuplicates(listNode);
        while (null != result) {
            System.out.print(result.val);
            if(null != result.next)System.out.print("->");
            result = result.next;
        }
    }

}
