package com.oneby.leetcode.cn.tulingxueyuan.linklist;

/**
 * @author ：Mark老师
 * @description ：(LeetCode-21)合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoSortLists_21 {

    /**
     *核心思想总结 其实就是3个指针，l1指针，l2指针，和新的链表的指针current
     * 哑节点(dummy)：避免处理空链表的特殊情况，让代码更简洁
     *
     * current指针：始终指向新链表的最后一个节点，方便接上新节点
     *
     * 比较接入：每次比较两个链表当前节点的值，把较小的接上去
     *
     * 处理剩余：当一个链表用完时，直接把另一个链表剩余部分接上
     *
     * 更简化的理解方式
     * 把合并过程想象成两个人排队：
     *
     * 有两个已经排好序的队伍（list1和list2）
     *
     * 你每次比较两个队伍最前面的人（当前节点）
     *
     * 把身高较矮的人（值较小的节点）选出来，排到新队伍里
     *
     * 直到一个队伍没人了，就把另一个队伍剩下的人全部接上
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        //通过比较，较小的拼接在dummy后面就行
        while(l1 !=null && l2 !=null) {
            if(l2.val <= l1.val) {
                current.next = l2;
                l2 = l2.next;
                current = current.next;
            } else {
                current.next = l1;
                l1 = l1.next;
                current = current.next;
            }
        }
        //如果没有下面的代码，另一个没有变null的节点会miss，所以需要连接剩余部分,也就是当其中一个为null是，把另一个凭借到最新链表的后面
        current.next = l1 == null? l2: l1;
        return dummy.next;

    }

    public static void main(String[] args) {

        // 创建链表 1->3->5
        ListNode list1 = new ListNode(1, new ListNode(3, new ListNode(5)));
        // 创建链表 2->4->6
        ListNode list2 = new ListNode(2, new ListNode(4, new ListNode(6)));

        ListNode result = mergeTwoLists(list1, list2);
        printList(result); // 输出: 1->2->3->4->5->6
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print("->");
            head = head.next;
        }
        System.out.println();
    }

    /*循环+双指针解决*/
    public ListNode mergeTwoListsLoop(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode resultNode  = new ListNode(0);
        ListNode p = resultNode ;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if(l1 != null)
            p.next = l1;
        if(l2 != null)
            p.next = l2;
        return resultNode.next;
    }

    /*递归解决*/
    public ListNode mergeTwoListsDugui(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }
}
