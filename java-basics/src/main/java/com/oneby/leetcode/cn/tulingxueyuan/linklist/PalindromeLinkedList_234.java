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
        /*fast不为null，说明是奇数,如果链表是奇数个结点，把正中的归到左边*/
        //其实不加下面的这个奇数偶数判断也行，就是中间节点也被反转了，但是前后都有中间节点，多比较一次，效率稍微低一丢丢
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
    //

    //你的代码修改了原head指针， 建议用最下面的反转链表的方式，不修改原链表
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


    /**
     * 例子1：奇数链表 1→2→3→2→1
     * 原代码逻辑：
     * slow指向3
     * 反转：3→2→1 变为 1→2→3
     * 比较：
     * p1: 1→2→3→2→1
     * p2: 1→2→3
     * 比较过程：
     * 1=1, 2=2, 3=3 ✓
     * 结束（p2到null，但p1还有2→1没比较）
     *
     * 优化后的逻辑：
     * fast不为null，说明是奇数
     * slow = slow.next (slow从3移动到2)
     * 反转：2→1 变为 1→2
     * 比较：
     * p1: 1→2→3→2→1
     * p2: 1→2
     * 比较过程：
     * 1=1, 2=2 ✓
     *
     *
     * 例子2：偶数链表 1→2→2→1
     * 两种情况处理相同：
     * slow指向第二个2
     * 反转：2→1 变为 1→2
     * 比较：
     * p1: 1→2→2→1
     * p2: 1→2
     * 比较过程：
     * 1=1, 2=2 ✓
     */

    public boolean isPalindromeHuiFu(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // 1. 找到中点
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. 判断链表长度奇偶
        // 如果fast不为null，说明链表长度为奇数
        // 如果fast为null，说明链表长度为偶数
        if (fast != null) {
            // 奇数长度，slow正好在中间节点
            // 我们需要跳过中间节点，从它的下一个开始反转
            slow = slow.next;
        }

        // 3. 反转后半部分
        ListNode secondHalf = reverseList(slow);

        // 4. 比较前后两部分
        ListNode p1 = head;
        ListNode p2 = secondHalf;

        while (p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 5. 恢复链表（可选）
        reverseList(secondHalf);

        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
