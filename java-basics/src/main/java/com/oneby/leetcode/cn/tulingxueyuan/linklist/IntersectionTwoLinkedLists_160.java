package com.oneby.leetcode.cn.tulingxueyuan.linklist;

/**
 * @author ：Mark老师
 * @description ：(LeetCode-160) 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，
 * 请你找出并返回两个单链表相交的起始节点。
 * 如果两个链表没有交点，返回 null 。
 */


/**
 * 核心算法原理：双指针“浪漫相遇”法
 * 这是最巧妙且空间复杂度为 O(1) 的解法。
 *
 * 算法步骤
 * 初始化两个指针：pA指向 headA，pB指向 headB
 *
 * 同时遍历：两个指针每次各向前走一步
 *
 * 走到尽头时切换路径：
 *
 * 当 pA走到 A 链表末尾时，让它从 headB开始继续走
 *
 * 当 pB走到 B 链表末尾时，让它从 headA开始继续走
 *
 * 相遇点即为交点：两个指针最终会在交点相遇，或者同时到达末尾（null）
 *
 * 原理证明（数学解释）
 * 设：
 *
 * A 链表独有部分长度为 a
 *
 * B 链表独有部分长度为 b
 *
 * 公共部分长度为 c
 *
 * 指针 pA的路径：a + c + b（先走完A，再走B）
 *
 * 指针 pB的路径：b + c + a（先走完B，再走A）
 *
 * 路径长度相等：a + c + b = b + c + a
 *
 * 两种情况：
 *
 * 有交点（c > 0）：
 *
 * 两个指针会在走完 a + b + c步后在交点相遇
 *
 * 因为它们在交点后的路径完全重合
 *
 * 无交点（c = 0）：
 *
 * 两个指针都会在走完 a + b步后同时到达 null
 *
 * 因为 a + b + 0 = b + a + 0
 */
public class IntersectionTwoLinkedLists_160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            /*pa或者pb不为空，则后移一个指针，为空则指向另一个链表*/
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int L1=0,L2=0, diff=0;
        ListNode head1 = headA , head2 = headB;
        while(head1 != null){
            L1++;
            head1 = head1.next;
        }
        while(head2 != null){
            L2++;
            head2 = head2.next;
        }
        if(L1 <L2){
            head1 = headB;head2 = headA;diff =L2- L1;
        }else{
            head1 = headA;head2 = headB;diff =L1- L2;
        }
        for(int i = 0; i < diff; i++) {
            head1 = head1.next;
        }
        while(head1 != null && head2 !=null) {
            if(head1 == head2) {
                return head1;
            }
            head1= head1.next;
            head2= head2.next;
        }
        return null;
    }
}
